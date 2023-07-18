package org.demo;

import org.demo.rules.ScoreRules;
import org.demo.rules.StandardRules;

import java.util.*;

public class ScoreBoard {
    private Map<Player, List<Play>> map;
    private ScoreRules scoreRules;

    public ScoreBoard(List<Player> players) {
        this.map = new LinkedHashMap<>() {{
            players.forEach(player -> put(player, new ArrayList<>()));
        }};
        scoreRules = new StandardRules();
    }

    public void addPlay(Player player, Play play) {
        map.get(player).add(play);
    }

    public void display() {
        System.out.println("Scoreboard:");
        map.keySet().forEach(this::displayPlayerScores);
    }

    private void displayPlayerScores(Player player) {
        System.out.printf("%s: ", player.getName());
        map.get(player).forEach((Play::display));
        System.out.printf(" -> %s", scoreRules.calculateScore(map.get(player)));
        System.out.println();
    }
}
