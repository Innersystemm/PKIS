package com.spring.rest.client.bean;

public class AverageStatisticBean {
    private long averageDealCost;
    private float averageFlatArea;
    private int averageRoomsCount;

    public AverageStatisticBean(long averageDealCost, float averageFlatArea, int averageRoomsCount) {

        this.averageDealCost = averageDealCost;
        this.averageFlatArea = averageFlatArea;
        this.averageRoomsCount = averageRoomsCount;
    }

    public long getAverageDealCost() {
        return averageDealCost;
    }

    public void setAverageDealCost(long averageDealCost) {
        this.averageDealCost = averageDealCost;
    }

    public float getAverageFlatArea() {
        return averageFlatArea;
    }

    public void setAverageFlatArea(float averageFlatArea) {
        this.averageFlatArea = averageFlatArea;
    }

    public int getAverageRoomsCount() {
        return averageRoomsCount;
    }

    public void setAverageRoomsCount(int averageRoomsCount) {
        this.averageRoomsCount = averageRoomsCount;
    }
}
