package com.szxs.dto;

import java.io.Serializable;
import java.util.List;

public class VoEsEntity implements Serializable {
    private Integer curPage;
    private Integer total;
    private Integer pageSize;
    private Integer pageCount;
    private Integer beginPos;
    private List<VoItemRows> rows;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public List<VoItemRows> getRows() {
        return rows;
    }

    public void setRows(List<VoItemRows> rows) {
        this.rows = rows;
    }
}
