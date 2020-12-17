package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> bookList = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, bookList.size());

    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).
                thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).
                thenReturn(resultListOf40Books);
        //When
        List<Book> listOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> listOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> listOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0,listOfBooks0.size());
        assertEquals(15,listOfBooks15.size());
        assertEquals(0,listOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
//        List<Book> resultListOf10Books = generateListOfNBooks(10);
        //niepotrzebne, bo to sie nie wywola
//        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
        //When
        List<Book> listOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, listOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void listBooksInHandsOfNoBooks(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Weronika","C", "12345");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(new ArrayList<>());
        //When
        List<Book> list = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(0, list.size());
    }

    @Test
    void listBooksInHandsOf1Book(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Weronika","C", "12345");
        List<Book> userBookList = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(userBookList);
        //When
        List<Book> list = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(1, list.size());
    }

    @Test
    void listBooksInHandsOf5Books(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Weronika","C", "12345");
        List<Book> userBookList = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(userBookList);
        //When
        List<Book> list = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(5, list.size());
    }


    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
