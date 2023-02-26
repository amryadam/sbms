package com.amryadam.sbms.repository.customer;

import com.amryadam.sbms.model.customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
