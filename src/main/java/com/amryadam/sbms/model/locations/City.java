package com.amryadam.sbms.model.locations;

import com.amryadam.sbms.model.common.BaseAuditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "CITY")
public class City  extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String codeGenerate;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_city_country_id_country_id") ,
            name = "country_id")
    private Country country;



}
