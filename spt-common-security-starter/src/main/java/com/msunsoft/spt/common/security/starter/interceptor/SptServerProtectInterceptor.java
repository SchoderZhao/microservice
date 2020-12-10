package com.msunsoft.spt.common.security.starter.interceptor;


import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.constant.SptConstant;
import com.msunsoft.spt.common.core.utils.SptUtil;
import com.msunsoft.spt.common.security.starter.properties.SptCloudSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Schoder
 */
public class SptServerProtectInterceptor implements HandlerInterceptor {

    private SptCloudSecurityProperties properties;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws IOException {
        if (!properties.getOnlyFetchByGateway()) {
            return true;
        }
        String token = request.getHeader(SptConstant.GATEWAY_TOKEN_HEADER);
        String gatewayToken = new String(Base64Utils.encode(SptConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        if (StringUtils.equals(gatewayToken, token)) {
            return true;
        } else {
            SptResponse sptResponse = new SptResponse();
            SptUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, sptResponse.message("请通过网关获取资源"));
            return false;
        }
    }

    public void setProperties(SptCloudSecurityProperties properties) {
        this.properties = properties;
    }
}
