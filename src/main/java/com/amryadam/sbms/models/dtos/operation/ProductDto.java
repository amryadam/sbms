package com.amryadam.sbms.models.dtos.operation;

import java.util.UUID;

public record ProductDto(UUID id,
                         String code,
                         String name,
                         Double price,
                         Integer rating) {
}
