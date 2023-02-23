package com.example.model.contract;

import javax.validation.constraints.Min;

public class ContractDetailDto {
    private Contract contract;
    private AttachFacility attachFacility;
    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    private int quantity;

    public ContractDetailDto() {
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
