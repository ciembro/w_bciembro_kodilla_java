package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, Book> bookMap = bookSet.stream()
                .collect(Collectors.toMap(b -> new BookSignature(b.getSignature()),
                        b -> new Book(b.getAuthor(), b.getTitle(), b.getPublicationYear())));

        return medianPublicationYear(bookMap);
    }
}
