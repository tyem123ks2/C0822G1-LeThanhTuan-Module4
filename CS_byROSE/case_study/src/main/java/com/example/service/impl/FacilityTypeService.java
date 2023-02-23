package com.example.service.impl;

import com.example.model.facility.FacilityType;
import com.example.repository.IFacilityTypeRepository;
import com.example.service.IFacilityTypeService;
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
