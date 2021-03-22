package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;

import java.util.Scanner;

public class SudokuGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DataProcessor dataProcessor = new DataProcessor();
    private static SudokuSolver sudokuSolver;
    private static SudokuBoard sudokuBoard;

    public SudokuGame() {
        sudokuBoard = new SudokuBoard();
        sudokuSolver = new SudokuSolver(sudokuBoard);
    }

    public static void main(String[] args) {

        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame();
        theGame.printMenu();
        System.out.println(sudokuBoard);
        while (!gameFinished) {
            String input = scanner.nextLine();
            if (input.equals("SUDOKU")){
                theGame.solveSudoku();
                System.out.println(sudokuBoard);
                gameFinished = !theGame.resolveSudoku();
            } else {
                UserValuesDto userValuesDto = dataProcessor.processInputValues(input);
                if (userValuesDto != null){
                    sudokuBoard.updateBoard(userValuesDto);
                    System.out.println(sudokuBoard);
                } else {
                    System.out.println("Niepoprawne dane");
                }
            }
        }
    }

    boolean resolveSudoku(){
        System.out.println("Czy chcesz rowzwiązać kolejne sudoku? t/n");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("t")){
                return true;
            } else if (input.equals("n")){
                return false;
            } else {
                System.out.println("Niepoprawna odpowiedź, spróbuj ponownie");
            }
        }
    }

    private void solveSudoku(){
        try {
            sudokuSolver.solve();
        } catch (InvalidSudokuException e){
            System.out.println("Wprowadzone sudoku jest niepoprawne");
        }
    }

    private void printMenu(){
        System.out.println("Wprowadź dane w  następującej kolejności: (kolumna, wiersz, wartość)");
        System.out.println("Wpisz SUDOKU, aby rozwiązać planszę");
    }
}
