package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.OrderDetails;
import com.amryadam.sbms.repository.operation.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public ImmutablePair<OrderDetails, String> save(OrderDetails orderDetails) {
        try {
            var _orders = orderDetailsRepository.save(orderDetails);
            return ImmutablePair.of(_orders, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<List<OrderDetails>, String> save(List<OrderDetails> orderDetailsList) {
        try {
            var _orders = orderDetailsRepository.saveAll(orderDetailsList);
            return ImmutablePair.of(_orders, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<OrderDetails, String> update(OrderDetails orderDetails) {
        try {
            var c = orderDetailsRepository.findById(orderDetails.getId());
            if (c.isPresent()) {
                var _orders = orderDetailsRepository.save(orderDetails);
                return ImmutablePair.of(_orders, "");
            } else {
                return ImmutablePair.of(null, null);
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<List<OrderDetails>, String> getAll() {
        try {
            var _ordersDetails = orderDetailsRepository.findAll();
            if (!_ordersDetails.isEmpty()) {
                return ImmutablePair.of(_ordersDetails, "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<OrderDetails, String> findById(UUID id) {
        try {
            var _orderDetails = orderDetailsRepository.findById(id);
            if (_orderDetails.isPresent()) {
                return ImmutablePair.of(_orderDetails.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<OrderDetails, String> delete(UUID id) {
        OrderDetails _orderDetail;
        try {
            Optional<OrderDetails> c = orderDetailsRepository.findById(id);
            if (c.isPresent()) {
                _orderDetail = c.get();
                orderDetailsRepository.deleteById(id);
                return ImmutablePair.of(_orderDetail, "");
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
            orderDetailsRepository.deleteAllById(ids);
            return ImmutablePair.of(true, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(false, ex.getMessage());
        }
    }
}
