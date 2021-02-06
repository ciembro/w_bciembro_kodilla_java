package com.kodilla.good.patterns.challenges.allegro;

public class BankTransferPaymentProcessor implements PaymentProcessor{

    public boolean processPayment(final OrderRequest orderRequest){
        double availableMoney = orderRequest.getUser().getAccountBalance();
        double moneyNeeded = orderRequest.getOrder().getOrderValue();
        if (availableMoney >= moneyNeeded){
            orderRequest.getUser().updateBalance(moneyNeeded);
            return true;
        }
        return false;
    }
}
