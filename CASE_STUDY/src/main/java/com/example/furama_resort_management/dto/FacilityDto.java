package com.example.furama_resort_management.dto;

import com.example.furama_resort_management.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Tên sai định dạng! (không được có số và kí tự đặc biệt)")
    private String name;
    @NotBlank(message = "Diện tích không được để trống")
    private double area;
    @NotBlank(message = "Diện tích không được để trống")
    private double cost;
    @NotBlank(message = "Diện tích không được để trống")
    private int maxPeople;
    @NotBlank(message = "Diện tích không được để trống")
    private RentType rentType;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private double poolArea;

    private int numberOfFloor;

    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, double area, double cost, int maxPeople, RentType rentType, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloor, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        String strRegex = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        String[] names = facilityDto.getName().split(" ");
        String upperRegex = "[A-Z]";
        if (!facilityDto.getName().matches(strRegex)) {
            errors.rejectValue("name", "name", "Tên dịch không được chứa ký tự đặc biệt và chứa số");
        }
    }
}
