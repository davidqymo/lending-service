package com.xxxx.corebanking.lending.lendingservice.entity;

public class CustomerPageParameters {
    private Integer startIndex;
    private Integer pageNumber;

    public CustomerPageParameters(Integer startIndex, Integer pageNumber) {
        this.startIndex = startIndex;
        this.pageNumber = pageNumber;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
