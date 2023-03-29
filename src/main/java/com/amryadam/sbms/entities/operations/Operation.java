package com.amryadam.sbms.entities.operations;


import com.amryadam.sbms.entities.customers.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "Operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String code;

    @ManyToOne(fetch =FetchType.LAZY ,cascade =
            {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "CustomerId",foreignKey = @ForeignKey(name = "FK_Operation_CustomerId_Customer_Id"))
    private Customer customer;
}
