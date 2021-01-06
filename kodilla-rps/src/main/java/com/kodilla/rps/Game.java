package com.kodilla.rps;

import java.util.HashMap;

public class Game {

    private final Player humanPlayer;
    private final AIPlayer aiPlayer;
    private final HashMap<Integer, Symbol> possibleMoves = new HashMap<>();
    private final int roundsToWin;
    private final TableOfWins tableOfWins;

    public Game(Player humanPlayer, int roundsToWin){
        this(humanPlayer, new AIPlayer(), roundsToWin);
    }

    //constructor used for tests
    public Game(Player humanPlayer, AIPlayer aiPlayer, int roundsToWin){
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
        this.tableOfWins = new TableOfWins();
        this.roundsToWin = roundsToWin;
        possibleMoves.put(1, new Rock());
        possibleMoves.put(2, new Paper());
        possibleMoves.put(3, new Scissors());
    }

    public void playRound(int keyboardMove){
        Symbol humanMove = humanPlayer.move(possibleMoves.get(keyboardMove));
        Symbol aiMove = aiPlayer.move();
        updateScores(humanMove, aiMove);
        printScores(humanMove, aiMove);
    }

    private void updateScores(Symbol humanMove, Symbol aiMove){
        Symbol humanWinsWith = tableOfWins.getWins().get(humanMove);
        Symbol aiWinsWith = tableOfWins.getWins().get(aiMove);
        if (humanWinsWith.equals(aiMove)){
            humanPlayer.setRoundScore(1);
            humanPlayer.updateTotalScore();
            humanPlayer.updateWonRounds();
            aiPlayer.setRoundScore(-1);
        } else if (aiWinsWith.equals(humanMove)){
            humanPlayer.setRoundScore(-1);
            aiPlayer.setRoundScore(1);
            aiPlayer.updateTotalScore();
            aiPlayer.updateWonRounds();
        } else {
            humanPlayer.setRoundScore(0);
            aiPlayer.setRoundScore(0);
        }
    }

    private void printScores(Symbol humanMove, Symbol aiMove){
        System.out.println(humanPlayer.getName() + "'s " + humanMove.getName() +
                " vs " + aiMove.getName());
        if (humanPlayer.getRoundScore() == 1){
            System.out.println(humanPlayer.getName() + " wins this round.");
        } else if (aiPlayer.getRoundScore() == 1){
            System.out.println(aiPlayer.getName() + " wins this round.");
        } else if (humanPlayer.getRoundScore() == 0){
            System.out.println("It's a draw.");
        }
        System.out.println("Current rank: " + humanPlayer.getNumOfWonRounds() + ":" + aiPlayer.getNumOfWonRounds());
        System.out.println("-----------------");
    }

    public void printFinalScores(){
        System.out.println("!!!GAME OVER!!!");
        System.out.println(humanPlayer.getName() + " vs " + aiPlayer.getName());
        int humanScore = humanPlayer.getTotalScore();
        int aiScore = aiPlayer.getTotalScore();
        System.out.println(humanScore + ":" + aiScore);
        if (humanScore > aiScore){
            System.out.println(humanPlayer.getName() + " wins the game.");
        } else if (humanScore < aiScore){
            System.out.println(aiPlayer.getName() + " wins the game.");
        } else {
            System.out.println("It's a draw.");
        }
    }

    public boolean gameOver(){
        return humanPlayer.getTotalScore() == roundsToWin || aiPlayer.getTotalScore() == roundsToWin;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (!humanPlayer.equals(game.humanPlayer)) return false;
        if (!aiPlayer.equals(game.aiPlayer)) return false;
        return possibleMoves.equals(game.possibleMoves);
    }

    @Override
    public int hashCode() {
        int result = humanPlayer.hashCode();
        result = 31 * result + aiPlayer.hashCode();
        result = 31 * result + possibleMoves.hashCode();
        return result;
    }
}
