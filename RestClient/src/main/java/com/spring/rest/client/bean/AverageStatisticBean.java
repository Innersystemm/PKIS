package com.spring.rest.client.bean;

public class AverageStatisticBean {
    private double averageDealCost;
    private double averageFlatArea;
    private double averageRoomsCount;

    public AverageStatisticBean(double averageDealCost, double averageFlatArea, double averageRoomsCount) {
        this.averageDealCost = averageDealCost;
        this.averageFlatArea = averageFlatArea;
        this.averageRoomsCount = averageRoomsCount;
    }

    public double getAverageDealCost() {
        return averageDealCost;
    }

    public void setAverageDealCost(double averageDealCost) {
        this.averageDealCost = averageDealCost;
    }

    public double getAverageFlatArea() {
        return averageFlatArea;
    }

    public void setAverageFlatArea(double averageFlatArea) {
        this.averageFlatArea = averageFlatArea;
    }

    public double getAverageRoomsCount() {
        return averageRoomsCount;
    }

    public void setAverageRoomsCount(double averageRoomsCount) {
        this.averageRoomsCount = averageRoomsCount;
    }
}
