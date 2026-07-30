package com.junaid;

import java.util.List;

import com.junaid.model.Country;
import com.junaid.service.CountryService;

public class App {

    public static void main(String[] args) {

        CountryService service = new CountryService();

        List<Country> countries = service.getAllCountriesByPopulation();

        System.out.println("Total Countries: " + countries.size());

        for (int i = 0; i < 10 && i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }
}