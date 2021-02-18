package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static final Logger logger = Logger.INSTANCE;

    @Test
    void testGetLastLog(){
        //given
        String newLog = "001log";
        //when
        logger.log(newLog);
        String resultLog = logger.getLastLog();
        //then
        assertEquals("001log", resultLog);
    }
}
