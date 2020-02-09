package com.moboko.bestpricever1.entity;

public class ItemList {
    String ImgUrl;

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    String itemName;
    int itemPrice;

    public ItemList(String imgUrl, String itemName, int itemPrice) {
        ImgUrl = imgUrl;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

}
