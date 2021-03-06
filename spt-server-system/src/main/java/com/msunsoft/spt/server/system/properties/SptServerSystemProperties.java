package com.msunsoft.spt.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Schoder
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:spt-server-system.properties"})
@ConfigurationProperties(prefix = "spt.server.system")
public class SptServerSystemProperties {
    /**
     * 批量插入当批次可插入的最大值
     */
    private Integer batchInsertMaxNum = 1000;
}
