package com.msunsoft.spt.server.hncollection.handler;


import com.msunsoft.spt.common.core.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Schoder
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends BaseExceptionHandler {
}
