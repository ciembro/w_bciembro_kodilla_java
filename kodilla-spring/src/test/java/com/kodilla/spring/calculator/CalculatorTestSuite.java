package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testCalculations(){
        //given
        //when & then
        double result = calculator.add(5,6);
        assertEquals(11, result);

        result = calculator.sub(5,6);
        assertEquals(-1, result);

        result = calculator.div(15,10);
        assertEquals(1.5, result);

        result = calculator.div(15,0);
        assertEquals(0, result);

        result = calculator.mul(5,6);
        assertEquals(30, result);
    }
}
