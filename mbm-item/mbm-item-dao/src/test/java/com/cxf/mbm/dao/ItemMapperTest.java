package com.cxf.mbm.dao;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.pojo.ItemCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class ItemMapperTest {

    @Autowired
    private ItemMapper mapper;

    @Test
    public void insert() {

        Item item = new Item();
        item.setTitle("leehom");
        item.setSellPoint("leehom演唱会");
        ItemCategory category = new ItemCategory();
        category.setId(1L);
        item.setStatus("下架");
        item.setCategory(category);
        item.setPrice(300L);
        item.setNum(8);
        mapper.insert(item);

    }

    @Test
    public void update() {

        Item item = new Item();
        item.setId(1L);
        item.setTitle("leehom");
        ItemCategory category = new ItemCategory();
        category.setId(1L);
        item.setCategory(category);
        mapper.update(item);

    }

    @Test
    public void delete() {

        Item item = new Item();
        ItemCategory category = new ItemCategory();
        category.setId(1L);
        item.setCategory(category);
        item.setTitle("leehom");
        mapper.delete(item);

    }

    @Test
    public void deleteById() {

        Item item = new Item();
        item.setId(3L);
        mapper.delete(item);

    }

    @Test
    public void selectById() {
        Item item = mapper.selectById(3L);
        System.out.println(item);
    }

    @Test
    public void selectByParam() {
        Item item = new Item();
        ItemCategory category = new ItemCategory();
        category.setId(2L);
        item.setCategory(category);
        List<Item> items = mapper.selectByParam(item);
        for (Item item1 : items) {
            System.out.println(item1);
        }
    }

    @Test
    public void selectAll() {
        List<Item> items = mapper.selectAll();
        for (Item item : items) {
            System.out.println(item);
        }
    }
}