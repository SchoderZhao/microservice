package com.msunsoft.spt.server.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.msunsoft.spt.common.core.entity.system.TradeLog;

/**
 * @author Schoder
 */
public interface ITradeLogService extends IService<TradeLog> {

    /**
     * 打包并派送
     *
     * @param tradeLog 交易日志
     */
    void packageAndSend(TradeLog tradeLog);
}
