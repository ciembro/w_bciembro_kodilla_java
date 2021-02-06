package com.kodilla.good.patterns.challenges.allegro;

public abstract class Product {

    protected String productName;
    protected double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
