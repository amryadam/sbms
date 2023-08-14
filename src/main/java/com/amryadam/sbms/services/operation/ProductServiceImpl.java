package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Product;
import com.amryadam.sbms.repository.operation.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service @AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ImmutablePair<Product, String> save(Product product) {
        try {
            var _products = productRepository.save(product);
            return ImmutablePair.of(_products, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<List<Product>, String> save(List<Product> productList) {
        try {
            var _products = productRepository.saveAllAndFlush(productList);
            return ImmutablePair.of(_products, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Product, String> update(Product product) {
        try {
            var c = productRepository.findById(product.getId());
            if (c.isPresent()) {
                var _products = productRepository.save(product);
                return ImmutablePair.of(_products, "");
            } else {
                return ImmutablePair.of(null, null);
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<List<Product>, String> getAll() {
        try {
            var _products = productRepository.findAll();
            if (!_products.isEmpty()) {
                return ImmutablePair.of(_products, "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Product, String> findById(UUID id) {
        try {
            var _product = productRepository.findById(id);
            if (_product.isPresent()) {
                return ImmutablePair.of(_product.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Product, String> delete(UUID id) {
        Product _product;
        try {
            Optional<Product> c = productRepository.findById(id);
            if (c.isPresent()) {
                _product = c.get();
                productRepository.deleteById(id);
                return ImmutablePair.of(_product, "");
            } else {
                return null;
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());
        }
    }

    @Override
    public ImmutablePair<Boolean, String> delete(List<UUID> ids) {
        try {
            productRepository.deleteAllById(ids);
            return ImmutablePair.of(true, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(false, ex.getMessage());
        }
    }
}
