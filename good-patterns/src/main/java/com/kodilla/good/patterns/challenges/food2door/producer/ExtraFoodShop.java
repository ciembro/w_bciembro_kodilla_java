package com.kodilla.good.patterns.challenges.food2door.producer;


import com.kodilla.good.patterns.challenges.food2door.OrderProcessor;
import com.kodilla.good.patterns.challenges.food2door.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.product.Apple;
import com.kodilla.good.patterns.challenges.food2door.product.Orange;

public class ExtraFoodShop extends Producer{

    private static final String PRODUCER_NAME = "Extra Food Shop";

    public ExtraFoodShop(){
        super(PRODUCER_NAME, new ProducerWarehouse());
        supplyWarehouse();
    }

    private void supplyWarehouse(){
        producerWarehouse.addProduct(new Orange(2.50), 300);
        producerWarehouse.addProduct(new Apple(1.30), 250);
    }

    public boolean process(OrderRequest orderRequest){
        OrderProcessor orderProcessor = new OrderProcessor();
        System.out.println("Thanks for choosing Extra Food Shop!");
        return orderProcessor.processOrder(orderRequest);
    }


}
