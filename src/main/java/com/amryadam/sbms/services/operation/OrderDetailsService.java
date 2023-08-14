package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.OrderDetails;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.UUID;

public interface OrderDetailsService {

    ImmutablePair<OrderDetails, String> save(OrderDetails orderDetails);
    ImmutablePair<List<OrderDetails>, String> save(List<OrderDetails> orderDetailsList);

    ImmutablePair<OrderDetails, String> update(OrderDetails orderDetails);

    ImmutablePair<OrderDetails, String> findById(UUID id);
    ImmutablePair<List<OrderDetails>, String> getAll();
    ImmutablePair<Boolean, String> delete(List<UUID> ids);
    ImmutablePair<OrderDetails, String> delete(UUID id);
}
