package com.msunsoft.spt.common.security.starter.handler;


import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.utils.SptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Schoder
 */
@Slf4j
public class SptAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        String requestUri = request.getRequestURI();
        int status = HttpServletResponse.SC_UNAUTHORIZED;
        String message = "访问令牌不合法";
        log.error("客户端访问{}请求失败: {}", requestUri, message, authException);
        SptUtil.makeJsonResponse(response, status, new SptResponse().message(message));
    }
}
