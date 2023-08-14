package com.amryadam.sbms.controller.operation;

import com.amryadam.sbms.models.entities.operations.OrderDetails;
import com.amryadam.sbms.services.operation.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @PostMapping(value = "/orderDetails")
    public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails orderDetails) {
        var pair = orderDetailsService.save(orderDetails);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.CREATED);
        } else {
            //TODO return error message
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/orderDetails")
    public ResponseEntity<OrderDetails> updateCreate(@RequestBody OrderDetails orderDetails) {

        var pair = orderDetailsService.update(orderDetails);
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

    @GetMapping("/orderDetails")
    public ResponseEntity<List<OrderDetails>> getAll() {
        var pair = orderDetailsService.getAll();

        if (!pair.getLeft().isEmpty()) {
            return new ResponseEntity<>(pair.getLeft(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/orderDetails/{id}")
    public ResponseEntity<HttpStatus> deleteOrderDetails(@PathVariable("id") UUID id) {
        var pair = orderDetailsService.delete(id);
        if (pair.getLeft() != null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/orderDetails/deleteSelected")
    public ResponseEntity<HttpStatus> deleteOrderDetails(@RequestBody() List<UUID> ids) {
        var pair = orderDetailsService.delete(ids);
        if (pair.getLeft() == true) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
