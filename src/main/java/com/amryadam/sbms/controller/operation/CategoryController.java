package com.amryadam.sbms.controller.operation;


import com.amryadam.sbms.models.entities.operations.Category;
import com.amryadam.sbms.services.operation.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CategoryController {
     private CategoryService categoryService;

    @PostMapping(value = "/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        var pair = categoryService.save(category);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            //TODO return error message
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCreate(@RequestBody Category category) {

        var pair = categoryService.update(category);
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

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAll() {
        var pair = categoryService.getAll();

        if (pair.getLeft() != null ) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") UUID id) {
        var pair = categoryService.delete(id);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/categories/deleteSelected")
    public ResponseEntity<HttpStatus> deleteCategories(@RequestBody() List<UUID> ids) {
        var pair = categoryService.delete(ids);
        if (pair.getLeft() == true) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
