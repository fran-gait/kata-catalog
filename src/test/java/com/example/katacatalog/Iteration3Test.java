package com.example.katacatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Iteration3Test {

    @Test
    void meleeAttackWithOutInRange() {
        MeleeCharacter attacker = new MeleeCharacter(2);
        MeleeCharacter target = new MeleeCharacter(10);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 5);

        assertEquals(1000, target.getHealth());
    }
}
