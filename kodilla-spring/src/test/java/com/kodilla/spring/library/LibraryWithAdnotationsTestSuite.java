package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryWithAdnotationsTestSuite {

//    ---zamiast czesci given w metodach testow---
    @Autowired
    private LibraryWithAdnotations libraryWithAdnotations;

    @Test
    void testLoadFromDb() {
        //Given
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        libraryWithAdnotations.loadFromDb();

        //Then
        //do nothing
    }

    @Test
    void testSaveToDb() {
        //Given
        //When
        libraryWithAdnotations.saveToDb();
        //Then
        //do nothing
    }
}
