package com.amryadam.sbms.models.dtos.operation;

import com.amryadam.sbms.models.entities.customers.Customer;
import com.amryadam.sbms.models.entities.operations.OrderDetails;

import java.util.List;
import java.util.UUID;

public record OrderDto(
        UUID id,
        String code,
        Double totalOrder,
        Integer totalItems,
        Customer customer,
        List<OrderDetails> detailsList

) {

}
