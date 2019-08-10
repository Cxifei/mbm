package com.cxf.mbm.controller;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.pojo.ItemCategory;
import com.cxf.mbm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @ResponseBody
    @GetMapping("/item/dataList")
    public List<Item> findAll(){
        List<Item> list = itemService.findByParam(new Item());
        return list;
    }

    @GetMapping("/item/list")
    public String list(Model model){
        List<Item> list = itemService.findByParam(new Item());
        model.addAttribute("list",list);
        return "item/list";
    }


    @GetMapping("/item/add")
    public String add(){
        return "item/add";
    }

    @ResponseBody
    @PostMapping("/item/save")
    public Item save(Item item,Long categoryId){
        ItemCategory category = new ItemCategory();
        category.setId(categoryId);
        item.setCategory(category);
        Item save = itemService.save(item);
        return save;
    }

//    @GetMapping("/item/del")
//    public String del(){
//        return "item/del";
//    }
//
//    @ResponseBody
//    @PostMapping("/item/delete")
//    public Boolean delete(Long categoryId){
//        return itemService.deleteById(categoryId);
//    }


    /**
     * 上面两个方法可以用下面这一种方法代替，更加简便
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/item/{id}")
    public Boolean delete(@PathVariable Long id){
        return itemService.deleteById(id);
    }

    @GetMapping("/item/upd/{id}")
    public String upd(@PathVariable Long id,Model model){
        model.addAttribute("id",id);
        return "item/update";
    }

    @ResponseBody
    @PostMapping("item/update")
    public Boolean update(Item item){
        return itemService.update(item);
    }


}
