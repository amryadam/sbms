package com.amryadam.sbms.model.customers;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Contact")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "ContactCustomer",
            foreignKey = @ForeignKey(name = "FK_ContactCustomer_ContactId_Contact_Id"),
            joinColumns = @JoinColumn(name = "ContactId"),
            inverseJoinColumns = {@JoinColumn(name = "CustomerId")}
    )
    private List<Customer> customerList;
}
