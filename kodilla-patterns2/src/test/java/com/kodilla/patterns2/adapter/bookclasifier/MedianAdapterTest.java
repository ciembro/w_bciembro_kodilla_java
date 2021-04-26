package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTest {

    @Test
    void publicationYearMedian() {
        //given
        MedianAdapter medianAdapter = new MedianAdapter();
        Book book1 = new Book("J.K.Rowling", "HP i Kamien Filozoficzny", 1997, "ab");
        Book book2 = new Book("J.K.Rowling", "HP i Komnata Tajemnic", 2000, "bc");
        Book book3 = new Book("J.K.Rowling", "HP i Wiezien Azkabanu", 2002, "cd");
        Book book4 = new Book("J.K.Rowling", "HP i Czara Ognia", 2004, "de");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        //when & then
        int yearMedian = medianAdapter.publicationYearMedian(bookSet);
        assertEquals(2000, yearMedian);

        bookSet.add(book4);
        yearMedian = medianAdapter.publicationYearMedian(bookSet);
        assertEquals(2001, yearMedian);

    }
}