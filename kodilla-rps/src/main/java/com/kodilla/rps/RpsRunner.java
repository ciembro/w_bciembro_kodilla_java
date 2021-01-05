package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String command;
        System.out.println("Hello! Please tell me your name");
        String name = scanner.nextLine();
        System.out.println("How many wins?");
        int numOfWonRounds = scanner.nextInt();
        scanner.nextLine();
        printMenu(name, numOfWonRounds);

        while (numOfWonRounds > 0){
            System.out.println("Enter command");
            command = scanner.nextLine();

            switch (command){
                case "1":
                    numOfWonRounds--;
                    break;

                case "2":
                    numOfWonRounds--;
                    break;

                case "3":
                    numOfWonRounds--;
                    break;

                case "x":
                    System.out.println("Are u sure want quit the game? \ny/n");
                    if (readAnswer()){
                        numOfWonRounds = 0;
                    }
                    break;

                case "n":
                    System.out.println("Are sure u want start the new game? \ny/n");
                    if (readAnswer()){
                        numOfWonRounds = 0;
                    }
                    break;
                default:
                    System.out.println("Invalid command. Try again");
            }
        }

        System.out.println("Thanks for your time!");

    }


    private static void printMenu(String name, int rounds){
        System.out.println("Hi " + name + "! You need to win " + rounds + " times");
        System.out.println("Choose what u want to do:");
        System.out.println("1 - rock");
        System.out.println("2 - paper");
        System.out.println("3 - scissors");
        System.out.println("x - finish game");
        System.out.println("n - start new game");
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

