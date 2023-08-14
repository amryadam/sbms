package com.amryadam.sbms.controller.customer;

import com.amryadam.sbms.models.dtos.customer.CustomerDto;
import com.amryadam.sbms.models.entities.customers.Customer;
import com.amryadam.sbms.services.customers.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody   Customer customer) {
        var pair = customerService.save(customer);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            //TODO return error message
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCreate( @Valid  @RequestBody Customer customer) {

        var pair = customerService.update(customer);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            if (pair.getRight() == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                //TODO return error message
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll() {
        var pair = customerService.getAll();

        if (!pair.getLeft().isEmpty()) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/customersDto")
    public ResponseEntity<List<CustomerDto>> getAllDto() {
        var pair = customerService.getAllDto();

        if (!pair.getLeft().isEmpty()) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id) {
        var pair = customerService.delete(id);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/customers/deleteSelected")
    public ResponseEntity<HttpStatus> deleteCustomers(@RequestBody() List<String> ids) {
        var pair = customerService.delete(ids);
        if (pair.getLeft() == true) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
