package com.example.furama_resort_management.service.facility;

import com.example.furama_resort_management.model.facility.Facility;
import exception.FacilityNameDuplicationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IFacilityService {
    Page<Facility> searchName(String name, Pageable pageable);

    Page<Facility> searchNameAndFacilityType(String name, Integer typeId, Pageable pageable);

    List<Facility> getAllFacility();

    boolean addFacility(Facility facility) throws FacilityNameDuplicationException;

    boolean editFacility(Facility facility);

    Facility findById(int id);
}