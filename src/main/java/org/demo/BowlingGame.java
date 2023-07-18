package org.demo;

import org.demo.rules.GameRules;
import org.demo.rules.ScoreRules;
import org.demo.rules.StandardRules;

import java.util.*;

public class BowlingGame {
    private Deque<Player> players;
    private ScoreBoard scoreBoard;
    private int totalRounds;
    private GameRules gameRules;

    public BowlingGame(int numberOfPlayers, int totalRounds) {
        this.players = new LinkedList<>();
        for (int index = 1; index <= numberOfPlayers; index++) {
            Player player = new Player(index, "Player" + index);
            this.players.add(player);
        }
        this.totalRounds = totalRounds;
        this.gameRules = new StandardRules();
        this.scoreBoard = new ScoreBoard(new ArrayList<>(players));
    }

    public void startGame() {
        int roundNumber = 1;
        Player firstPlayer = players.getFirst();
        while(roundNumber <= totalRounds) {
            Player currPlayer = players.removeFirst();
            scoreBoard.addPlay(currPlayer, play(currPlayer, roundNumber));
            scoreBoard.display();
            players.addLast(currPlayer);
            if(firstPlayer.equals(players.getFirst())) {
                roundNumber++;
            }
        }
    }

    private Play play(Player currPlayer, Integer roundNumber) {
        Scanner scanner = new Scanner(System.in);
        int chanceNumber = 1;
        Play play = new Play(roundNumber == totalRounds);
        while(gameRules.shouldGetChance(play)) {
            System.out.println("Enter Score for " + currPlayer.getName() + " Chance" + chanceNumber + ": ");
            int pinsDropped = scanner.nextInt();
            play.addChance(pinsDropped);
        }
        printLine();
        printPlay(currPlayer, play);
        printLine();
        return play;
    }

    private void printPlay(Player currPlayer, Play play) {
        System.out.println(currPlayer.getName() + "Score ");
        for(int index = 1; index <= play.getChances().size(); index++) {
            System.out.println("Chance" + index + " - " + play.getChances().get(index-1) + "pins ");
        }
    }

    private void printLine() {
        for(int index = 0; index < 30; index++){
            System.out.print('*');
        }
        System.out.println();
    }
}
