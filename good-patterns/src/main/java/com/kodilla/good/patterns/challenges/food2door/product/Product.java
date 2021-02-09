package com.kodilla.good.patterns.challenges.food2door.product;

public abstract class Product {

    protected final String productName;
    protected double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
