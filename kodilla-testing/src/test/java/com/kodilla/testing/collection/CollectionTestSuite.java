package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Starting test");
    }

    @AfterEach
    public void after(){
        System.out.println("Test ended");

    }

    @DisplayName("When passing empty list, then exterminate() should return empty list")

    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = exterminator.exterminate(new ArrayList<>());
        //Then
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @DisplayName("When passing integer list, " +
             "then exterminate() should return list with only even numbers")

    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> expectedList = Arrays.asList(2,4);
        //When
        List<Integer> functionResult = exterminator.exterminate(list);
        //Then
        Assertions.assertEquals(expectedList, functionResult);
    }
}
