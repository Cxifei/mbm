package com.cxf.mbm.service;

import com.cxf.mbm.pojo.ItemCategory;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-11
 */
public interface ItemCategoryService {

    ItemCategory findById(Long id);

    ItemCategory findByParentId(Long id);

    List<ItemCategory> findAll();

}
