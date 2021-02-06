package com.kodilla.good.patterns.challenges.allegro;

public class TransactionService {

    PaymentProcessor paymentProcessor;
    OrderRequest orderRequest;


    public TransactionService(OrderRequest orderRequest, PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
        this.orderRequest = orderRequest;
    }

    public boolean sell(){
       return paymentProcessor.processPayment(orderRequest);
    }

}
