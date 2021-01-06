package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String command;
        boolean end = false;

        while (!end){
            System.out.println("Hello! Please tell me your name");
            String name = scanner.nextLine();
            System.out.println("After how many wins u want to finish the game?");
            int numOfWonRounds = scanner.nextInt();
            scanner.nextLine();
            Player humanPlayer = new Player(name);
            AIPlayer aiPlayer = new AIPlayer();
            Game game = new Game(humanPlayer,aiPlayer,numOfWonRounds);
            boolean finishGame = false;
            printMenu(name, numOfWonRounds);

            while (!game.gameOver() && !finishGame){
                System.out.println("Enter command");
                command = scanner.nextLine();
                finishGame = false;
                switch (command){
                    case "1":
                        game.playRound(1);
                        break;

                    case "2":
                        game.playRound(2);
                        break;

                    case "3":
                        game.playRound(3);
                        break;

                    case "x":
                        System.out.println("Are u sure want quit the game? \ny/n");
                        if (readAnswer()){
                            end = true;
                            finishGame = true;
                        }
                        break;

                    case "n":
                        System.out.println("Are sure u want to start a new game? \ny/n");
                        if (readAnswer()){
                            finishGame = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid command. Try again");
                }
                if (game.gameOver()){
                    game.printFinalScores();
                    System.out.println("Choose x to finish the game or n to start a new one.");
                    command = scanner.nextLine();
                    if (command.equals("x")){
                        System.out.println("Are u sure want quit the game? \ny/n");
                        if (readAnswer()){
                            end = true;
                        }
                    } else {
                        while (!command.equals("n")){
                            System.out.println("Invalid command");
                            command = scanner.nextLine();
                        }
                    }
                }
            }
        }
        System.out.println("Thanks for your time!");
    }

    private static void printMenu(String name, int rounds){
        System.out.println("Hi " + name + "! You need to win " + rounds + " times");
        System.out.println("--------||--------");
        System.out.println("Choose what u want to do:");
        System.out.println("1 - rock");
        System.out.println("2 - paper");
        System.out.println("3 - scissors");
        System.out.println("x - finish game");
        System.out.println("n - start new game");
        System.out.println("--------||--------");
    }

    static boolean readAnswer(){
        String command = scanner.nextLine();
        if (command.equals("y") || command.equals("Y")){
            return true;
        }
        if (command.equals("n") || command.equals("N")) {
            return false;
        }
        System.out.println("You need to put valid command");
        return false;
    }

}

