package com.kodilla.good.patterns.challenges.allegro;

public class OrderRequest {

    private final User user;
    private final Order order;

    public OrderRequest(final User user, final Order order) {
        this.user = user;
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }
}
