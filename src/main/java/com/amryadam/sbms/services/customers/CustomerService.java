package com.amryadam.sbms.services.customers;

import com.amryadam.sbms.models.dtos.customer.CustomerDto;
import com.amryadam.sbms.models.entities.customers.Customer;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;

public interface CustomerService {
    ImmutablePair<Customer, String> save(Customer customer);
    ImmutablePair<List<Customer>, String> save(List<Customer> customerList);

    ImmutablePair<Customer, String> update(Customer customer);

    ImmutablePair<Customer, String> findById(String id);
    ImmutablePair<List<Customer>, String> getAll();
    ImmutablePair<List<CustomerDto>, String> getAllDto();
    ImmutablePair<Boolean, String> delete(List<String> ids);
    ImmutablePair<Customer, String> delete(String id);
}
