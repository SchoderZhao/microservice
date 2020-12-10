package com.msunsoft.spt.common.core.entity.system;

import lombok.Data;

/**
 * @author Schoder
 */
@Data
public class Column {
    /**
     * 名称
     */
    private String name;
    /**
     * 是否为主键
     */
    private Boolean isKey;
    /**
     * 类型
     */
    private String type;
    /**
     * 注释
     */
    private String remark;
    /**
     * 属性名称
     */
    private String field;
}
