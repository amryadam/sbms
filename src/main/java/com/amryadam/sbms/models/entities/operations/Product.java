package com.amryadam.sbms.models.entities.operations;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

//TODO make it auditable


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //TODO auto generate with custom sequence
    private String code;

    private String name;

    private Double price;

    private Integer rating;

    private String imageUri;

    private String description;

    private  String inventoryStatus = "INSTOCK";

    @ManyToMany
    @JoinTable(
            name = "ProductCategory",
            foreignKey = @ForeignKey(name = "FK_ProductCategory_ProductId_Product_Id"),
            inverseForeignKey = @ForeignKey(name = "FK_ProductCategory_Category_Category_Id"),
            joinColumns = @JoinColumn(name = "ProductId"),
            inverseJoinColumns = {@JoinColumn(name = "CategoryId")}
    )
    private List<Category> categories;


}
