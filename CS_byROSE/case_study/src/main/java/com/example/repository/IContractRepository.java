package com.example.repository;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where is_deleted = false", nativeQuery = true)
    Page<Contract> getAllContract(Pageable pageable);

    @Query(value = "select ifnull(sum(f.cost + af.cost * cd.quantity),0) as total\n" +
            "from contract c\n" +
            "         left join contract_detail cd on c.id = cd.contract_id\n" +
            "         left join attach_facility af on af.id = cd.attach_facility_id\n" +
            "         left join facility f on c.facility_id = f.id\n" +
            "where c.id = :contractId\n and c.is_deleted = false " +
            "group by c.id", nativeQuery = true)
    Double calculateTotal(@Param("contractId") int contractId);

    @Query(value = "select * from contract where is_deleted = false ", nativeQuery = true)
    List<Contract> getAllContract();

}

