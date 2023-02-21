package com.example.furama_resort_management.model.contract;

import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.model.facility.Facility;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue
    private int id;
    private String startDate;
    private String endDate;
    private double deposit;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Facility facility;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @OneToOne(mappedBy = "contract")
    private ContractDetail contractDetail;

    public Contract() {
    }

    public Contract(int id, String startDate, String endDate, double deposit, Customer customer, Employee employee, Facility facility, boolean isDeleted, ContractDetail contractDetail) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.isDeleted = isDeleted;
        this.contractDetail = contractDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }
}
