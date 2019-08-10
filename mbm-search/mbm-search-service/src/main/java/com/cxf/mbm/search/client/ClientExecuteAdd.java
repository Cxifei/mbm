package com.cxf.mbm.search.client;

import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.search.dao.SearchMapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * @author always_on_the_way
 * @date 2019-07-16
 */
public class ClientExecuteAdd implements ClientExecute {

    private SearchMapper mapper;

    public void setMapper(SearchMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void execute(HttpSolrClient client, String id) {

        if (id != null && !"".equalsIgnoreCase(id)){
            try {
                client.add(document(this.mapper,Long.valueOf(id)));
                client.commit();
            } catch (SolrServerException | IOException e) {
                e.printStackTrace();
            }
        }

    }

    private SolrInputDocument document(SearchMapper mapper,Long id){
        //根据商品的ID查询该商品
        Item item = mapper.getItemById(id);
        //把查询的结果存放到solr
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id",item.getId());
        document.addField("title",item.getTitle());
        document.addField("img",item.getImage());
        document.addField("pri",item.getPrice());
        return document;
    }



}
