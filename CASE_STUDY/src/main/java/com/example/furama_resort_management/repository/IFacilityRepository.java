package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> sreachName(String name, Pageable pageable);

    Page<Facility> sreachName(String name, int typeId, Pageable pageable);

    Facility findByName(String name);
}
