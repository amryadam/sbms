package com.amryadam.sbms.models.entities.operations;

import com.amryadam.sbms.models.entities.customers.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "[Order]")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;

    private Double totalOrder;

    private Integer totalItems;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_Order_CustomerId_Customer_Id")
    )
    private Customer customer;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<OrderDetails> detailsList = new LinkedList<>();


    public void addDetail(OrderDetails details) {
        detailsList.add(details);
        details.setOrder(this);
    }

    public void removeDetail(OrderDetails details) {
        detailsList.remove(details);
        details.setOrder(null);
    }

    public Order(UUID id, String code, Double totalOrder, Integer totalItems, Customer customer) {
        this.id = id;
        this.code = code;
        this.totalOrder = totalOrder;
        this.totalItems = totalItems;
        this.customer = customer;
    }
}
