package com.xiong.utils;

public class Pages {
    private Integer currentPage;//当前页
    private Integer pageSize;//页面容量
    private Integer countPage;//总记录数
    private Integer totalPage;//总页数
    private Integer prePage;//上一页
    private Integer nextPage;//下一页


    public Pages() {
    }

    public Pages(Integer currentPage, Integer pageSize, Integer countPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.countPage = countPage;
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

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    //计算总页数
    public Integer getTotalPage() {
        if (getCountPage() % getPageSize() == 0) {
            return getCountPage() / getPageSize();
        } else {
            return getCountPage() / getPageSize() + 1;
        }
    }

    //上一页
    public Integer getPrePage() {
        if (getCurrentPage() <= 1) {
            return 1;
        } else {
            return getCurrentPage() - 1;
        }
    }

    //下一页
    public Integer getNextPage() {
        if (getCurrentPage() >= getTotalPage()) {
            return getTotalPage();
        } else {
            return getCurrentPage() + 1;
        }
    }
}
