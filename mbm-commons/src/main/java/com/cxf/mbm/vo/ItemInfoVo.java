package com.cxf.mbm.vo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;


/**
 * @author always_on_the_way
 * @date 2019-07-12
 */
public class ItemInfoVo implements Serializable {

    @Field
    private String id;
    @Field
    private String title;
    @Field
    private String img;
    @Field
    private Long pri;
    @Field
    private Long nub;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getPri() {
        return pri;
    }

    public void setPri(Long pri) {
        this.pri = pri;
    }

    public Long getNub() {
        return nub;
    }

    public void setNub(Long nub) {
        this.nub = nub;
    }

}
