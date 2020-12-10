package com.msunsoft.spt.gateway.enhance.runner;

import com.msunsoft.spt.gateway.enhance.service.BlackListService;
import com.msunsoft.spt.gateway.enhance.service.RateLimitRuleService;
import com.msunsoft.spt.gateway.enhance.service.RouteEnhanceCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author Schoder
 */
@RequiredArgsConstructor
public class SptRouteEnhanceRunner implements ApplicationRunner {

    private final RouteEnhanceCacheService cacheService;
    private final BlackListService blackListService;
    private final RateLimitRuleService rateLimitRuleService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("已开启网关增强功能：请求日志、黑名单&限流。");
        cacheService.saveAllBlackList(blackListService.findAll());
        cacheService.saveAllRateLimitRules(rateLimitRuleService.findAll());
    }
}
