package com.example.furama_resort_management.dto.contract;

import java.util.List;

public class AddContractErrorDto {
    private String startDate;
    private String endDate;
    private List<AttachFacilityErrorDto> attachFacilityErrorDtos;
    private String deposit;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<AttachFacilityErrorDto> getAttachFacilityErrorDtos() {
        return attachFacilityErrorDtos;
    }

    public void setAttachFacilityErrorDtos(List<AttachFacilityErrorDto> attachFacilityErrorDtos) {
        this.attachFacilityErrorDtos = attachFacilityErrorDtos;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
}