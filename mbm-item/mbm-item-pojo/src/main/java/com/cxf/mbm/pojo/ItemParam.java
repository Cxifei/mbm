package com.cxf.mbm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品规格参数
 *
 * @author always_on_the_way
 * @date 2019-07-10
 */
@Data
public class ItemParam implements Serializable {

    private Long id;

    /**
     * 商品的类别
     */
    private ItemCategory category;

    /**
     *
     * 规格参数数据，为json格式的数据
     * [{"group":"尺码","params":["160/64A/XS","165/72A/S"]}
     * ,{"group":"颜色","params":["黄色","米色"]}
     * ......
     * ]
     *
     */
    private String dataParam;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;


}
