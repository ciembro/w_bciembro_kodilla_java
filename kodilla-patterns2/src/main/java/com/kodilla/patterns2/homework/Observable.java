package com.kodilla.patterns2.homework;

public interface Observable {

    void changeObserver(Observer observer);
    void notifyObserver();
}
