package com.amryadam.sbms.repository.operation;

import com.amryadam.sbms.models.entities.operations.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID> {

}
