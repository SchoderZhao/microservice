package com.msunsoft.spt.gateway.enhance.configure;


import com.msunsoft.spt.common.core.entity.constant.SptConstant;
import com.msunsoft.spt.gateway.enhance.runner.SptRouteEnhanceRunner;
import com.msunsoft.spt.gateway.enhance.service.BlackListService;
import com.msunsoft.spt.gateway.enhance.service.RateLimitRuleService;
import com.msunsoft.spt.gateway.enhance.service.RouteEnhanceCacheService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Schoder
 */
@EnableAsync
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.msunsoft.spt.gateway.enhance.mapper")
@ConditionalOnProperty(name = "spt.gateway.enhance", havingValue = "true")
public class SptRouteEnhanceConfigure {

    @Bean(SptConstant.ASYNC_POOL)
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("Spt-Gateway-Async-Thread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean
    public ApplicationRunner sptRouteEnhanceRunner(RouteEnhanceCacheService cacheService,
                                                    BlackListService blackListService,
                                                    RateLimitRuleService rateLimitRuleService) {
        return new SptRouteEnhanceRunner(cacheService, blackListService, rateLimitRuleService);
    }
}
