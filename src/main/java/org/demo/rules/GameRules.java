package org.demo.rules;

import org.demo.Play;

public interface GameRules {
    boolean shouldGetChance(Play play);
}
