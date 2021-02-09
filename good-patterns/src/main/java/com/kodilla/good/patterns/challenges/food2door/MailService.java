package com.kodilla.good.patterns.challenges.food2door;


import com.kodilla.good.patterns.challenges.food2door.InfomationService;
import com.kodilla.good.patterns.challenges.food2door.OrderRequest;


public class MailService implements InfomationService {

    @Override
    public void sendWhenOrderedAccepted(OrderRequest orderRequest) {
        System.out.println("Hello, " + orderRequest.getUser().getFirstName() + " " +
                orderRequest.getUser().getSecondName() + "!");
        System.out.println("Your order has been accepted.");
    }

    @Override
    public void sendWhenOrderedDenied(OrderRequest orderRequest) {
        System.out.println("Hello, " + orderRequest.getUser().getFirstName() + " " +
                orderRequest.getUser().getSecondName() + "!");
        System.out.println("Your order cannot be proccesed. Please try again.");
    }

    @Override
    public void sendWhenShipped(OrderRequest orderRequest) {
        System.out.println("Hello, " + orderRequest.getUser().getFirstName() + " " +
                orderRequest.getUser().getSecondName() + "!");
        System.out.println("Your order from " + orderRequest.getOrder().getProducer().getProducerName() +
                " has been shipped and should arrive in few hours");
    }
}
