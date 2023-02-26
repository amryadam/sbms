package com.amryadam.sbms.services.locations;

import com.amryadam.sbms.model.locations.City;

public interface CityService {
    City save(City city);
    void delete(City city);
    void delete(Long id);
}
