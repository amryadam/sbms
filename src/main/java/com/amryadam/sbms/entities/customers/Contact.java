package com.amryadam.sbms.entities.customers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


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

    @ManyToMany @JsonIgnore
    @JoinTable(
            name = "ContactCustomer",
            foreignKey = @ForeignKey(name = "FK_ContactCustomer_ContactId_Contact_Id"),
            joinColumns = @JoinColumn(name = "ContactId"),
            inverseJoinColumns = {@JoinColumn(name = "CustomerId")}
    )
    private Set<Customer> customerList = new HashSet<>();
}
