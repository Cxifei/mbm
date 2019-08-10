package com.cxf.mbm.search.client;

import com.cxf.mbm.commons.MqConstant;

/**
 * 客户端执行工厂
 *
 * @author always_on_the_way
 * @date 2019-07-16
 */
public class ClientExecuteFactory {

    public ClientExecuteFactory() {
    }

    public static ClientExecute getClientExecute(String status){
        if (MqConstant.STATUS_DEL.equalsIgnoreCase(status)){
            return new ClientExecuteDel();
        }else if (MqConstant.STATUS_ADD.equalsIgnoreCase(status)){
            return new ClientExecuteAdd();
        }else if (MqConstant.STATUS_UPD.equalsIgnoreCase(status)){
            return new ClientExecuteAdd();
        }else {
            return new ClientExecuteDefault();
        }
    }
}
