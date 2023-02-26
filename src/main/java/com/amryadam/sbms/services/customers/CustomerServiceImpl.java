package com.amryadam.sbms.services.customers;

import com.amryadam.sbms.model.customers.Customer;
import com.amryadam.sbms.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {


    @Autowired
    private CustomerRepository customerRepository ;


    @Override
    public void add(List<Customer> customerList) {
        var x = customerRepository.saveAll(customerList);
    }

    @Override
    public Customer add(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);

    }
}
