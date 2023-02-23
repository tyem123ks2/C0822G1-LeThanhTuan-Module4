package com.example.furama_resort_management.service.contract;

import com.example.furama_resort_management.dto.contract.AttachFacilityDto;
import com.example.furama_resort_management.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<AttachFacilityDto> getAllAttachFacility(int contractId);

    boolean addContractDetail(ContractDetail contractDetail);
}
