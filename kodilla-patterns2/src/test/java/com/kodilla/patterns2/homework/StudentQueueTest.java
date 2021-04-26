package com.kodilla.patterns2.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentQueueTest {

    @Test
    void testUpdate(){
        //given
        Mentor mentorOne = new Mentor();
        Mentor mentorTwo = new Mentor();
        Task task1 = new Task("task1");
        Task task2 = new Task("task2");
        StudentQueue weronikaQueue = new StudentQueue("Weronika", mentorOne);
        StudentQueue janQueue = new StudentQueue("Jan", mentorOne);
        StudentQueue annaQueue = new StudentQueue("Anna", mentorTwo);

        //when
        weronikaQueue.addTask(task1);
        weronikaQueue.addTask(task2);
        janQueue.addTask(task1);
        annaQueue.addTask(task1);
        annaQueue.addTask(task2);

        //then
        assertEquals(3, mentorOne.getTotalNumOfTasks());
        assertEquals(2, mentorTwo.getTotalNumOfTasks());

    }

}