package com.amryadam.sbms.controller.operation;


import com.amryadam.sbms.models.entities.operations.Order;
import com.amryadam.sbms.services.operation.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController @AllArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        var pair = orderService.save(order);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            //TODO return error message
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/orders")
    public ResponseEntity<Order> updateCreate(@RequestBody Order order) {

        var pair = orderService.update(order);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            if (pair.getRight() == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                //TODO return error message
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAll() {
        var pair = orderService.getAll();

        if (!pair.getLeft().isEmpty()) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") UUID id) {
        var pair = orderService.delete(id);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/orders/deleteSelected")
    public ResponseEntity<HttpStatus> deleteOrders(@RequestBody() List<UUID> ids) {
        var pair = orderService.delete(ids);
        if (pair.getLeft() == true) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
