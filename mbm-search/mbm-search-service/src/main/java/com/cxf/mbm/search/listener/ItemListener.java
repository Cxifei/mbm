package com.cxf.mbm.search.listener;

import com.cxf.mbm.commons.MqConstant;
import com.cxf.mbm.search.client.ClientExecute;
import com.cxf.mbm.search.client.ClientExecuteAdd;
import com.cxf.mbm.search.client.ClientExecuteFactory;
import com.cxf.mbm.search.dao.SearchMapper;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

/**
 * 商品添加监听器容器
 *
 * @author always_on_the_way
 * @date 2019-07-15
 */
public class ItemListener implements MessageListener {

    @Autowired
    private SearchMapper mapper;

    @Autowired
    private HttpSolrClient client;

    @Override
    public void onMessage(Message message) {

        if (message instanceof MapMessage){
           MapMessage mapMessage = (MapMessage) message;
            try {
                long id = mapMessage.getLong(MqConstant.KEY_ID);
                String status = mapMessage.getString(MqConstant.KEY_STATUS);
                ClientExecute clientExecute = ClientExecuteFactory.getClientExecute(status);
                if (clientExecute instanceof ClientExecuteAdd){
                    ((ClientExecuteAdd) clientExecute).setMapper(mapper);
                }
                clientExecute.execute(client,id+"");
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }

    }
}
