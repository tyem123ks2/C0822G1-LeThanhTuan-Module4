package com.example.furama_resort_management.repository.contract;

import com.example.furama_resort_management.model.contract.Contract;
import com.example.furama_resort_management.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findByContract(Contract contract);
}