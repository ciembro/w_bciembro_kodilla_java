package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.producer.Producer;
import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.time.LocalDate;
import java.util.Map;

public class Order {

    private final Producer producer;
    private final Map<Product, Integer> productList;
    private final LocalDate orderDate;

    public Order(Producer producer, Map<Product, Integer> productList) {
        this.producer = producer;
        this.productList = productList;
        this.orderDate = LocalDate.now();
    }

    public Producer getProducer() {
        return producer;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
