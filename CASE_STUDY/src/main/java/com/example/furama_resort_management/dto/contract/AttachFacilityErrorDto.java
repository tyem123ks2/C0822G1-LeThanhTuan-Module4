package com.example.furama_resort_management.dto.contract;

public class AttachFacilityErrorDto {
    private String name;
    private String quantityError;

    public AttachFacilityErrorDto(String name, String quantityError) {
        this.name = name;
        this.quantityError = quantityError;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }
}