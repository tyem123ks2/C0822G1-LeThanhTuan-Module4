package com.example.service.impl;


import com.example.model.contract.AttachFacilityDto;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.IContractDetailRepository;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractService contractService;

    List<ContractDetail> getAllContractDetails() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<AttachFacilityDto> getAllAttachFacility(int contractId) {
        List<AttachFacilityDto> attachFacilityDtoList = new ArrayList<>();
        List<ContractDetail> contractDetailList = getAllContractDetails();
        for (ContractDetail ct : contractDetailList) {
            if (ct.getContract().getId() == contractId) {
                AttachFacilityDto attachFacilityDto = new AttachFacilityDto();
                BeanUtils.copyProperties(ct.getAttachFacility(), attachFacilityDto);
                attachFacilityDto.setQuantity(ct.getQuantity());
                attachFacilityDtoList.add(attachFacilityDto);
            }
        }
        return attachFacilityDtoList;
    }

    @Override
    public boolean addContractDetail(ContractDetail newContractDetail) {
        Contract contract = contractService.findById(newContractDetail.getContract().getId());
        if (!contractService.isExist(contract)) {
            return false;
        }
        List<ContractDetail> contractDetailList = contractDetailRepository.findByContract(contract);
        int attachFacilityId;
        for (ContractDetail contractDetail : contractDetailList) {
            if (contractDetail.getAttachFacility() == null) {
                continue;
            }
            attachFacilityId = contractDetail.getAttachFacility().getId();
            if (attachFacilityId == newContractDetail.getAttachFacility().getId()) {
                newContractDetail.setId(contractDetail.getId());
                newContractDetail.setQuantity(contractDetail.getQuantity() + newContractDetail.getQuantity());
                break;
            }
        }
        try {
            contractDetailRepository.save(newContractDetail);
            contract.setEditHistory(String.valueOf(LocalDateTime.now()));
            contractService.editContract(contract);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

}