package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.OrderProcessor;
import com.kodilla.good.patterns.challenges.food2door.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.product.Apple;
import com.kodilla.good.patterns.challenges.food2door.product.Potato;

public class HealthyShop extends Producer {

    private static final String PRODUCER_NAME = "Healthy Shop";

    public HealthyShop(){
        super(PRODUCER_NAME, new ProducerWarehouse());
        supplyWarehouse();
    }

    private void supplyWarehouse(){
        producerWarehouse.addProduct(new Potato(1.50), 400);
        producerWarehouse.addProduct(new Apple(2.99), 250);
    }

    public boolean process(OrderRequest orderRequest){
        OrderProcessor orderProcessor = new OrderProcessor();
        System.out.println("Thanks for choosing Healthy Shop!");
        return orderProcessor.processOrder(orderRequest);
    }
}
