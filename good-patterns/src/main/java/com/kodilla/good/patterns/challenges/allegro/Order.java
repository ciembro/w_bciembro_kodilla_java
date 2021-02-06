package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;

public class Order {

    private final Product product;
    private final int quantity;
    private final LocalDate orderDate;

    public Order(Product orderObject, int quantity, LocalDate orderDate) {
        this.product = orderObject;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public double getOrderValue(){
        return quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
