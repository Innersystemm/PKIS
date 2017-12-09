package com.spring.rest.client.bean;

public class RegionBean {
    private int regionID;
    private String regionName;

    public RegionBean(int regionID, String regionName) {
        this.regionID = regionID;
        this.regionName = regionName;
    }


    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
