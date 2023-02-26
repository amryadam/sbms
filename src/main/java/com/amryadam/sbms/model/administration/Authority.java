//package com.amryadam.sbms.model.administration;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "Authorities")
//@Getter
//@Setter
//public class Authority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    @ManyToMany(mappedBy = "authorities")
//    private Set<User> users;
//}