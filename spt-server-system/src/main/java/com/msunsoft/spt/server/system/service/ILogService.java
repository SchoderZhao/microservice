package com.msunsoft.spt.server.system.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msunsoft.spt.common.core.entity.QueryRequest;
import com.msunsoft.spt.common.core.entity.constant.SptConstant;
import com.msunsoft.spt.common.core.entity.system.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.lang.reflect.Method;

/**
 * @author Schoder
 */
public interface ILogService extends IService<Log> {

    /**
     * 查询操作日志分页
     *
     * @param log     日志
     * @param request QueryRequest
     * @return IPage<SystemLog>
     */
    IPage<Log> findLogs(Log log, QueryRequest request);

    /**
     * 删除操作日志
     *
     * @param logIds 日志 ID集合
     */
    void deleteLogs(String[] logIds);

    /**
     * 异步保存操作日志
     *
     * @param point     切点
     * @param method    Method
     * @param ip        ip
     * @param operation 操作内容
     * @param username  操作用户
     * @param start     开始时间
     */
    @Async(SptConstant.ASYNC_POOL)
    void saveLog(ProceedingJoinPoint point, Method method, String ip, String operation, String username, long start);
}
