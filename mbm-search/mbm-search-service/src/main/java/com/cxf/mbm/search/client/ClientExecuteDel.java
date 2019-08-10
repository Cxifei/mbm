package com.cxf.mbm.search.client;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;

/**
 * @author always_on_the_way
 * @date 2019-07-16
 */
public class ClientExecuteDel implements ClientExecute {

    @Override
    public void execute(HttpSolrClient client, String id) {
        try {
            client.deleteById(id);
            client.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }

    }


}
