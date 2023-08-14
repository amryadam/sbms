package com.amryadam.sbms.controller.operation;

import com.amryadam.sbms.models.entities.operations.Product;
import com.amryadam.sbms.services.operation.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    @PostMapping(value = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        var pair = productService.save(product);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            //TODO return error message
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateCreate(@RequestBody Product product) {

        var pair = productService.update(product);
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

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        var pair = productService.getAll();

        if (!pair.getLeft().isEmpty()) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") UUID id) {
        var pair = productService.delete(id);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/products/deleteSelected")
    public ResponseEntity<HttpStatus> deleteProducts(@RequestBody()  List<UUID> ids) {
        var pair = productService.delete(ids);
        if (pair.getLeft() == true) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


