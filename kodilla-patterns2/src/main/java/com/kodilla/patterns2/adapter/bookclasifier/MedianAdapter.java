package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookA> bookSet) {
        Map<BookSignature, BookB> bookMap = bookSet.stream()
                .collect(Collectors.toMap(b -> new BookSignature(b.getSignature()),
                        b -> new BookB(b.getAuthor(), b.getTitle(), b.getPublicationYear())));

        return medianPublicationYear(bookMap);
    }
}
