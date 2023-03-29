package com.amryadam.sbms.repository.customer;

import com.amryadam.sbms.entities.customers.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {


    //TODO implement paging and sorting
    Page<Customer> findByName(String name, Pageable pageable);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    List<Customer> findByCodeContaining(String code, Sort sort);
}
