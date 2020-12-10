package com.msunsoft.spt.tx.manager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Schoder
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class SptTxManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptTxManagerApplication.class, args);
    }

}
