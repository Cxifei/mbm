package com.cxf.mbm.dao;

import com.cxf.mbm.pojo.ItemCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class ItemCategoryMapperTest {

    @Autowired
    private ItemCategoryMapper mapper;

    @Test
    public void insert() {

        ItemCategory category = new ItemCategory();
        category.setName("奶粉辅食");
        category.setIsParent(true);
        category.setSortOrder(1);
        int insert = mapper.insert(category);
        System.out.println(insert);

    }

    @Test
    public void selectAll() {
        List<ItemCategory> itemCategories = mapper.selectAll();
        for (ItemCategory itemCategory : itemCategories) {
            System.out.println(itemCategory);
        }
    }
}