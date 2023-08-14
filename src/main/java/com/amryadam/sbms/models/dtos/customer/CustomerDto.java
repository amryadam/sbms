package com.amryadam.sbms.models.dtos.customer;


public record CustomerDto(
        String id,
        String code,
        String name,
        String email,
        String imageUri,
        String description,
        Integer age,
        float review,
        String category

        ) {

}
