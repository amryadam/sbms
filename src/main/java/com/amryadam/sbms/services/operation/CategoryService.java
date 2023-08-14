package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Category;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    ImmutablePair<Category, String> save(Category category);
    ImmutablePair<List<Category>, String> save(List<Category> categoryList);

    ImmutablePair<Category, String> update(Category category);

    ImmutablePair<Category, String> findById(UUID id);
    ImmutablePair<List<Category>, String> getAll();
    ImmutablePair<Boolean, String> delete(List<UUID> ids);
    ImmutablePair<Category, String> delete(UUID id);
}
