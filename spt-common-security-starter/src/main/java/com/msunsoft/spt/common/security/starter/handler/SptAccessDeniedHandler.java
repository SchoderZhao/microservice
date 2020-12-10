package com.msunsoft.spt.common.security.starter.handler;

import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.utils.SptUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Schoder
 */
public class SptAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        SptResponse sptResponse = new SptResponse();
        SptUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, sptResponse.message("没有权限访问该资源"));
    }
}
