package com.spring.rest.client.bean;

public class RegionBean {
    private int regionID;
    private String regionName;

    public RegionBean(int regionId, String regionName) {
        setRegionID(regionId);
        setRegionName(regionName);
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
