package com.amryadam.sbms.entities.customers;

import com.amryadam.sbms.entities.operations.Operation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GenericGenerator(name = "ULIDGen", strategy = "com.amryadam.sbms.entities.common.ULIDGenerator")
    @GeneratedValue(generator = "ULIDGen")
    private String id;
    private String name;
     private String email;

    @GeneratedValue(generator = "ULIDGen")
    private String code;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<Operation> operation = new LinkedList<>();
    private String imageUri;
    private String description;
    private Integer age;
    @Column(precision = 2)
    private float review;
    @Column(length = 50)
    private String category;

    @ManyToMany
    @JoinTable(
            name = "ContactCustomer",
            foreignKey = @ForeignKey(name = "FK_ContactCustomer_CustomerId_Customer_Id"),
            joinColumns = @JoinColumn(name = "CustomerId"),
            inverseJoinColumns = @JoinColumn(name = "ContactId")
    )
    private Set<Contact> contactList = new HashSet<>();

}
