package com.spring.rest.client.bean;

public class FlatBean {
    private int flatId;
    private float flatArea;
    private int flatRooms;
    private boolean haveBalcony;
    private RegionBean flatRegion;

    public FlatBean(int flatId, float flatArea, int flatRooms, boolean haveBalcony, RegionBean flatRegion) {
        setFlatId(flatId);
        setFlatArea(flatArea);
        setFlatRooms(flatRooms);
        setHaveBalcony(haveBalcony);
        setFlatRegion(flatRegion);
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public float getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(float flatArea) {
        this.flatArea = flatArea;
    }

    public int getFlatRooms() {
        return flatRooms;
    }

    public void setFlatRooms(int flatRooms) {
        this.flatRooms = flatRooms;
    }

    public boolean isHaveBalcony() {
        return haveBalcony;
    }

    public void setHaveBalcony(boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }

    public RegionBean getFlatRegion() {
        return flatRegion;
    }

    public void setFlatRegion(RegionBean flatRegion) {
        this.flatRegion = flatRegion;
    }
}
