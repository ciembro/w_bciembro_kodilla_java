package com.kodilla.exception.test;
import com.kodilla.exception.test.SecondChallenge;

public class ExceptionHandling {

    public void handleException(double x, double y){
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(x,y);
        } catch (Exception e){
            System.out.println("Error!!! ");
        }
    }
}
