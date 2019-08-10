package com.cxf.mbm.search.service.impl;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.search.dao.SearchMapper;
import com.cxf.mbm.search.service.SearchService;
import com.cxf.mbm.vo.ItemInfoVo;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-12
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper mapper;

    @Autowired
    private HttpSolrClient solrClient;

    @Override
    public boolean importData() {
        try {
            //删除所有的索引数据
            solrClient.deleteByQuery("*:*");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Item> itemList = mapper.selectAll();
        List<SolrInputDocument> documentList = new ArrayList<>(itemList.size());
        for (Item item : itemList) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",item.getId());
            document.addField("title",item.getTitle());
            document.addField("img",item.getImage());
            document.addField("pri",item.getPrice());
            documentList.add(document);
        }

        try {
            solrClient.add(documentList);
            solrClient.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<ItemInfoVo> search(String keyword) {

        SolrQuery query = new SolrQuery();
        query.setQuery("title:"+keyword);
        try {
            QueryResponse queryResponse = solrClient.query(query);
            List<ItemInfoVo> voList = queryResponse.getBeans(ItemInfoVo.class);
            return voList;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
