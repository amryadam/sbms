package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ImmutablePair<Product, String> save(Product product);
    ImmutablePair<List<Product>, String> save(List<Product> productList);

    ImmutablePair<Product, String> update(Product product);

    ImmutablePair<Product, String> findById(UUID id);
    ImmutablePair<List<Product>, String> getAll();
    ImmutablePair<Boolean, String> delete(List<UUID> ids);
    ImmutablePair<Product, String> delete(UUID id);
}
