package com.msunsoft.spt.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Schoder
 */
@EnableAdminServer
@SpringBootApplication
public class SptAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptAdminApplication.class, args);
    }

}
