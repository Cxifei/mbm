package com.cxf.mbm.search;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * @author always_on_the_way
 * @date 2019-07-12
 */
public class DemoTest {


    private String solrUrl = "http://localhost:8983/solr/new_core";


    @Test
    public void save() throws IOException, SolrServerException {

        //方式一
        //获取solr客户端
        SolrClient client = new HttpSolrClient.Builder(solrUrl).build();

        //创建插入文档
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id",1);
        doc.addField("title","京东工业品");
        //创建更新请求
        UpdateRequest request = new UpdateRequest();
        request.setAction(UpdateRequest.ACTION.COMMIT,false,false);
        request.add(doc);
        request.process(client);


        //方式二
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();

        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("id",2);
        solrInputDocument.addField("title","淘宝二手货");
        solrClient.add(solrInputDocument);
        solrClient.commit();


    }

    @Test
    public void update(){


    }

    @Test
    public void find() throws IOException, SolrServerException {

        //创建客户端
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();

        //创建搜索条件
        SolrQuery query = new SolrQuery();
        query.set("q","title:淘宝");
        //设置高亮
        query.setHighlight(true);
        query.addHighlightField("title");
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");
        //获取查询响应
        QueryResponse queryResponse = solrClient.query(query);
        //获取结果集
        SolrDocumentList documentList = queryResponse.getResults();
        for (SolrDocument document : documentList) {
            System.out.println("id:"+document.get("id")+"\t");
            //获取高亮的标题
            String title = queryResponse.getHighlighting().get(document.get("id")).get("title").get(0);
            System.out.println("title:"+title);

//            System.out.println("title:"+document.get("title"));
        }


    }

    @Test
    public void delete() throws IOException, SolrServerException {

        //创建客户端
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
        solrClient.deleteById("5");
        //提交
        solrClient.commit();

    }

}
