package com.amryadam.sbms.services.locations;

import com.amryadam.sbms.entities.locations.City;
import com.amryadam.sbms.repository.location.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public City save(City city) {
        var _city  = cityRepository.saveAndFlush(city);
        return _city;
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
