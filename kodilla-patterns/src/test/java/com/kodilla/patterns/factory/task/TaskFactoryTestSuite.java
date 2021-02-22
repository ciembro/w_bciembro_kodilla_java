package com.kodilla.patterns.factory.task;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory = new TaskFactory();

    @Test
    void testShoppingTask(){
        //given
        //when
        Task task = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        task.executeTask();

        //then
        assertEquals("buy newspaper",task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTask(){
        //given
        //when
        Task task = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        task.executeTask();

        //then
        assertEquals("paint fence",task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTask(){
        //given
        //when
        Task task = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        task.executeTask();

        //then
        assertEquals("drive car",task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }
}
