package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    List<Country> countries = new ArrayList<>();

    public List<Country> getCountries(){
        return new ArrayList<>(countries);
    }

    public void addCountry(Country country){
        countries.add(country);
    }
}
