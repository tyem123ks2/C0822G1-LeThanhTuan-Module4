package com.example.service;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService {
    Page<Facility> searchName(String name, Pageable pageable);

    Page<Facility> searchNameAndFacilityType(String name, Integer typeId, Pageable pageable);

    boolean addNewFacility(Facility facility);

    boolean editFacility(Facility facility);

    Facility findById(int id);

    List<Facility> getAllFacility();
}
