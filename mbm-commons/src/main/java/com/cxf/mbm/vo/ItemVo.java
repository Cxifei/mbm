package com.cxf.mbm.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 *
 * @author always_on_the_way
 * @date 2019-07-11
 */

public class ItemVo implements Serializable {

    private int status;

    private ItemCat menu;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ItemCat getMenu() {
        return menu;
    }

    public void setMenu(ItemCat menu) {
        this.menu = menu;
    }

    public ItemVo of(List<ItemInfoVo> infos){
        this.setStatus(0);
        ItemCat itemCat = new ItemCat();
        ItemCat.ItemCatInfo catInfo = itemCat.new ItemCatInfo();
        catInfo.setContent(infos);
        itemCat.setMilk(catInfo);
        this.setMenu(itemCat);
        return this;
    }


    public class ItemCat implements Serializable{
        private ItemCatInfo milk;

        public ItemCatInfo getMilk() {
            return milk;
        }

        public void setMilk(ItemCatInfo milk) {
            this.milk = milk;
        }

        public class ItemCatInfo implements Serializable{
            private List<ItemInfoVo> content;

            public List<ItemInfoVo> getContent() {
                return content;
            }

            public void setContent(List<ItemInfoVo> content) {
                this.content = content;
            }

        }
    }

}
