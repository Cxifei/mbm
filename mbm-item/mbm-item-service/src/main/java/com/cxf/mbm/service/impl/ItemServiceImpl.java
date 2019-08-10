package com.cxf.mbm.service.impl;

import com.cxf.mbm.commons.MqConstant;
import com.cxf.mbm.dao.ItemMapper;
import com.cxf.mbm.pojo.Item;
import com.cxf.mbm.service.ItemService;
import com.cxf.mbm.vo.ItemInfoVo;
import com.cxf.mbm.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author always_on_the_way
 * @date 2019-07-11
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    private final ItemMapper mapper;


    @Autowired //根据类型注入，如果非要用这个，需要加一个@Qualifier
    private JmsTemplate jmsTemplate;

    @Resource //根据名字注入
    private Destination topicDestination;

//    @Resource //根据名字注入
//    private Destination itemDel;

    @Autowired
    public ItemServiceImpl(ItemMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 添加商品
     * @param item
     * @return
     */
    @Override
    public Item save(Item item) {
        int insert = mapper.insert(item);
        //使用jms发送消息
        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setLong(MqConstant.KEY_ID,item.getId());
                message.setString(MqConstant.KEY_STATUS,MqConstant.STATUS_ADD);
                return message;
            }
        });
        return item;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Long id) {
        int delete = mapper.deleteById(id);
        //使用jms发送消息
        jmsSend(id,MqConstant.STATUS_DEL);
        return delete > 0;
    }

    @Override
    public Boolean update(Item item) {
        int update = mapper.update(item);
        //使用jms发送消息
        jmsSend(item.getId(),MqConstant.STATUS_UPD);
        return update > 0;
    }

    @Override
    public Item findById(Long id) {
        return null;
    }

    @Override
    public List<Item> findByParam(Item item) {
        return mapper.selectByParam(item);
    }

    /**
     * 查询所有商品信息
     * @return
     */
    @Override
    public ItemVo list() {
        //查询所有
        List<Item> items = mapper.selectAll();
        List<ItemInfoVo> voList = new ArrayList<>(items.size());
        for (Item item : items) {
            //创建内部类
            ItemInfoVo info = new ItemInfoVo();
            info.setImg(item.getImage());
            info.setTitle(item.getTitle());
            info.setPri(item.getPrice()/100);
            voList.add(info);
        }

        ItemVo itemVo = new ItemVo();
        itemVo.of(voList);
        return itemVo;
    }


    private void jmsSend(Long id,String status){
        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setLong(MqConstant.KEY_ID,id);
                message.setString(MqConstant.KEY_STATUS,status);
                return message;
            }
        });
    }

}
