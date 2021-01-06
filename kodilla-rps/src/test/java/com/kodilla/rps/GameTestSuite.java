package com.kodilla.rps;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTestSuite {

    @Mock
    AIPlayer aiPlayerMock = mock(AIPlayer.class);

    @Test
    void testPlayRoundHumanMove(){
        //given
        Game game = new Game(new Player("W"),1);
        //when
        game.playRound(1);
        game.playRound(2);
        game.playRound(3);
        //then
        assertEquals(new Rock(),game.getHumanPlayer().getMoves().get(0));
        assertEquals(new Paper(),game.getHumanPlayer().getMoves().get(1));
        assertEquals(new Scissors(),game.getHumanPlayer().getMoves().get(2));
    }

    @Test
    void testPlayRoundHumanWins(){
        //given
        Game game = new Game(new Player("W"), aiPlayerMock, 1);
        //when
        when(aiPlayerMock.move()).thenReturn(new Rock());
        game.playRound(2);
        //then
        assertEquals(1, game.getHumanPlayer().getNumOfWonRounds());
        assertEquals(1, game.getHumanPlayer().getRoundScore());
        assertEquals(1, game.getHumanPlayer().getTotalScore());
    }

    @Test
    void testPlayRoundHumanLoose(){
        //given
        Game game = new Game(new Player("W"), aiPlayerMock, 1);
        //when
        when(aiPlayerMock.move()).thenReturn(new Rock());
        game.playRound(3);
        //then
        assertEquals(0, game.getHumanPlayer().getNumOfWonRounds());
        assertEquals(-1, game.getHumanPlayer().getRoundScore());
        assertEquals(0, game.getHumanPlayer().getTotalScore());
    }

    @Test
    void testPlayRoundDraw(){
        //given
        Game game = new Game(new Player("W"), aiPlayerMock, 1);
        //when
        when(aiPlayerMock.move()).thenReturn(new Rock());
        game.playRound(1);
        //then
        assertEquals(0, game.getHumanPlayer().getNumOfWonRounds());
        assertEquals(0, game.getHumanPlayer().getRoundScore());
        assertEquals(0, game.getHumanPlayer().getTotalScore());
    }

    @Test
    void testGameOverHumanWins (){
        //given
        Game game = new Game(new Player("W"), aiPlayerMock, 1);
        //when
        when(aiPlayerMock.move()).thenReturn(new Rock());
        game.playRound(2);
        //then
        assertTrue(game.gameOver());
    }

    @Test
    void testGameOverHumanLoose () {
        //given
        Game game = new Game(new Player("W"), aiPlayerMock, 1);
        //when
        when(aiPlayerMock.move()).thenReturn(new Rock());
        game.playRound(1);
        //then
        assertFalse(game.gameOver());
    }




}
