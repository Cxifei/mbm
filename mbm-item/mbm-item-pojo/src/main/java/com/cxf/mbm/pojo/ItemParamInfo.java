package com.cxf.mbm.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品具体规格
 *
 * @author always_on_the_way
 * @date 2019-07-10
 */
@Data
public class ItemParamInfo implements Serializable {

    private Long id;

    private Item item;

    /**
     * 商品具体规格参数，也为json格式数据
     * [{"group":"params":[{}]}]
     *
     */
    private String dataInfo;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;

}
