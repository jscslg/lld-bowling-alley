package org.demo;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private List<Integer> chances;
    private boolean lastRound;

    public Play(boolean lastRound) {
        this.lastRound = lastRound;
        chances = new ArrayList<>();
    }

    public void addChance(int pinsDropped) {
        chances.add(pinsDropped);
    }

    public List<Integer> getChances() {
        return chances;
    }

    public boolean isLastRound() {
        return lastRound;
    }

    public void display() {
        System.out.print("{");
        chances.forEach(chance -> System.out.printf("%s,", chance));
        System.out.print("}");
    }
}
