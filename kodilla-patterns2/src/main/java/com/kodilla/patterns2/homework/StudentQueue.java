package com.kodilla.patterns2.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class StudentQueue implements Observable {

    private final String studentName;
    private Deque<Task> tasks;
    private Observer observer;

    public StudentQueue(String studentName, Observer observer) {
        this.studentName = studentName;
        this.observer = observer;
        this.tasks = new ArrayDeque<>();
    }

    public void addTask(final Task task){
        tasks.offerLast(task);
        notifyObserver();
    }

    public Deque<Task> getQueue(){
        return tasks;
    }

    @Override
    public void changeObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }

    public String getStudentName() {
        return studentName;
    }

}
