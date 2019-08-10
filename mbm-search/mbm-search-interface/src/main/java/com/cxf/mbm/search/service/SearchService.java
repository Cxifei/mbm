package com.cxf.mbm.search.service;

import com.cxf.mbm.vo.ItemInfoVo;

import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-12
 */
public interface SearchService {

    boolean importData();

    List<ItemInfoVo> search(String keyword);

}
