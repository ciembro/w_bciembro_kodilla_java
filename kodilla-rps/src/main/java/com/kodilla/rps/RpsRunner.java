package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        int numOfWinned = scanner.nextInt();
        System.out.println(numOfWinned);
    }


    private void printMenu(String name, int rounds){
        System.out.println("Hello " + name + "! You need to win " + rounds);



    }



}
