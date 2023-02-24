package com.example.service.impl;

import com.example.model.contract.Contract;
import com.example.model.contract.ShowContractDto;
import com.example.repository.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> getAllContracts(Pageable pageable) {
        return contractRepository.getAllContract(pageable);
    }

    @Override
    public Page<ShowContractDto> getAllContractDto(Pageable pageable) {
        List<ShowContractDto> contractDtoList = new ArrayList<>();
        List<Contract> contractList = contractRepository.getAllContract();
        for (Contract ct : contractList) {
            ShowContractDto contractDto = new ShowContractDto();
            BeanUtils.copyProperties(ct, contractDto);
            contractDto.setTotal(contractRepository.calculateTotal(ct.getId()));
//            contractDto.setHistory();
            contractDtoList.add(contractDto);
        }
        return new PageImpl<>(contractDtoList);
    }


    @Override
    public Contract addContract(Contract contract) {
        if (isExist(contract)) {
            return null;
        }
        try {
            return contractRepository.save(contract);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return null;
        }
    }

    @Override
    public boolean isExist(Contract contract) {
        Contract contract1 = contractRepository.findById(contract.getId()).orElse(null);
        return contract1 != null;
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public boolean
    editContract(Contract contract) {
        if (!isExist(contract)) {
            return false;
        }
        try {
            contractRepository.save(contract);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }
}