package com.msunsoft.spt.common.security.starter.annotation;

import com.msunsoft.spt.common.security.starter.configure.SptCloudResourceServerConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Schoder
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SptCloudResourceServerConfigure.class)
public @interface EnableSptCloudResourceServer {
}
