package com.example.service.impl;


import com.example.model.contract.AttachFacility;
import com.example.repository.IAttachFacilityRepository;
import com.example.service.contract.IAttachFacilityService;
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