package com.msunsoft.spt.server.system.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msunsoft.spt.common.core.entity.QueryRequest;
import com.msunsoft.spt.common.core.entity.system.Eximport;

import java.util.List;

/**
 * @author Schoder
 */
public interface IEximportService extends IService<Eximport> {
    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param eximport eximport
     * @return IPage<Eximport>
     */
    IPage<Eximport> findEximports(QueryRequest request, Eximport eximport);


    /**
     * 批量插入
     *
     * @param list List<Eximport>
     */
    void batchInsert(List<Eximport> list);

}
