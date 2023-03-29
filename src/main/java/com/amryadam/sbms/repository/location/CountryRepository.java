package com.amryadam.sbms.repository.location;

import com.amryadam.sbms.entities.locations.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
