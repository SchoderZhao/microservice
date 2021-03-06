package com.msunsoft.spt.common.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Schoder
 */
@ConfigurationProperties(prefix = "spt.lettuce.redis")
public class SptLettuceRedisProperties {

    /**
     * 是否开启Lettuce Redis
     */
    private Boolean enable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "SptLettuceRedisProperties{" +
                "enable=" + enable +
                '}';
    }
}
