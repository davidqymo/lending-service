package com.xxxx.corebanking.entity;

public class holidayItemKey {
    private String countryCode;

    private String holidayArea;

    private Integer yearMonth;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getHolidayArea() {
        return holidayArea;
    }

    public void setHolidayArea(String holidayArea) {
        this.holidayArea = holidayArea == null ? null : holidayArea.trim();
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }
}