package com.cxf.mbm.search.service.impl;

import com.cxf.mbm.search.service.SearchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-*.xml")
public class SearchServiceImplTest {


    @Autowired
    private SearchService searchService;


    @Test
    public void importData() {

        boolean importData = searchService.importData();
        Assert.assertTrue(importData);

    }
}