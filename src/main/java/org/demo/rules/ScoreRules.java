package org.demo.rules;

import org.demo.Play;

import java.util.List;

public interface ScoreRules {
    int calculateScore(List<Play> plays);
}
