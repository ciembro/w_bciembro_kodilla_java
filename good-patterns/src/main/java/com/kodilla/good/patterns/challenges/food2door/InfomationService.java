package com.kodilla.good.patterns.challenges.food2door;

public interface InfomationService {

    void sendWhenOrderedAccepted(OrderRequest orderRequest);
    void sendWhenOrderedDenied(OrderRequest orderRequest);

    void sendWhenShipped(OrderRequest orderRequest);
}
