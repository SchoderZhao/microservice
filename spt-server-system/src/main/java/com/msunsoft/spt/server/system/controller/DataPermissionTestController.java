package com.msunsoft.spt.server.system.controller;

import com.msunsoft.spt.common.core.entity.QueryRequest;
import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.system.DataPermissionTest;
import com.msunsoft.spt.common.core.utils.SptUtil;
import com.msunsoft.spt.server.system.service.IDataPermissionTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller
 *
 * @author Schoder
 * @date 2020-04-14 15:25:33
 */
@Slf4j
@RestController
@RequestMapping("dataPermissionTest")
@RequiredArgsConstructor
public class DataPermissionTestController {

    private final IDataPermissionTestService dataPermissionTestService;

    @GetMapping("list")
    @PreAuthorize("hasAuthority('others:datapermission')")
    public SptResponse dataPermissionTestList(QueryRequest request, DataPermissionTest dataPermissionTest) {
        Map<String, Object> dataTable = SptUtil.getDataTable(this.dataPermissionTestService.findDataPermissionTests(request, dataPermissionTest));
        return new SptResponse().data(dataTable);
    }
}
