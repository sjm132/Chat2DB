package com.alibaba.dbhub.server.web.api.controller.log.auto.converter;

import java.util.List;

import com.alibaba.dbhub.server.domain.api.model.OperationLog;
import com.alibaba.dbhub.server.domain.api.param.OperationLogCreateParam;
import com.alibaba.dbhub.server.domain.api.param.OperationLogPageQueryParam;
import com.alibaba.dbhub.server.web.api.controller.log.auto.request.OperationLogCreateRequest;
import com.alibaba.dbhub.server.web.api.controller.log.auto.request.OperationLogQueryRequest;
import com.alibaba.dbhub.server.web.api.controller.log.auto.vo.OperationLogVO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author moji
 * @version HistoryWebConverter.java, v 0.1 2022年09月25日 16:53 moji Exp $
 * @date 2022/09/25
 */
@Mapper(componentModel = "spring")
public abstract class OperationLogWebConverter {

    /**
     * 参数转换
     *
     * @param request
     * @return
     */
    public abstract OperationLogCreateParam createReq2param(OperationLogCreateRequest request);

    /**
     * 参数转换
     *
     * @param request
     * @return
     */
    public abstract OperationLogPageQueryParam req2param(OperationLogQueryRequest request);

    /**
     * 模型转换
     *
     * @param ddlDTO
     * @return
     */
    @Mappings({
        @Mapping(source = "ddl", target = "name")
    })
    public abstract OperationLogVO dto2vo(OperationLog ddlDTO);

    /**
     * 模型转换
     *
     * @param ddlDTOS
     * @return
     */
    public abstract List<OperationLogVO> dto2vo(List<OperationLog> ddlDTOS);
}
