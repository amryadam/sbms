package com.amryadam.sbms.repository.location;


import com.amryadam.sbms.entities.locations.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
