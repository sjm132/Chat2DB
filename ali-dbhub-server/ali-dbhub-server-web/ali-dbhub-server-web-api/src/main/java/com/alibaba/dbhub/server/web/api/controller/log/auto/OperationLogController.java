package com.alibaba.dbhub.server.web.api.controller.log.auto;

import java.util.List;

import com.alibaba.dbhub.server.domain.api.model.OperationLog;
import com.alibaba.dbhub.server.domain.api.param.OperationLogCreateParam;
import com.alibaba.dbhub.server.domain.api.param.OperationLogPageQueryParam;
import com.alibaba.dbhub.server.domain.api.service.OperationLogService;
import com.alibaba.dbhub.server.tools.base.wrapper.result.DataResult;
import com.alibaba.dbhub.server.tools.base.wrapper.result.PageResult;
import com.alibaba.dbhub.server.tools.base.wrapper.result.web.WebPageResult;
import com.alibaba.dbhub.server.web.api.aspect.BusinessExceptionAspect;
import com.alibaba.dbhub.server.web.api.controller.log.auto.converter.OperationLogWebConverter;
import com.alibaba.dbhub.server.web.api.controller.log.auto.request.OperationLogCreateRequest;
import com.alibaba.dbhub.server.web.api.controller.log.auto.request.OperationLogQueryRequest;
import com.alibaba.dbhub.server.web.api.controller.log.auto.vo.OperationLogVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 历史记录服务类
 *
 * @author moji
 * @version HistoryManageController.java, v 0.1 2022年09月18日 10:55 moji Exp $
 * @date 2022/09/18
 */
@BusinessExceptionAspect
@RequestMapping("/api/operation/log")
@RestController
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private OperationLogWebConverter operationLogWebConverter;

    /**
     * 查询执行记录
     *
     * @param request
     * @return
     */
    @GetMapping("/list")
    public WebPageResult<OperationLogVO> list(OperationLogQueryRequest request) {
        OperationLogPageQueryParam param = operationLogWebConverter.req2param(request);
        PageResult<OperationLog> result = operationLogService.queryPage(param);
        List<OperationLogVO> operationLogVOList = operationLogWebConverter.dto2vo(result.getData());
        return WebPageResult.of(operationLogVOList, result.getTotal(), result.getPageNo(), result.getPageSize());
    }

    /**
     * 新增历史记录
     *
     * @param request
     * @return
     */
    @PostMapping("/create")
    public DataResult<Long> create(@RequestBody OperationLogCreateRequest request) {
        OperationLogCreateParam param = operationLogWebConverter.createReq2param(request);
        return operationLogService.create(param);
    }

}
