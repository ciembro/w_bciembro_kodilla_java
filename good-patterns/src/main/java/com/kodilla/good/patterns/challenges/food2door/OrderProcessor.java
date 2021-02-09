package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.producer.Producer;
import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.Map;

public class OrderProcessor {

    public boolean processOrder(OrderRequest orderRequest){
        Map<Product, Integer> orderList = orderRequest.getOrder().getProductList();
        Producer producer = orderRequest.getOrder().getProducer();

        for (Map.Entry<Product, Integer> entry : producer.getProducerWarehouse().getWarehouse().entrySet()){
            Product product = entry.getKey();
            if (!producer.getProducerWarehouse().checkAvailability(product, orderList.get(product))){
                return false;
            }
        }
        return true;
    }
}
