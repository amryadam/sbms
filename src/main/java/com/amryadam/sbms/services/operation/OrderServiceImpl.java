package com.amryadam.sbms.services.operation;

import com.amryadam.sbms.models.entities.operations.Order;
import com.amryadam.sbms.repository.operation.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service @AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public ImmutablePair<Order, String> save(Order order) {
        try {
            var _orders = orderRepository.save(order);
            return ImmutablePair.of(_orders, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<List<Order>, String> save(List<Order> orderList) {
        try {
            var _orders = orderRepository.saveAllAndFlush(orderList);
            return ImmutablePair.of(_orders, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Order, String> update(Order order) {
        try {
            var c = orderRepository.findById(order.getId());
            if (c.isPresent()) {
                var _orders = orderRepository.save(order);
                return ImmutablePair.of(_orders, "");
            } else {
                return ImmutablePair.of(null, null);
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<List<Order>, String> getAll() {
        try {
            var _orders = orderRepository.findAll();
            if (!_orders.isEmpty() |_orders != null  ) {
                return ImmutablePair.of(_orders, "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Order, String> findById(UUID id) {
        try {
            var _order = orderRepository.findById(id);
            if (_order.isPresent()) {
                return ImmutablePair.of(_order.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (RuntimeException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

    @Override
    public ImmutablePair<Order, String> delete(UUID id) {
        Order _order;
        try {
            Optional<Order> c = orderRepository.findById(id);
            if (c.isPresent()) {
                _order = c.get();
                orderRepository.deleteById(id);
                return ImmutablePair.of(_order, "");
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
            orderRepository.deleteAllById(ids);
            return ImmutablePair.of(true, "");
        } catch (RuntimeException ex) {
            return ImmutablePair.of(false, ex.getMessage());
        }
    }
}
