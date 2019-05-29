package com.szxs.entity;

import java.io.Serializable;
import java.util.Date;

public class DmElasticSearchRequestParm implements Serializable {
    private Integer areaId;//区域id
    private Integer itemTypeId1;//类型1
    private Integer itemTypeId2;//类型2
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private String sort;//排序规则
    private Integer currentPage;//当前页
    private Integer pageSize;//每页多少行
    private String keyword;//关键字

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
