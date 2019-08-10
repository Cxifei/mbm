package com.cxf.mbm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author always_on_the_way
 * @date 2019-07-10
 */
@Data
public class ItemCategory implements Serializable {

    private Long id;

    /**
     * 上一级目录
     */
    private ItemCategory category;

    /**
     * 上一级分类，当父类ID=0时，为一级目录
     */
    private Long parentId;
//    private ItemCategory parent;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 状态（正常，删除）
     */
    private String status;

    /**
     * 排序，如果数值相等，按名称排序
     */
    private Integer sortOrder;

    /**
     * 是否是父类型（一级菜单）
     */
    private Boolean isParent;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;

}
