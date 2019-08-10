package com.cxf.mbm.controller;

import com.cxf.mbm.search.service.SearchService;
import com.cxf.mbm.service.ItemService;
import com.cxf.mbm.vo.ItemInfoVo;
import com.cxf.mbm.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品
 *
 * @author always_on_the_way
 * @date 2019-07-11
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private SearchService searchService;


    @GetMapping("/commodity")
    public String item(){
        return "commodity";
    }

    @ResponseBody
    @GetMapping("/item/list")
    public ItemVo list(){
        return itemService.list();
    }

    @ResponseBody
    @GetMapping("/search/{keyword}")
    public ItemVo search(@PathVariable String keyword){
        List<ItemInfoVo> search = searchService.search(keyword);
        return new ItemVo().of(search);
    }

}
