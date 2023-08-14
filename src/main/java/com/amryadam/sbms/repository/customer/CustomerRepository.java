package com.amryadam.sbms.repository.customer;

import com.amryadam.sbms.models.dtos.customer.CustomerDto;
import com.amryadam.sbms.models.entities.customers.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface CustomerRepository extends JpaRepository<Customer, String> {


    //TODO implement paging and sorting
    Page<Customer> findByName(String name, Pageable pageable);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    List<Customer> findByCodeContaining(String code, Sort sort);


    @Query("""
            SELECT new com.amryadam.sbms.models.dtos.customer.CustomerDto(
            c.id,c.code,c.name,c.email,c.imageUri,c.description,c.age,c.review,c.category
            ) FROM Customer c
            """)
    List<CustomerDto> findAllDto(); // taking objects and putting them outside of the JPA context
}