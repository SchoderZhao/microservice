package com.msunsoft.spt.auth;

import com.msunsoft.spt.common.security.starter.annotation.EnableSptCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Schoder
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableSptCloudResourceServer
@MapperScan("com.msunsoft.spt.auth.mapper")
public class SptAuthApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SptAuthApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
