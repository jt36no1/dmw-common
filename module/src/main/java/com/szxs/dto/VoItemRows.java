package com.szxs.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 剧场详情实体类
 */
public class VoItemRows implements Serializable {
    private Integer id;
    private String imgUrl;
    private String areaName;
    private String itemName;
    private String  abstractMessage;
    private Date startTime;
    private Date endTime;
    private Float minPrice;
    private Float maxPrice;
    private String address;
    private String latitude;
    private String longitude;
    private Integer itemTypeId1;
    private Integer itemTypeId2;
    private Integer areaId;
    private Integer commentCount;
    private String createdTime;
    private Long createdTimeLong;
    private Long startTimeLong;
    private Long endTimeLong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAbstractMessage() {
        return abstractMessage;
    }

    public void setAbstractMessage(String abstractMessage) {
        this.abstractMessage = abstractMessage;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getItemTypeId1() {
        return itemTypeId1;
    }

    public void setItemTypeId1(Integer itemTypeId1) {
        this.itemTypeId1 = itemTypeId1;
    }

    public Integer getItemTypeId2() {
        return itemTypeId2;
    }

    public void setItemTypeId2(Integer itemTypeId2) {
        this.itemTypeId2 = itemTypeId2;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedTimeLong() {
        return createdTimeLong;
    }

    public void setCreatedTimeLong(Long createdTimeLong) {
        this.createdTimeLong = createdTimeLong;
    }

    public Long getStartTimeLong() {
        return startTimeLong;
    }

    public void setStartTimeLong(Long startTimeLong) {
        this.startTimeLong = startTimeLong;
    }

    public Long getEndTimeLong() {
        return endTimeLong;
    }

    public void setEndTimeLong(Long endTimeLong) {
        this.endTimeLong = endTimeLong;
    }
}
