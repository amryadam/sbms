package com.amryadam.sbms.models.entities.customers;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String name;

//    @ManyToMany @JsonIgnore
//    @JoinTable(
//            name = "ContactCustomer",
//            foreignKey = @ForeignKey(name = "FK_ContactCustomer_ContactId_Contact_Id"),
//            joinColumns = @JoinColumn(name = "ContactId"),
//            inverseJoinColumns = {@JoinColumn(name = "CustomerId")}
//    )
//    private Set<Customer> customerList = new HashSet<>();
}
