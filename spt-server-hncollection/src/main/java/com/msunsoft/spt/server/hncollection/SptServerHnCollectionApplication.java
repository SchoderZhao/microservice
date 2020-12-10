package com.msunsoft.spt.server.hncollection;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.msunsoft.spt.common.security.starter.annotation.EnableSptCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Schoder
 */
@EnableAsync
@SpringBootApplication
@EnableSptCloudResourceServer
@EnableTransactionManagement
@EnableDistributedTransaction
@MapperScan("com.msunsoft.spt.server.hncollection.mapper")
public class SptServerHnCollectionApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SptServerHnCollectionApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
