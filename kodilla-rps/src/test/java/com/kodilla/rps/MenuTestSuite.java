package com.kodilla.rps;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTestSuite {

    @Test
    public void testTakeAnswerWithYes(){
        //given
        Scanner scanner = new Scanner(System.in);
        //when&then
        String command = "y";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);
        assertTrue(RpsRunner.readAnswer());

        command = "Y";
        in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);
        assertTrue(RpsRunner.readAnswer());
    }

    @Test
    public void testTakeAnswerWithNo(){
        //given
        Scanner scanner = new Scanner(System.in);
        //when & then
        String command = "n";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);
        assertFalse(RpsRunner.readAnswer());

        command = "N";
        in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);
    }

    @Test
    public void testTakeAnswerWithOther(){
        //given
        Scanner scanner = new Scanner(System.in);
        //when
        String command = "z";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);
        //then
        assertFalse(RpsRunner.readAnswer());
    }
}
