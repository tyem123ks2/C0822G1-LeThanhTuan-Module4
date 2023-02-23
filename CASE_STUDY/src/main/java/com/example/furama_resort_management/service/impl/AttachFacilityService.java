package com.example.furama_resort_management.service.impl;


import com.example.furama_resort_management.model.contract.AttachFacility;
import com.example.furama_resort_management.repository.contract.IAttachFacilityRepository;
import com.example.furama_resort_management.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public AttachFacility getAttachFacilityInfo(int id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachFacility> getAllAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public String getNameById(Integer id) {
        AttachFacility attachFacility = attachFacilityRepository.findById(id).orElse(null);
        if (attachFacility != null) {
            return attachFacility.getName();
        }
        return null;
    }
}