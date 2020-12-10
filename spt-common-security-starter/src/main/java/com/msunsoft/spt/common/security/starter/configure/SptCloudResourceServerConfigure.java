package com.msunsoft.spt.common.security.starter.configure;

import com.msunsoft.spt.common.core.entity.constant.StringConstant;
import com.msunsoft.spt.common.security.starter.handler.SptAccessDeniedHandler;
import com.msunsoft.spt.common.security.starter.handler.SptAuthExceptionEntryPoint;
import com.msunsoft.spt.common.security.starter.properties.SptCloudSecurityProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Schoder
 */
@EnableResourceServer
@EnableAutoConfiguration(exclude = UserDetailsServiceAutoConfiguration.class)
public class SptCloudResourceServerConfigure extends ResourceServerConfigurerAdapter {

    private SptCloudSecurityProperties properties;
    private SptAccessDeniedHandler accessDeniedHandler;
    private SptAuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    public void setProperties(SptCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Autowired
    public void setAccessDeniedHandler(SptAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired
    public void setExceptionEntryPoint(SptAuthExceptionEntryPoint exceptionEntryPoint) {
        this.exceptionEntryPoint = exceptionEntryPoint;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUris(), StringConstant.COMMA);
        if (ArrayUtils.isEmpty(anonUrls)) {
            anonUrls = new String[]{};
        }

        http.csrf().disable()
                .requestMatchers().antMatchers(properties.getAuthUri())
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers(properties.getAuthUri()).authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
