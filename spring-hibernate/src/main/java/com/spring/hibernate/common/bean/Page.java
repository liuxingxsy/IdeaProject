package com.spring.hibernate.common.bean;

import java.util.List;

/**
 * 分页实体
 * Created by siyong.xu on 2017-06-08.
 */
public class Page<T> {
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 每页条数
     */
    private int pageSize = 10;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总条数
     */
    private int totalCount;
    /**
     * 当前页的记录集合
     */
    private List<T> rowList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRowList() {
        return rowList;
    }

    public void setRowList(List<T> rowList) {
        this.rowList = rowList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", rowList=" + rowList +
                '}';
    }
}
