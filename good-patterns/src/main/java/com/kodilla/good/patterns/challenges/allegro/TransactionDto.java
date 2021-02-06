package com.kodilla.good.patterns.challenges.allegro;

public class TransactionDto {

    private final OrderRequest orderRequest;
    private final boolean isAccepted;

    public TransactionDto(final OrderRequest orderRequest, final boolean isAccepted) {
        this.orderRequest = orderRequest;
        this.isAccepted = isAccepted;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
