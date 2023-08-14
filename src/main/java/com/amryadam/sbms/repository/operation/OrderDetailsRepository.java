package com.amryadam.sbms.repository.operation;

import com.amryadam.sbms.models.entities.operations.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, UUID> {
}
