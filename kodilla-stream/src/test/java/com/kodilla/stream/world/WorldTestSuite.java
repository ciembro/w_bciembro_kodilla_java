package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Country Poland = new Country(new BigDecimal("100"));
        Country Slovakia = new Country(new BigDecimal("50"));
        Country Spain = new Country(new BigDecimal("150"));

        Continent europe = new Continent();
        europe.addCountry(Poland);
        europe.addCountry(Slovakia);
        europe.addCountry(Spain);

        Country China = new Country(new BigDecimal("1000"));
        Country Japan = new Country(new BigDecimal("500"));
        Country Tailand = new Country(new BigDecimal("200"));

        Continent asia = new Continent();
        europe.addCountry(China);
        europe.addCountry(Japan);
        europe.addCountry(Tailand);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("2000"),totalPeople);


    }
}
