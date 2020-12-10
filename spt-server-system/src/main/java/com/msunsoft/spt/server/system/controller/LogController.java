package com.msunsoft.spt.server.system.controller;


import com.msunsoft.spt.common.core.entity.QueryRequest;
import com.msunsoft.spt.common.core.entity.SptResponse;
import com.msunsoft.spt.common.core.entity.constant.StringConstant;
import com.msunsoft.spt.common.core.entity.system.Log;
import com.msunsoft.spt.common.core.utils.SptUtil;
import com.msunsoft.spt.server.system.annotation.ControllerEndpoint;
import com.msunsoft.spt.server.system.service.ILogService;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author Schoder
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("log")
public class LogController {

    private final ILogService logService;

    @GetMapping
    public SptResponse logList(Log log, QueryRequest request) {
        Map<String, Object> dataTable = SptUtil.getDataTable(this.logService.findLogs(log, request));
        return new SptResponse().data(dataTable);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('log:delete')")
    @ControllerEndpoint(exceptionMessage = "删除日志失败")
    public void deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] logIds = ids.split(StringConstant.COMMA);
        this.logService.deleteLogs(logIds);
    }


    @PostMapping("excel")
    @PreAuthorize("hasAuthority('log:export')")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, Log lg, HttpServletResponse response) {
        List<Log> logs = this.logService.findLogs(lg, request).getRecords();
        ExcelKit.$Export(Log.class, response).downXlsx(logs, false);
    }
}
