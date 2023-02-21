package com.example.furama_resort_management.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Contract contract;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private AttachFacility attachFacility;

    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contract, AttachFacility attachFacility, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
