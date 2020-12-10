package com.msunsoft.spt.auth.service.impl;

import com.msunsoft.spt.auth.entity.BindUser;
import com.msunsoft.spt.auth.entity.UserConnection;
import com.msunsoft.spt.auth.manager.UserManager;
import com.msunsoft.spt.auth.properties.SptAuthProperties;
import com.msunsoft.spt.auth.service.SocialLoginService;
import com.msunsoft.spt.auth.service.UserConnectionService;
import cn.hutool.core.util.StrUtil;
import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.constant.GrantTypeConstant;
import com.msunsoft.spt.common.core.entity.constant.ParamsConstant;
import com.msunsoft.spt.common.core.entity.constant.SocialConstant;
import com.msunsoft.spt.common.core.entity.constant.StringConstant;
import com.msunsoft.spt.common.core.entity.system.SystemUser;
import com.msunsoft.spt.common.core.exception.SptException;
import com.msunsoft.spt.common.core.utils.SptUtil;
import com.xkcoding.justauth.AuthRequestFactory;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Schoder
 */
@Service
@RequiredArgsConstructor
public class SocialLoginServiceImpl implements SocialLoginService {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String NOT_BIND = "not_bind";
    private static final String SOCIAL_LOGIN_SUCCESS = "social_login_success";

    private final UserManager userManager;
    private final AuthRequestFactory factory;
    private final SptAuthProperties properties;
    private final PasswordEncoder passwordEncoder;
    private final UserConnectionService userConnectionService;
    private final ResourceOwnerPasswordTokenGranter granter;
    private final RedisClientDetailsService redisClientDetailsService;

    @Override
    public AuthRequest renderAuth(String oauthType) throws SptException {
        return factory.get(getAuthSource(oauthType));
    }

    @Override
    public SptResponse resolveBind(String oauthType, AuthCallback callback) throws SptException {
        SptResponse sptResponse = new SptResponse();
        AuthRequest authRequest = factory.get(getAuthSource(oauthType));
        AuthResponse<?> response = authRequest.login(resolveAuthCallback(callback));
        if (response.ok()) {
            sptResponse.data(response.getData());
        } else {
            throw new SptException(String.format("第三方登录失败，%s", response.getMsg()));
        }
        return sptResponse;
    }

    @Override
    public SptResponse resolveLogin(String oauthType, AuthCallback callback) throws SptException {
        SptResponse sptResponse = new SptResponse();
        AuthRequest authRequest = factory.get(getAuthSource(oauthType));
        AuthResponse<?> response = authRequest.login(resolveAuthCallback(callback));
        if (response.ok()) {
            AuthUser authUser = (AuthUser) response.getData();
            UserConnection userConnection = userConnectionService.selectByCondition(authUser.getSource().toString(), authUser.getUuid());
            if (userConnection == null) {
                sptResponse.message(NOT_BIND).data(authUser);
            } else {
                SystemUser user = userManager.findByName(userConnection.getUserName());
                if (user == null) {
                    throw new SptException("系统中未找到与第三方账号对应的账户");
                }
                OAuth2AccessToken oAuth2AccessToken = getOauth2AccessToken(user);
                sptResponse.message(SOCIAL_LOGIN_SUCCESS).data(oAuth2AccessToken);
                sptResponse.put(USERNAME, user.getUsername());
            }
        } else {
            throw new SptException(String.format("第三方登录失败，%s", response.getMsg()));
        }
        return sptResponse;
    }

    @Override
    public OAuth2AccessToken bindLogin(BindUser bindUser, AuthUser authUser) throws SptException {
        SystemUser systemUser = userManager.findByName(bindUser.getBindUsername());
        if (systemUser == null || !passwordEncoder.matches(bindUser.getBindPassword(), systemUser.getPassword())) {
            throw new SptException("绑定系统账号失败，用户名或密码错误！");
        }
        this.createConnection(systemUser, authUser);
        return this.getOauth2AccessToken(systemUser);
    }

    @Override
    public OAuth2AccessToken signLogin(BindUser registUser, AuthUser authUser) throws SptException {
        SystemUser user = this.userManager.findByName(registUser.getBindUsername());
        if (user != null) {
            throw new SptException("该用户名已存在！");
        }
        String encryptPassword = passwordEncoder.encode(registUser.getBindPassword());
        SystemUser systemUser = this.userManager.registUser(registUser.getBindUsername(), encryptPassword);
        this.createConnection(systemUser, authUser);
        return this.getOauth2AccessToken(systemUser);
    }

    @Override
    public void bind(BindUser bindUser, AuthUser authUser) throws SptException {
        String username = bindUser.getBindUsername();
        if (isCurrentUser(username)) {
            UserConnection userConnection = userConnectionService.selectByCondition(authUser.getSource().toString(), authUser.getUuid());
            if (userConnection != null) {
                throw new SptException("绑定失败，该第三方账号已绑定" + userConnection.getUserName() + "系统账户");
            }
            SystemUser systemUser = new SystemUser();
            systemUser.setUsername(username);
            this.createConnection(systemUser, authUser);
        } else {
            throw new SptException("绑定失败，您无权绑定别人的账号");
        }
    }

    @Override
    public void unbind(BindUser bindUser, String oauthType) throws SptException {
        String username = bindUser.getBindUsername();
        if (isCurrentUser(username)) {
            this.userConnectionService.deleteByCondition(username, oauthType);
        } else {
            throw new SptException("解绑失败，您无权解绑别人的账号");
        }
    }

    @Override
    public List<UserConnection> findUserConnections(String username) {
        return this.userConnectionService.selectByCondition(username);
    }

    private void createConnection(SystemUser systemUser, AuthUser authUser) {
        UserConnection userConnection = new UserConnection();
        userConnection.setUserName(systemUser.getUsername());
        userConnection.setProviderName(authUser.getSource().toString());
        userConnection.setProviderUserId(authUser.getUuid());
        userConnection.setProviderUserName(authUser.getUsername());
        userConnection.setImageUrl(authUser.getAvatar());
        userConnection.setNickName(authUser.getNickname());
        userConnection.setLocation(authUser.getLocation());
        this.userConnectionService.createUserConnection(userConnection);
    }

    private AuthCallback resolveAuthCallback(AuthCallback callback) {
        int stateLength = 3;
        String state = callback.getState();
        String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(state, StringConstant.DOUBLE_COLON);
        if (strings.length == stateLength) {
            callback.setState(strings[0] + StringConstant.DOUBLE_COLON + strings[1]);
        }
        return callback;
    }

    private AuthSource getAuthSource(String type) throws SptException {
        if (StrUtil.isNotBlank(type)) {
            return AuthSource.valueOf(type.toUpperCase());
        } else {
            throw new SptException(String.format("暂不支持%s第三方登录", type));
        }
    }

    private boolean isCurrentUser(String username) {
        String currentUsername = SptUtil.getCurrentUsername();
        return StringUtils.equalsIgnoreCase(username, currentUsername);
    }

    private OAuth2AccessToken getOauth2AccessToken(SystemUser user) throws SptException {
        final HttpServletRequest httpServletRequest = SptUtil.getHttpServletRequest();
        httpServletRequest.setAttribute(ParamsConstant.LOGIN_TYPE, SocialConstant.SOCIAL_LOGIN);
        String socialLoginClientId = properties.getSocialLoginClientId();
        ClientDetails clientDetails = null;
        try {
            clientDetails = redisClientDetailsService.loadClientByClientId(socialLoginClientId);
        } catch (Exception e) {
            throw new SptException("获取第三方登录可用的Client失败");
        }
        if (clientDetails == null) {
            throw new SptException("未找到第三方登录可用的Client");
        }
        Map<String, String> requestParameters = new HashMap<>(5);
        requestParameters.put(ParamsConstant.GRANT_TYPE, GrantTypeConstant.PASSWORD);
        requestParameters.put(USERNAME, user.getUsername());
        requestParameters.put(PASSWORD, SocialConstant.setSocialLoginPassword());

        String grantTypes = String.join(StringConstant.COMMA, clientDetails.getAuthorizedGrantTypes());
        TokenRequest tokenRequest = new TokenRequest(requestParameters, clientDetails.getClientId(), clientDetails.getScope(), grantTypes);
        return granter.grant(GrantTypeConstant.PASSWORD, tokenRequest);
    }
}
