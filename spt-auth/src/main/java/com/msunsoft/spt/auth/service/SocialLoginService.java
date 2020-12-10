package com.msunsoft.spt.auth.service;

import com.msunsoft.spt.auth.entity.BindUser;
import com.msunsoft.spt.auth.entity.UserConnection;
import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.exception.SptException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.List;

/**
 * @author Schoder
 */
public interface SocialLoginService {

    /**
     * 解析第三方登录请求
     *
     * @param oauthType 第三方平台类型
     * @return AuthRequest
     * @throws SptException 异常
     */
    AuthRequest renderAuth(String oauthType) throws SptException;

    /**
     * 处理第三方登录（绑定页面）
     *
     * @param oauthType 第三方平台类型
     * @param callback  回调
     * @return SptResponse
     * @throws SptException 异常
     */
    SptResponse resolveBind(String oauthType, AuthCallback callback) throws SptException;

    /**
     * 处理第三方登录（登录页面）
     *
     * @param oauthType 第三方平台类型
     * @param callback  回调
     * @return SptResponse
     * @throws SptException 异常
     */
    SptResponse resolveLogin(String oauthType, AuthCallback callback) throws SptException;

    /**
     * 绑定并登录
     *
     * @param bindUser 绑定用户
     * @param authUser 第三方平台对象
     * @return OAuth2AccessToken 令牌对象
     * @throws SptException 异常
     */
    OAuth2AccessToken bindLogin(BindUser bindUser, AuthUser authUser) throws SptException;

    /**
     * 注册并登录
     *
     * @param registUser 注册用户
     * @param authUser   第三方平台对象
     * @return OAuth2AccessToken 令牌对象
     * @throws SptException 异常
     */
    OAuth2AccessToken signLogin(BindUser registUser, AuthUser authUser) throws SptException;

    /**
     * 绑定
     *
     * @param bindUser 绑定对象
     * @param authUser 第三方平台对象
     * @throws SptException 异常
     */
    void bind(BindUser bindUser, AuthUser authUser) throws SptException;

    /**
     * 解绑
     *
     * @param bindUser  绑定对象
     * @param oauthType 第三方平台对象
     * @throws SptException 异常
     */
    void unbind(BindUser bindUser, String oauthType) throws SptException;

    /**
     * 根据用户名获取绑定关系
     *
     * @param username 用户名
     * @return 绑定关系集合
     */
    List<UserConnection> findUserConnections(String username);
}
