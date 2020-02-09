package com.moboko.bestpricever1.entity;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RakutenItem {


    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @SerializedName("Items")
    private List<Items> items= null;

    public class Items {

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @SerializedName("Item")
        private Item item;

        public class Item {

            @SerializedName("MediumImageUrl")
            private List<MediumImageUrl> mediumImageUrls = null;

            public List<MediumImageUrl> getMediumImageUrls() {
                return mediumImageUrls;
            }

            public void setMediumImageUrls(List<MediumImageUrl> mediumImageUrls) {
                this.mediumImageUrls = mediumImageUrls;
            }

            public Integer getPointRate() {
                return pointRate;
            }

            public void setPointRate(Integer pointRate) {
                this.pointRate = pointRate;
            }

            public Integer getShopOfTheYearFlag() {
                return shopOfTheYearFlag;
            }

            public void setShopOfTheYearFlag(Integer shopOfTheYearFlag) {
                this.shopOfTheYearFlag = shopOfTheYearFlag;
            }

            public Integer getAffiliateRate() {
                return affiliateRate;
            }

            public void setAffiliateRate(Integer affiliateRate) {
                this.affiliateRate = affiliateRate;
            }

            public Integer getShipOverseasFlag() {
                return shipOverseasFlag;
            }

            public void setShipOverseasFlag(Integer shipOverseasFlag) {
                this.shipOverseasFlag = shipOverseasFlag;
            }

            public Integer getAsurakuFlag() {
                return asurakuFlag;
            }

            public void setAsurakuFlag(Integer asurakuFlag) {
                this.asurakuFlag = asurakuFlag;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public Integer getTaxFlag() {
                return taxFlag;
            }

            public void setTaxFlag(Integer taxFlag) {
                this.taxFlag = taxFlag;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getItemCaption() {
                return itemCaption;
            }

            public void setItemCaption(String itemCaption) {
                this.itemCaption = itemCaption;
            }

            public String getCatchcopy() {
                return catchcopy;
            }

            public void setCatchcopy(String catchcopy) {
                this.catchcopy = catchcopy;
            }

            public List<Integer> getTagIds() {
                return tagIds;
            }

            public void setTagIds(List<Integer> tagIds) {
                this.tagIds = tagIds;
            }

            public List<SmallImageUrl> getSmallImageUrls() {
                return smallImageUrls;
            }

            public void setSmallImageUrls(List<SmallImageUrl> smallImageUrls) {
                this.smallImageUrls = smallImageUrls;
            }

            public String getAsurakuClosingTime() {
                return asurakuClosingTime;
            }

            public void setAsurakuClosingTime(String asurakuClosingTime) {
                this.asurakuClosingTime = asurakuClosingTime;
            }

            public Integer getImageFlag() {
                return imageFlag;
            }

            public void setImageFlag(Integer imageFlag) {
                this.imageFlag = imageFlag;
            }

            public Integer getAvailability() {
                return availability;
            }

            public void setAvailability(Integer availability) {
                this.availability = availability;
            }

            public String getShopAffiliateUrl() {
                return shopAffiliateUrl;
            }

            public void setShopAffiliateUrl(String shopAffiliateUrl) {
                this.shopAffiliateUrl = shopAffiliateUrl;
            }

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            public Integer getPostageFlag() {
                return postageFlag;
            }

            public void setPostageFlag(Integer postageFlag) {
                this.postageFlag = postageFlag;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public Integer getItemPrice() {
                return itemPrice;
            }

            public void setItemPrice(Integer itemPrice) {
                this.itemPrice = itemPrice;
            }

            public String getPointRateEndTime() {
                return pointRateEndTime;
            }

            public void setPointRateEndTime(String pointRateEndTime) {
                this.pointRateEndTime = pointRateEndTime;
            }

            public String getShopCode() {
                return shopCode;
            }

            public void setShopCode(String shopCode) {
                this.shopCode = shopCode;
            }

            public String getAffiliateUrl() {
                return affiliateUrl;
            }

            public void setAffiliateUrl(String affiliateUrl) {
                this.affiliateUrl = affiliateUrl;
            }

            public Integer getGiftFlag() {
                return giftFlag;
            }

            public void setGiftFlag(Integer giftFlag) {
                this.giftFlag = giftFlag;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public Integer getReviewCount() {
                return reviewCount;
            }

            public void setReviewCount(Integer reviewCount) {
                this.reviewCount = reviewCount;
            }

            public String getAsurakuArea() {
                return asurakuArea;
            }

            public void setAsurakuArea(String asurakuArea) {
                this.asurakuArea = asurakuArea;
            }

            public String getShopUrl() {
                return shopUrl;
            }

            public void setShopUrl(String shopUrl) {
                this.shopUrl = shopUrl;
            }

            public Integer getCreditCardFlag() {
                return creditCardFlag;
            }

            public void setCreditCardFlag(Integer creditCardFlag) {
                this.creditCardFlag = creditCardFlag;
            }

            public String getShipOverseasArea() {
                return shipOverseasArea;
            }

            public void setShipOverseasArea(String shipOverseasArea) {
                this.shipOverseasArea = shipOverseasArea;
            }

            public String getGenreId() {
                return genreId;
            }

            public void setGenreId(String genreId) {
                this.genreId = genreId;
            }

            public String getPointRateStartTime() {
                return pointRateStartTime;
            }

            public void setPointRateStartTime(String pointRateStartTime) {
                this.pointRateStartTime = pointRateStartTime;
            }

            public String getItemUrl() {
                return itemUrl;
            }

            public void setItemUrl(String itemUrl) {
                this.itemUrl = itemUrl;
            }


            @SerializedName("pointRate")
            private Integer pointRate;
            @SerializedName("shopOfTheYearFlag")
            private Integer shopOfTheYearFlag;
            @SerializedName("affiliateRate")
            private Integer affiliateRate;
            @SerializedName("shipOverseasFlag")
            private Integer shipOverseasFlag;
            @SerializedName("asurakuFlag")
            private Integer asurakuFlag;
            @SerializedName("endTime")
            private String endTime;
            @SerializedName("taxFlag")
            private Integer taxFlag;
            @SerializedName("startTime")
            private String startTime;
            @SerializedName("itemCaption")
            private String itemCaption;
            @SerializedName("catchcopy")
            private String catchcopy;
            @SerializedName("tagIds")
            private List<Integer> tagIds = null;
            @SerializedName("smallImageUrls")
            private List<SmallImageUrl> smallImageUrls = null;
            @SerializedName("asurakuClosingTime")
            private String asurakuClosingTime;
            @SerializedName("imageFlag")
            private Integer imageFlag;
            @SerializedName("availability")
            private Integer availability;
            @SerializedName("shopAffiliateUrl")
            private String shopAffiliateUrl;
            @SerializedName("itemCode")
            private String itemCode;
            @SerializedName("postageFlag")
            private Integer postageFlag;
            @SerializedName("itemName")
            private String itemName;
            @SerializedName("itemPrice")
            private Integer itemPrice;
            @SerializedName("pointRateEndTime")
            private String pointRateEndTime;
            @SerializedName("shopCode")
            private String shopCode;
            @SerializedName("affiliateUrl")
            private String affiliateUrl;
            @SerializedName("giftFlag")
            private Integer giftFlag;
            @SerializedName("shopName")
            private String shopName;
            @SerializedName("reviewCount")
            private Integer reviewCount;
            @SerializedName("asurakuArea")
            private String asurakuArea;
            @SerializedName("shopUrl")
            private String shopUrl;
            @SerializedName("creditCardFlag")
            private Integer creditCardFlag;
            @SerializedName("shipOverseasArea")
            private String shipOverseasArea;
            @SerializedName("genreId")
            private String genreId;
            @SerializedName("pointRateStartTime")
            private String pointRateStartTime;
            @SerializedName("itemUrl")
            private String itemUrl;

        }

        public class MediumImageUrl {
            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            @SerializedName("imageUrl")
            private String imageUrl;
        }

        public class SmallImageUrl {
            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            @SerializedName("imageUrl")
            private String imageUrl;
        }
    }
}