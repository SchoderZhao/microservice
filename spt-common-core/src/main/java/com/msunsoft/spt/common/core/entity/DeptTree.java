package com.msunsoft.spt.common.core.entity;

import com.msunsoft.spt.common.core.entity.system.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Schoder
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept> {

    private Integer orderNum;
}
