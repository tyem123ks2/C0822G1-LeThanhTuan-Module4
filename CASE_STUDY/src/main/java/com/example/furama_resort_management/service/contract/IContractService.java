package com.example.furama_resort_management.service.contract;

import com.example.furama_resort_management.dto.contract.ShowContractDto;
import com.example.furama_resort_management.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> getAllContracts();
    Page<Contract> getAllContracts(Pageable pageable);
    Page<ShowContractDto> getAllContractDto(Pageable pageable);
    Contract addContract(Contract contract);
    boolean isExist(Contract contract);
    Contract findById(int id);
    boolean editContract(Contract contract);
}
