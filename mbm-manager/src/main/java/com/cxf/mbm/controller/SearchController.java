package com.cxf.mbm.controller;

import com.cxf.mbm.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搜索
 *
 * @author always_on_the_way
 * @date 2019-07-15
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 导入数据
     * @return
     */
    @ResponseBody
    @GetMapping("/search/importData")
    public Boolean importData(){
        return searchService.importData();
    }

}
