package com.kodilla.rps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AIPlayerTestSuite {

    @Mock
    AIPlayer aiPlayerMock = mock(AIPlayer.class);

    @Test
    void testMove(){
        //when & then
        when(aiPlayerMock.drawSymbol()).thenReturn(1);
//        Symbol s = (when(aiPlayerMock.move()).thenCallRealMethod();
        assertEquals(new Rock(), when(aiPlayerMock.move()).thenCallRealMethod());
    }
}
