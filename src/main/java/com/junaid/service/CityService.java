package com.junaid.service;

import com.junaid.repository.CityRepository;

public class CityService {

    private final CityRepository cityRepository;

    public CityService() {
        this.cityRepository = new CityRepository();
    }

}