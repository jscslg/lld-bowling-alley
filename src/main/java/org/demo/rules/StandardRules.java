package org.demo.rules;

import org.demo.Play;

import java.util.List;

public class StandardRules implements GameRules, ScoreRules {
    @Override
    public boolean shouldGetChance(Play play) {
        List<Integer> chances = play.getChances();
        if(chances.isEmpty()) {
            return true;
        }
        if(play.isLastRound()) {
            return shouldGetChanceLastRound(chances);
        }
        if(isStrike(chances)) {
            return false;
        }
        return chances.size() == 1;
    }

    private static boolean isStrike(List<Integer> chances) {
        return chances.get(0) == 10;
    }

    private static boolean isSpare(List<Integer> chances) {
        return chances.size() == 2 && (chances.get(0) == 10 || chances.stream().reduce(0, Integer::sum) == 10);
    }

    private boolean shouldGetChanceLastRound(List<Integer> chances) {
        if(chances.size() == 1) {
            return true;
        }
        if(chances.size() == 3) {
            return false;
        }
        return isStrike(chances) || isSpare(chances);
    }

    @Override
    public int calculateScore(List<Play> plays) {
        int score = 0;
        for(Play play : plays) {
            if(isSpare(play.getChances()) && !play.isLastRound()) {
                score += 15;
            } else if(isStrike(play.getChances()) && !play.isLastRound()) {
                score += 20;
            } else {
                score += play.getChances().stream().reduce(0, Integer::sum);
            }
        }
        return score;
    }
}
