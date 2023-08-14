package com.amryadam.sbms.repository.operation;

import com.amryadam.sbms.models.entities.operations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,String> {
}
