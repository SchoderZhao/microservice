package com.msunsoft.spt.server.system.controller;

import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.system.TradeLog;
import com.msunsoft.spt.server.system.service.ITradeLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Schoder
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final ITradeLogService tradeLogService;

    @PostMapping("package/send")
    public void packageSend(@RequestBody TradeLog tradeLog) {
        this.tradeLogService.packageAndSend(tradeLog);
    }

    @GetMapping("scope/test")
    @PreAuthorize("#oauth2.hasScope('write')")
    public SptResponse testScope() {
        return new SptResponse().message("当前client包含write scope");
    }
}
