package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends PizzaDecorator{

    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", extra cheese";
    }
}
