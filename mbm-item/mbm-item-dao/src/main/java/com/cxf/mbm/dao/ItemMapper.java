package com.cxf.mbm.dao;

import com.cxf.mbm.pojo.Item;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-10
 */
public interface ItemMapper {

    int insert(Item item);

    int update(Item item);

    int delete(Item item);

    int deleteById(Long id);

    Item selectById(Long id);

    List<Item> selectByParam(Item item);

    List<Item> selectAll();

}
