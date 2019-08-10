package com.cxf.mbm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 *
 * @author always_on_the_way
 * @date 2019-07-10
 */
@Data
public class Item implements Serializable {

    private Long id;

    private String title;

    /**
     * 卖点
     */
    private String sellPoint;

    /**
     * 价格，单位：分
     */
    private Long price;

    /**
     * 库存
     */
    private Integer num;

    /**
     * 图片
     */
    private String image;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 商品类型
     */
    private ItemCategory category;

    /**
     * 商品状态（正常，下架，删除）
     */
    private String status;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;
}
