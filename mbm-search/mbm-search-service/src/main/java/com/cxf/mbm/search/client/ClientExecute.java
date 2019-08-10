package com.cxf.mbm.search.client;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * solr客户端执行
 * @author always_on_the_way
 * @date 2019-07-16
 */
public interface ClientExecute {

    void execute(HttpSolrClient client,String id);

}
