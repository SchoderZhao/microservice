package com.msunsoft.spt.gateway.enhance.utils;


import com.msunsoft.spt.common.core.entity.QueryRequest;
import com.msunsoft.spt.common.core.entity.constant.SptConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

/**
 * @author Schoder
 */
public class PageableExecutionUtil {

    public static <Spt> Flux<Spt> getPages(Query query, QueryRequest request, Class<Spt> clazz,
                                             ReactiveMongoTemplate template) {
        Sort sort = Sort.by("id").descending();
        if (StringUtils.isNotBlank(request.getField()) && StringUtils.isNotBlank(request.getOrder())) {
            sort = SptConstant.ORDER_ASC.equals(request.getOrder()) ?
                    Sort.by(request.getField()).ascending() :
                    Sort.by(request.getField()).descending();
        }
        Pageable pageable = PageRequest.of(request.getPageNum(), request.getPageSize(), sort);
        return template.find(query.with(pageable), clazz);
    }
}
