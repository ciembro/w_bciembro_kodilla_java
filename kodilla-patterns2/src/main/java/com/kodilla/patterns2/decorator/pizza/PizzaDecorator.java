package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaDecorator implements Pizza{

    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
