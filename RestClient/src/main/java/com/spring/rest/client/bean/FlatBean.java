package com.spring.rest.client.bean;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class FlatBean {
    private OptionalInt flatId;
    private OptionalDouble flatArea;
    private OptionalInt flatRooms;
    private Boolean haveBalcony;
    private RegionBean flatRegion;

    public FlatBean(final OptionalInt flatId, final OptionalDouble flatArea,
                    final OptionalInt flatRooms, final Boolean haveBalcony, final RegionBean flatRegion) {
        this.flatId = flatId;
        this.flatArea = flatArea;
        this.flatRooms = flatRooms;
        this.haveBalcony = haveBalcony;
        this.flatRegion = flatRegion;
    }

    public FlatBean(final int flatId, final double flatArea,
                    final int flatRooms, final Boolean haveBalcony, final RegionBean flatRegion) {
        this.flatId = OptionalInt.of(flatId);
        this.flatArea = OptionalDouble.of(flatArea);
        this.flatRooms = OptionalInt.of(flatRooms);
        this.haveBalcony = haveBalcony;
        this.flatRegion = flatRegion;
    }

    public OptionalInt getFlatId() {
        return flatId;
    }

    public void setFlatId(OptionalInt flatId) {
        this.flatId = flatId;
    }

    public OptionalDouble getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(OptionalDouble flatArea) {
        this.flatArea = flatArea;
    }

    public OptionalInt getFlatRooms() {
        return flatRooms;
    }

    public void setFlatRooms(OptionalInt flatRooms) {
        this.flatRooms = flatRooms;
    }

    public Boolean getHaveBalcony() {
        return haveBalcony;
    }

    public void setHaveBalcony(Boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }

    public RegionBean getFlatRegion() {
        return flatRegion;
    }

    public void setFlatRegion(RegionBean flatRegion) {
        this.flatRegion = flatRegion;
    }
}
