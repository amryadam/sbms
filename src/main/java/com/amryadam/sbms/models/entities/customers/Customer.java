package com.amryadam.sbms.models.entities.customers;

import com.amryadam.sbms.models.entities.common.ULIDGenerator;
import com.amryadam.sbms.models.entities.operations.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.azam.ulidj.ULID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GenericGenerator(name = "ULIDGen", strategy = "com.amryadam.sbms.models.entities.common.ULIDGenerator")
    @GeneratedValue(generator = "ULIDGen")
    private String id;
//
//    @Id
    @GenericGenerator(name = "ULIDGen", strategy = "com.amryadam.sbms.models.entities.common.ULIDGenerator")
    @GeneratedValue(generator = "ULIDGen")
    private String id2;


    @PrePersist
    protected void onCreate() {
        this.setId2();
    }

    private void setId2(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String formattedDate = date.format(formatter);
        String prefix = formattedDate;
//        try {
//            Connection connection = session.connection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select count(id) from student");
//            if(resultSet.next()) {
//                Integer id = resultSet.getInt(1) + 1;
//                suffix = id.toString();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        this.id2 = prefix + "-" + ULID.random();
    }


    private String code;

    @NotBlank(message = "name is mandatory")
    private String name;

    private String email;

    private String imageUri;

    private String description;

    @Min(value = 12)
    private Integer age;

    @Column(precision = 2)
    private float review;

    @Column(length = 50)
    private String category;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orderList = new LinkedList<>();

    public Customer() {

    }

    public Customer(String code, String name, String email, String imageUri, String description, Integer age, float review, String category) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.imageUri = imageUri;
        this.description = description;
        this.age = age;
        this.review = review;
        this.category = category;
    }
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Order> OrderList = new LinkedList<>();

}
