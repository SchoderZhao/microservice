package com.msunsoft.spt.server.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msunsoft.spt.common.core.entity.system.DataPermissionTest;
import com.msunsoft.spt.common.datasource.starter.annotation.DataPermission;

/**
 * @author Schoder
 */
@DataPermission(methods = {"selectPage"})
public interface DataPermissionTestMapper extends BaseMapper<DataPermissionTest> {

}
