package com.amryadam.sbms.repository.location;

import com.amryadam.sbms.models.entities.locations.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, String> {
}
