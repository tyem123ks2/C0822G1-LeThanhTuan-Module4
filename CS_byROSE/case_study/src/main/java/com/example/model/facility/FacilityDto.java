package com.example.model.facility;

import javax.validation.constraints.Min;

public class FacilityDto {
    private Integer id;
    private String name;
    @Min(value = 1,message = "Diện tích của dịch vụ phải là một số dương")
    private Double area;
    @Min(value = 1,message = "Gía phải là một số dương")
    private Double cost;
    @Min(value = 1,message = "Số người tối đa phải là một số dương")
    private Integer maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 1,message = "Diện tích bể bơi phải là một số dương")
    private Double poolArea;
    @Min(value = 1,message = "Số tầng phải là một số dương")
    private Integer numberOfFloor;
    private String facilityFree;

    public FacilityDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
