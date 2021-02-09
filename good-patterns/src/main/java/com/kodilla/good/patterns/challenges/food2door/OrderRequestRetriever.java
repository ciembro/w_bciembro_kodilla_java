package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.producer.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.producer.Producer;
import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.*;

public class OrderRequestRetriever {

    public OrderRequest getOrderRequest(){
        User user = new User("Karolina", "Kowalska",150);
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        Map<String, Integer> productList = new HashMap<>();
        productList.put("orange", 40);
        productList.put("apple", 6);

        Map<Product, Integer> orderList = getProductList(extraFoodShop, productList);
        Order order = new Order(extraFoodShop, orderList );

        return new OrderRequest(user, order);
    }

    private Map<Product, Integer> getProductList(Producer producer, Map<String, Integer> products){
        Map<Product, Integer> productList = new HashMap<>();
        for (Map.Entry<String, Integer> requiredProduct : products.entrySet()){
            for (Map.Entry<Product, Integer> entry : producer.getProducerWarehouse().getWarehouse().entrySet()){
                if (entry.getKey().getProductName().equals(requiredProduct.getKey())){
                    productList.put(entry.getKey(), requiredProduct.getValue());
                }
            }
        }
        return productList;
    }


}
