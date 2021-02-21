package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //given
        Library library = new Library("First Library");
        library.setBooks(createBookSet());

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }

        //when
        Book book = new Book("title 1", "author 1", LocalDate.of(2012,3,22));
        library.getBooks().remove(book);

        //then
        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }

    private Set<Book> createBookSet(){
        Set<Book> books = new HashSet<>();
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> books.add(new Book("title " + n, "author " + n,
                        LocalDate.now().minusYears(10-n).plusMonths(n).plusDays(n))));

        return books;
    }
}
