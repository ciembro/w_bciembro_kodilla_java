package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.HashMap;
import java.util.Map;

public class ProducerWarehouse {

    private final Map<Product, Integer> warehouse = new HashMap<>();

    public void addProduct(Product product, int quantity){
        warehouse.put(product, quantity);
    }

    public boolean checkAvailability(Product product, int quantityNeeded){
        if (warehouse.containsKey(product)){
            if (warehouse.get(product) >= quantityNeeded){
                updateAvailability(product, quantityNeeded);
                return true;
            }
        }
        return false;
    }

    public Map<Product, Integer> getWarehouse() {
        return warehouse;
    }

    public void updateAvailability(Product product, int quantityNeeded){
        int availableQuantity = warehouse.get(product);
        warehouse.replace(product, availableQuantity, availableQuantity - quantityNeeded);

    }
}
