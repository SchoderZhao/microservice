package com.msunsoft.spt.auth.controller;

import com.msunsoft.spt.auth.entity.BindUser;
import com.msunsoft.spt.auth.entity.UserConnection;
import com.msunsoft.spt.auth.service.SocialLoginService;
import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.constant.StringConstant;
import com.msunsoft.spt.common.core.exception.SptException;
import com.msunsoft.spt.common.core.utils.SptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

/**
 * @author Schoder
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("social")
public class SocialLoginController {

    private static final String TYPE_LOGIN = "login";
    private static final String TYPE_BIND = "bind";

    private final SocialLoginService socialLoginService;
    @Value("${spt.frontUrl}")
    private String frontUrl;


    /**
     * 登录
     *
     * @param oauthType 第三方登录类型
     * @param response  response
     */
    @ResponseBody
    @GetMapping("/login/{oauthType}/{type}")
    public void renderAuth(@PathVariable String oauthType, @PathVariable String type, HttpServletResponse response) throws IOException, SptException {
        AuthRequest authRequest = socialLoginService.renderAuth(oauthType);
        response.sendRedirect(authRequest.authorize(oauthType + StringConstant.DOUBLE_COLON + AuthStateUtils.createState()) + "::" + type);
    }

    /**
     * 登录成功后的回调
     *
     * @param oauthType 第三方登录类型
     * @param callback  携带返回的信息
     * @return String
     */
    @GetMapping("/{oauthType}/callback")
    public String login(@PathVariable String oauthType, AuthCallback callback, String state, Model model) {
        try {
            SptResponse sptResponse = null;
            String type = StringUtils.substringAfterLast(state, StringConstant.DOUBLE_COLON);
            if (StringUtils.equals(type, TYPE_BIND)) {
                sptResponse = socialLoginService.resolveBind(oauthType, callback);
            } else {
                sptResponse = socialLoginService.resolveLogin(oauthType, callback);
            }
            model.addAttribute("response", sptResponse);
            model.addAttribute("frontUrl", frontUrl);
            return "result";
        } catch (Exception e) {
            String errorMessage = SptUtil.containChinese(e.getMessage()) ? e.getMessage() : "第三方登录失败";
            model.addAttribute("error", e.getMessage());
            return "fail";
        }
    }

    /**
     * 绑定并登录
     *
     * @param bindUser bindUser
     * @param authUser authUser
     * @return SptResponse
     */
    @ResponseBody
    @PostMapping("bind/login")
    public SptResponse bindLogin(@Valid BindUser bindUser, AuthUser authUser) throws SptException {
        OAuth2AccessToken oAuth2AccessToken = this.socialLoginService.bindLogin(bindUser, authUser);
        return new SptResponse().data(oAuth2AccessToken);
    }

    /**
     * 注册并登录
     *
     * @param registUser registUser
     * @param authUser   authUser
     * @return SptResponse
     */
    @ResponseBody
    @PostMapping("sign/login")
    public SptResponse signLogin(@Valid BindUser registUser, AuthUser authUser) throws SptException {
        OAuth2AccessToken oAuth2AccessToken = this.socialLoginService.signLogin(registUser, authUser);
        return new SptResponse().data(oAuth2AccessToken);
    }

    /**
     * 绑定
     *
     * @param bindUser bindUser
     * @param authUser authUser
     */
    @ResponseBody
    @PostMapping("bind")
    public void bind(BindUser bindUser, AuthUser authUser) throws SptException {
        this.socialLoginService.bind(bindUser, authUser);
    }

    /**
     * 解绑
     *
     * @param bindUser  bindUser
     * @param oauthType oauthType
     */
    @ResponseBody
    @DeleteMapping("unbind")
    public void unbind(BindUser bindUser, String oauthType) throws SptException {
        this.socialLoginService.unbind(bindUser, oauthType);
    }

    /**
     * 根据用户名获取绑定关系
     *
     * @param username 用户名
     * @return SptResponse
     */
    @ResponseBody
    @GetMapping("connections/{username}")
    public SptResponse findUserConnections(@NotBlank(message = "{required}") @PathVariable String username) {
        List<UserConnection> userConnections = this.socialLoginService.findUserConnections(username);
        return new SptResponse().data(userConnections);
    }
}
