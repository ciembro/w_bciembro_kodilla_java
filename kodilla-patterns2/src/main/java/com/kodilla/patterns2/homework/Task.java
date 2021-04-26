package com.kodilla.patterns2.homework;

public class Task {

    private final String task;
    private boolean accepted;

    public Task(String task) {
        this.task = task;
        this.accepted = false;
    }

    public void acceptTask(){
        this.accepted = true;
    }
}
