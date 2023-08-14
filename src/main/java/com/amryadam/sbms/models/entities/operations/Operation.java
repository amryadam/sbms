package com.amryadam.sbms.models.entities.operations;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "Operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
//    @ManyToOne(fetch =FetchType.LAZY ,cascade =
//            {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH})
//    @JoinColumn(name = "CustomerId",foreignKey = @ForeignKey(name = "FK_Operation_CustomerId_Customer_Id"))
//    private Customer customer;
}
