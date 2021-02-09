package com.kodilla.good.patterns.challenges.food2door;

public class User {

    private final String firstName;
    private final String secondName;
    private double accountBalance;

    public User(String firstName, String secondName, double accountBalance) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void updateBalance(double orderValue){
        accountBalance -= orderValue;

    }
}
