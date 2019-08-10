package com.cxf.mbm.service.impl;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.pojo.ItemCategory;
import com.cxf.mbm.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-*.xml")
public class ItemServiceImplTest {

    @Autowired
    private ItemService service;

    @Test
    public void save() {
        Item item = new Item();
        item.setTitle("jj");
        item.setSellPoint("jj演唱会");
        ItemCategory category = new ItemCategory();
        category.setId(5L);
        item.setStatus("下架");
        item.setCategory(category);
        item.setPrice(300L);
        item.setNum(8);
        service.save(item);
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByParam() {
    }
}