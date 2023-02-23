package com.example.furama_resort_management.service.contract;

import com.example.furama_resort_management.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    AttachFacility getAttachFacilityInfo(int id);

    List<AttachFacility> getAllAttachFacility();

    String getNameById(Integer id);
}
