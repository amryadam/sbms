package com.amryadam.sbms.controller;

import com.amryadam.sbms.model.customers.Customer;
import com.amryadam.sbms.services.customers.CustomerService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService<Customer> customerService;


    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/customer")
    public String addCustomer(){
        var customer = CreateCustomer();
        customerService.add(customer);
        return customer.toString();
    }

    public Customer CreateCustomer(){
        Faker faker = new Faker();
        var _customer = new Customer();
        _customer.setName(faker.name().fullName());
        //System.out.println("call from create customer " + _customer);
        return  _customer;
    }
}
