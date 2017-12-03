package com.spring.rest.client.bean;

public class DetailedStatisticBean {
    private int selledFlatsCount;
    private long totalDealsPrice;

    public DetailedStatisticBean(int selledFlatsCount, long totalDealsPrice) {
        this.selledFlatsCount = selledFlatsCount;
        this.totalDealsPrice = totalDealsPrice;
    }

    public int getSelledFlatsCount() {
        return selledFlatsCount;
    }

    public void setSelledFlatsCount(int selledFlatsCount) {
        this.selledFlatsCount = selledFlatsCount;
    }

    public long getTotalDealsPrice() {
        return totalDealsPrice;
    }

    public void setTotalDealsPrice(long totalDealsPrice) {
        this.totalDealsPrice = totalDealsPrice;
    }


}
