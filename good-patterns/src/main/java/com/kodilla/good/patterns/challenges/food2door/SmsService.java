package com.kodilla.good.patterns.challenges.food2door;

public class SmsService implements InfomationService {
    @Override
    public void sendWhenOrderedAccepted(OrderRequest orderRequest) {
        System.out.println("Hello, your order from" + orderRequest.getOrder().getProducer().getProducerName() +
                " is being prepared");
    }

    @Override
    public void sendWhenOrderedDenied(OrderRequest orderRequest) {
        System.out.println("Hello, " + orderRequest.getUser().getFirstName() + " " +
                orderRequest.getUser().getSecondName() + "!");
        System.out.println("Something went wrong with your order. Please contact with our support.");
    }

    @Override
    public void sendWhenShipped(OrderRequest orderRequest) {
        System.out.println("Delivery from " + orderRequest.getOrder().getProducer().getProducerName() +
                " should arrive today.");
    }
}
