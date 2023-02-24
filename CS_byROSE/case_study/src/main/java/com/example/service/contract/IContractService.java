package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ShowContractDto;
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
