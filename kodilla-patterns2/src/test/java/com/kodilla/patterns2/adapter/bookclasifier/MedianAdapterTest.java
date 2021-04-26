package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTest {

    @Test
    void publicationYearMedian() {
        //given
        MedianAdapter medianAdapter = new MedianAdapter();
        BookA book1 = new BookA("J.K.Rowling", "HP i Kamien Filozoficzny", 1997, "ab");
        BookA book2 = new BookA("J.K.Rowling", "HP i Komnata Tajemnic", 2000, "bc");
        BookA book3 = new BookA("J.K.Rowling", "HP i Wiezien Azkabanu", 2002, "cd");
        BookA book4 = new BookA("J.K.Rowling", "HP i Czara Ognia", 2004, "de");
        Set<BookA> bookASet = new HashSet<>();
        bookASet.add(book1);
        bookASet.add(book2);
        bookASet.add(book3);
        //when & then
        int yearMedian = medianAdapter.publicationYearMedian(bookASet);
        assertEquals(2000, yearMedian);

        bookASet.add(book4);
        yearMedian = medianAdapter.publicationYearMedian(bookASet);
        assertEquals(2001, yearMedian);

    }
}