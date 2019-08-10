package com.cxf.mbm.dao;

import com.cxf.mbm.pojo.ItemCategory;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-11
 */
public interface ItemCategoryMapper {

    int insert(ItemCategory category);

    List<ItemCategory> selectAll();

}
