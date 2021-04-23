package com.kodilla.patterns2.decorator.taxiportal.pizza;

import com.kodilla.patterns2.decorator.pizza.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {


    @Test
    void getExtraCheesePizza(){
        //given
        Pizza pizza = new BasicPizza();
        pizza = new ExtraCheeseDecorator(pizza);
        //when
        BigDecimal cost = pizza.getCost();
        String desc =  pizza.getDescription();
        //then
        assertEquals(new BigDecimal(20), cost);
        assertEquals("Pizza: sauce, cheese, extra cheese", desc);
    }

    @Test
    void getBaconMushroomPizza(){
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new MushroomDecorator(pizza);
        BigDecimal cost = pizza.getCost();
        String desc =  pizza.getDescription();
        //then
        assertEquals(new BigDecimal(22), cost);
        assertEquals("Pizza: sauce, cheese, bacon, mushrooms", desc);

    }
}
