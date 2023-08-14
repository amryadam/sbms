package com.amryadam.sbms.models.entities.locations;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String codeGenerate;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_city_country_id_country_id") ,
            name = "country_id")
    private Country country;



}
