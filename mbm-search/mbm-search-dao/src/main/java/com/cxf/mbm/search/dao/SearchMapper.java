package com.cxf.mbm.search.dao;

import com.cxf.mbm.pojo.Item;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-12
 */
public interface SearchMapper {

    List<Item> selectAll();

    Item getItemById(Long itemId);

    Boolean delItemById(Long itemId);

    Boolean updateByCondition(Item item);


}
