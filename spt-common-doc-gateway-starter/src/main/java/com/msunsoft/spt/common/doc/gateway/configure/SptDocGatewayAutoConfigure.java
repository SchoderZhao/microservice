package com.msunsoft.spt.common.doc.gateway.configure;

import com.msunsoft.spt.common.doc.gateway.filter.SptDocGatewayHeaderFilter;
import com.msunsoft.spt.common.doc.gateway.handler.SptDocGatewayHandler;
import com.msunsoft.spt.common.doc.gateway.properties.SptDocGatewayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * @author Schoder
 */
@Configuration
@EnableConfigurationProperties(SptDocGatewayProperties.class)
@ConditionalOnProperty(value = "spt.doc.gateway.enable", havingValue = "true", matchIfMissing = true)
public class SptDocGatewayAutoConfigure {

    private final SptDocGatewayProperties sptDocGatewayProperties;
    private SecurityConfiguration securityConfiguration;
    private UiConfiguration uiConfiguration;

    public SptDocGatewayAutoConfigure(SptDocGatewayProperties sptDocGatewayProperties) {
        this.sptDocGatewayProperties = sptDocGatewayProperties;
    }

    @Autowired(required = false)
    public void setSecurityConfiguration(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

    @Autowired(required = false)
    public void setUiConfiguration(UiConfiguration uiConfiguration) {
        this.uiConfiguration = uiConfiguration;
    }

    @Bean
    public SptDocGatewayResourceConfigure sptDocGatewayResourceConfigure(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        return new SptDocGatewayResourceConfigure(routeLocator, gatewayProperties);
    }

    @Bean
    public SptDocGatewayHeaderFilter sptDocGatewayHeaderFilter() {
        return new SptDocGatewayHeaderFilter();
    }

    @Bean
    public SptDocGatewayHandler sptDocGatewayHandler(SwaggerResourcesProvider swaggerResources) {
        SptDocGatewayHandler sptDocGatewayHandler = new SptDocGatewayHandler();
        sptDocGatewayHandler.setSecurityConfiguration(securityConfiguration);
        sptDocGatewayHandler.setUiConfiguration(uiConfiguration);
        sptDocGatewayHandler.setSwaggerResources(swaggerResources);
        sptDocGatewayHandler.setProperties(sptDocGatewayProperties);
        return sptDocGatewayHandler;
    }
}
