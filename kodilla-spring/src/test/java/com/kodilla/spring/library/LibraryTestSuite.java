package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryTestSuite {

//    ---zamiast czesci given w metodach testow---
    @Autowired
    private Library library;

    @Test
    void testLoadFromDb() {
        //Given
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        library.loadFromDb();

        //Then
        //do nothing
    }

    @Test
    void testSaveToDb() {
        //Given
        //When
        library.saveToDb();
        //Then
        //do nothing
    }
}
