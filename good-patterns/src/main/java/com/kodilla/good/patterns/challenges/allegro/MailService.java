package com.kodilla.good.patterns.challenges.allegro;

public class MailService implements InformationService{

    @Override
    public void sendProductHasBeenShippedMessage(OrderRequest orderRequest) {
        System.out.println("Hello, " + orderRequest.getUser().getFirstName() + " "
                + orderRequest.getUser().getSecondName() + "!");
        System.out.println("Your " + orderRequest.getOrder().getProduct()
                + " from " + orderRequest.getOrder().getOrderDate() + " has been sent.");
    }
}
