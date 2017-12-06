package com.spring.rest.client.bean;

import java.util.Optional;
import java.util.OptionalInt;

public class RegionBean {
    private OptionalInt regionID;
    private String regionName;

    public RegionBean(OptionalInt regionID, String regionName) {
        this.regionID = regionID;
        this.regionName = regionName;
    }

    public RegionBean(int regionID, String regionName) {
        this.regionID = OptionalInt.of(regionID);
        this.regionName = regionName;
    }

    public OptionalInt getRegionID() {
        return regionID;
    }

    public void setRegionID(OptionalInt regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
