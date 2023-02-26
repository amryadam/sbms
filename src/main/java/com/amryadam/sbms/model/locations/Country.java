package com.amryadam.sbms.model.locations;

import com.amryadam.sbms.model.common.BaseAuditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COUNTRY")
public class Country extends BaseAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private String Code;

}
