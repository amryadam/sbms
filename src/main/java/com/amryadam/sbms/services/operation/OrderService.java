package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Order;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    ImmutablePair<Order, String> save(Order order);
    ImmutablePair<List<Order>, String> save(List<Order> orderList);

    ImmutablePair<Order, String> update(Order order);

    ImmutablePair<Order, String> findById(UUID id);
    ImmutablePair<List<Order>, String> getAll();
    ImmutablePair<Boolean, String> delete(List<UUID> ids);
    ImmutablePair<Order, String> delete(UUID id);
}
