package com.spring.rest.client.bean;

import java.util.Date;

public class DealBean {
    private int dealId;
    private Date dealDate;
    private FlatBean flat;
    private Float price;

    public DealBean(int dealId, Date dealDate, FlatBean flat, Float price) {
        this.dealId = dealId;
        this.dealDate = dealDate;
        this.flat = flat;
        this.price = price;
    }

    public FlatBean getFlat() {
        return flat;
    }

    public void setFlat(FlatBean flat) {
        this.flat = flat;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
