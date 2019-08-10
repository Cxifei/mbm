package com.cxf.mbm.service;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.vo.ItemVo;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-11
 */
public interface ItemService {

    Item save(Item item);

    Boolean deleteById(Long id);

    Boolean update(Item item);

    Item findById(Long id);

    List<Item> findByParam(Item item);

    ItemVo list();

}
