package com.amryadam.sbms.models.dtos.operation;

import com.amryadam.sbms.models.entities.operations.Product;

import java.util.UUID;

public record OrderDetailsDto(
        UUID id,
        double pricePerItem,
        Integer numberOfItems,
        double total,
        Product product
) {
}
