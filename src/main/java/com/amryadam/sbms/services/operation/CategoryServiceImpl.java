package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Category;
import com.amryadam.sbms.models.entities.operations.Category;
import com.amryadam.sbms.repository.operation.CategoryRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public ImmutablePair<Category, String> save(Category category) {
        try {
            var _categorys = categoryRepository.save(category);
            return ImmutablePair.of(_categorys, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<List<Category>, String> save(List<Category> categoryList) {
        try {
            var _categorys = categoryRepository.saveAllAndFlush(categoryList);
            return ImmutablePair.of(_categorys, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Category, String> update(Category category) {
        try {
            var c = categoryRepository.findById(category.getId());
            if (c.isPresent()) {
                var _categorys = categoryRepository.save(category);
                return ImmutablePair.of(_categorys, "");
            } else {
                return ImmutablePair.of(null, null);
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<List<Category>, String> getAll() {
        try {
            var _categorys = categoryRepository.findAll();
            if (!_categorys.isEmpty()) {
                return ImmutablePair.of(_categorys, "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Category, String> findById(UUID id) {
        try {
            var _category = categoryRepository.findById(id);
            if (_category.isPresent()) {
                return ImmutablePair.of(_category.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Category, String> delete(UUID id) {
        Category _category;
        try {
            Optional<Category> c = categoryRepository.findById(id);
            if (c.isPresent()) {
                _category = c.get();
                categoryRepository.deleteById(id);
                return ImmutablePair.of(_category, "");
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
            //TODO handle sql exception like foreign key constrain and propagate error message to frontend
            categoryRepository.deleteAllById(ids);
            return ImmutablePair.of(true, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(false, ex.getMessage());
        }
    }
}
