package com.amryadam.sbms.model.customers;

import com.amryadam.sbms.model.operations.Operation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.LinkedList;


@Getter @Setter
@Entity
@Table(name="Customer")
public class Customer{
    @Id
    @GenericGenerator(name = "ULIDGen", strategy = "com.amryadam.sbms.model.common.ULIDGenerator")
    @GeneratedValue(generator = "ULIDGen")
    private String id;
    private String name;
    @GeneratedValue(generator = "ULIDGen")
    private String code;
    @OneToMany(mappedBy = "customer",cascade =
            {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH})
    private LinkedList<Operation> operation;

    @ManyToMany
    @JoinTable(
            name = "ContactCustomer",
            foreignKey = @ForeignKey(name = "FK_ContactCustomer_CustomerId_Customer_Id"),
            joinColumns = @JoinColumn(name = "CustomerId"),
            inverseJoinColumns = @JoinColumn(name = "ContactId")
    )
    private LinkedList<Contact> contactList;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
