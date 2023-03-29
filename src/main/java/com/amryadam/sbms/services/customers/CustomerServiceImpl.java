package com.amryadam.sbms.services.customers;

import com.amryadam.sbms.entities.customers.Customer;
import com.amryadam.sbms.repository.customer.CustomerRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ImmutablePair<Customer, String> save(Customer customer) {
        try {
            var _customers = customerRepository.save(customer);
            return ImmutablePair.of(_customers, "");
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<List<Customer>, String> save(List<Customer> customerList) {
        try {
            var _customers = customerRepository.saveAll(customerList);
            return ImmutablePair.of(_customers, "");
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Customer, String> update(Customer customer) {
        try {
            var c = customerRepository.findById(customer.getId());
            if (c.isPresent()) {
                var _customers = customerRepository.save(customer);
                return ImmutablePair.of(_customers, "");
            } else {
                return ImmutablePair.of(null, null);
            }
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<List<Customer>, String> getAll() {
        try {
            var _customers = customerRepository.findAll();
            if (!_customers.isEmpty()) {
                return ImmutablePair.of(_customers, "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Customer, String> findById(String id) {
        try {
            var _customer = customerRepository.findById(id);
            if (_customer.isPresent()) {
                return ImmutablePair.of(_customer.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Customer, String> delete(String id) {
        Customer _customer;
        try {
            Optional<Customer> c = customerRepository.findById(id);
            if (c.isPresent()) {
                _customer = c.get();
                customerRepository.deleteById(id);
                return ImmutablePair.of(_customer, "");
            } else {
                return null;
            }
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());
        }
    }

    @Override
    public ImmutablePair<Boolean, String> delete(List<String> ids) {
        try {
            customerRepository.deleteAllById(ids);
            return ImmutablePair.of(true, "");
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(false, ex.getMessage());
        }
    }
}
