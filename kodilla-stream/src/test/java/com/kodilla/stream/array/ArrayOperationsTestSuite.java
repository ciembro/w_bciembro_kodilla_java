package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //When
        double expectedAvg = 10.5;
        double resultAvg = ArrayOperations.getAverage(array);

        //Then
        assertEquals(expectedAvg, resultAvg);
    }
}
