package com.msunsoft.spt.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Schoder
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:spt-auth.properties"})
@ConfigurationProperties(prefix = "spt.auth")
public class SptAuthProperties {
    /**
     * 验证码配置
     */
    private SptValidateCodeProperties code = new SptValidateCodeProperties();
    /**
     * JWT加签密钥
     */
    private String jwtAccessKey;
    /**
     * 是否使用 JWT令牌
     */
    private Boolean enableJwt;

    /**
     * 社交登录所使用的 Client
     */
    private String socialLoginClientId;
}
