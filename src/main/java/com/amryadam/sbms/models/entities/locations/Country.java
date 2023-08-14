package com.amryadam.sbms.models.entities.locations;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String Name;
    private String Code;

}
