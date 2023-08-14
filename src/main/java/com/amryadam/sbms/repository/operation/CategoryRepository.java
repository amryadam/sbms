package com.amryadam.sbms.repository.operation;

import com.amryadam.sbms.models.entities.operations.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
