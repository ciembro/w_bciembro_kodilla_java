package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testTaskAdd(){
        //given
        board.getToDoList().addTask("to do task");
        board.getInProgressList().addTask("in progress task");
        board.getDoneList().addTask("done task");
        //when
        String toDoTask = board.getToDoList().getTasks().get(0);
        String inProgressTask = board.getInProgressList().getTasks().get(0);
        String doneTask = board.getDoneList().getTasks().get(0);
        //then
        assertEquals("to do task", toDoTask);
        assertEquals(1, board.getToDoList().getTasks().size());

        assertEquals("in progress task", inProgressTask);
        assertEquals(1, board.getInProgressList().getTasks().size());

        assertEquals("done task", doneTask);
        assertEquals(1, board.getDoneList().getTasks().size());
    }
}
