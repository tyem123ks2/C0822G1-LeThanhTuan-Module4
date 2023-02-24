package com.example.service.contract;

import com.example.model.contract.AttachFacilityDto;
import com.example.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<AttachFacilityDto> getAllAttachFacility(int contractId);

    boolean addContractDetail(ContractDetail contractDetail);
}
