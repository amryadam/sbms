package com.amryadam.sbms.repository.operation;

import com.amryadam.sbms.entities.operations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
