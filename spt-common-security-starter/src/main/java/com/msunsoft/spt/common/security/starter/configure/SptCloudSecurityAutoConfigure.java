package com.msunsoft.spt.common.security.starter.configure;

import com.msunsoft.spt.common.core.entity.constant.SptConstant;
import com.msunsoft.spt.common.core.utils.SptUtil;
import com.msunsoft.spt.common.security.starter.handler.SptAccessDeniedHandler;
import com.msunsoft.spt.common.security.starter.handler.SptAuthExceptionEntryPoint;
import com.msunsoft.spt.common.security.starter.properties.SptCloudSecurityProperties;
import feign.RequestInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.util.Base64Utils;

/**
 * @author Schoder
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(SptCloudSecurityProperties.class)
@ConditionalOnProperty(value = "spt.cloud.security.enable", havingValue = "true", matchIfMissing = true)
public class SptCloudSecurityAutoConfigure extends GlobalMethodSecurityConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public SptAccessDeniedHandler accessDeniedHandler() {
        return new SptAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public SptAuthExceptionEntryPoint authenticationEntryPoint() {
        return new SptAuthExceptionEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SptCloudSecurityInteceptorConfigure sptCloudSecurityInteceptorConfigure() {
        return new SptCloudSecurityInteceptorConfigure();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(DefaultTokenServices.class)
    public SptUserInfoTokenServices sptUserInfoTokenServices(ResourceServerProperties properties) {
        return new SptUserInfoTokenServices(properties.getUserInfoUri(), properties.getClientId());
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            String gatewayToken = new String(Base64Utils.encode(SptConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(SptConstant.GATEWAY_TOKEN_HEADER, gatewayToken);
            String authorizationToken = SptUtil.getCurrentTokenValue();
            if (StringUtils.isNotBlank(authorizationToken)) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, SptConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
            }
        };
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
