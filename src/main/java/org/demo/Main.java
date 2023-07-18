package org.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of players: ");
        int noPlayers = scanner.nextInt();
        //scanner.close();
        BowlingGame game = new BowlingGame(noPlayers, 3);
        game.startGame();
    }
}