package com.msunsoft.spt.server.hncollection.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Schoder
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:spt-server-hncollection.properties"})
@ConfigurationProperties(prefix = "spt.server.hncollection")
public class SptServeHnCollectionProperties {
    /**
     * 批量插入当批次可插入的最大值
     */
    private Integer batchInsertMaxNum = 1000;
}
