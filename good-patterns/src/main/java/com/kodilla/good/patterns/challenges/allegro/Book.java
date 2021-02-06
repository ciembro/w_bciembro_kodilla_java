package com.kodilla.good.patterns.challenges.allegro;

public class Book extends Product{

    private static final String PRODUCT_NAME = "Book";
    private final String title;
    private final String author;

    public Book(String title, String author, double price) {
        super(PRODUCT_NAME, price);
        this.title = title;
        this.author = author;
    }


    @Override
    public String toString() {
        return author + ", " + title;
    }
}
