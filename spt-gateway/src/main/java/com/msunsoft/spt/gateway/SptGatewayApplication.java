package com.msunsoft.spt.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Schoder
 */
@SpringBootApplication
public class SptGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SptGatewayApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
