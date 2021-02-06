package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest getData(){
        User user = new User("Jan", "Kowalski", 320.50);
        Book book = new Book("HP i Kamien Filozoficzny", "J.K. Rowling", 39.99);
        Order order = new Order(book, 1, LocalDate.of(2021,2,6));

        return new OrderRequest(user, order);
    }

}
