package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int calcResult = calculator.add(5,2);

        if (calcResult == 7){
            System.out.println("test dodawania OK");
        } else {
            System.out.println("Error w dodawaniu!");
        }

        calcResult = calculator.subtract(5,2);
        if (calcResult == 3){
            System.out.println("test odejmowania OK");
        } else {
            System.out.println("Error w odejmowaniu!");
        }
    }
}
