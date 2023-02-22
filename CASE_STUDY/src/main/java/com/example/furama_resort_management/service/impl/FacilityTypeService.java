package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.facility.FacilityType;
import com.example.furama_resort_management.repository.IFacilityTypeRepository;
import com.example.furama_resort_management.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> getAllType() {
        return facilityTypeRepository.findAll();
    }
}
