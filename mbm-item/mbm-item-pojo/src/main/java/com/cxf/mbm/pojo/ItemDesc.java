package com.cxf.mbm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品描述
 *
 * @author always_on_the_way
 * @date 2019-07-10
 */
@Data
public class ItemDesc implements Serializable {

    private Long id;

    /**
     * 商品
     */
    private Item item;

    /**
     * 商品描述
     */
    private String itemDesc;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;

}
