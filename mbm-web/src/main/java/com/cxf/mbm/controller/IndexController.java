package com.cxf.mbm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 *
 * @author always_on_the_way
 * @date 2019-07-11
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
