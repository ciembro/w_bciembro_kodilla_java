package com.kodilla.good.patterns.challenges.allegro;

import java.util.HashMap;
import java.util.Map;

public class MapOrderRepository implements OrderRepository{

    Map<OrderRequest, Boolean> transactions = new HashMap<>();

    public void createOrder(TransactionDto transactionDto){
        transactions.put(transactionDto.getOrderRequest(), transactionDto.isAccepted());
    }
}
