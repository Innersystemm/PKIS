package com.spring.rest.client.bean;

import java.time.LocalDateTime;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class DealBean {
    private OptionalInt dealId;
    private OptionalDouble price;
    private LocalDateTime dealDate;
    private FlatBean flat;

    public DealBean(final OptionalInt dealId, final OptionalDouble price,
                    final LocalDateTime dealDate, final FlatBean flat) {
        this.dealId = dealId;
        this.price = price;
        this.dealDate = dealDate;
        this.flat = flat;
    }

    public DealBean(final int dealId, final double price,
                    final LocalDateTime dealDate, final FlatBean flat) {
        this.dealId = OptionalInt.of(dealId);
        this.price = OptionalDouble.of(price);
        this.dealDate = dealDate;
        this.flat = flat;
    }

    public OptionalInt getDealId() {
        return dealId;
    }

    public void setDealId(OptionalInt dealId) {
        this.dealId = dealId;
    }

    public OptionalDouble getPrice() {
        return price;
    }

    public void setPrice(OptionalDouble price) {
        this.price = price;
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDateTime dealDate) {
        this.dealDate = dealDate;
    }

    public FlatBean getFlat() {
        return flat;
    }

    public void setFlat(FlatBean flat) {
        this.flat = flat;
    }
}
