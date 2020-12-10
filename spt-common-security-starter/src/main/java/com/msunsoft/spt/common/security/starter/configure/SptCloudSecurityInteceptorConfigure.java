package com.msunsoft.spt.common.security.starter.configure;

import com.msunsoft.spt.common.security.starter.interceptor.SptServerProtectInterceptor;
import com.msunsoft.spt.common.security.starter.properties.SptCloudSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Schoder
 */
public class SptCloudSecurityInteceptorConfigure implements WebMvcConfigurer {

    private SptCloudSecurityProperties properties;

    @Autowired
    public void setProperties(SptCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public HandlerInterceptor sptServerProtectInterceptor() {
        SptServerProtectInterceptor sptServerProtectInterceptor = new SptServerProtectInterceptor();
        sptServerProtectInterceptor.setProperties(properties);
        return sptServerProtectInterceptor;
    }

    @Override
    @SuppressWarnings("all")
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sptServerProtectInterceptor());
    }
}
