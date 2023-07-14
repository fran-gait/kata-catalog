package com.example.katacatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Iteration2Test {

    @Test
    void characterCannotAttackItself() {
        MeleeCharacter player1 = new MeleeCharacter(2);

        PointHealthManager pointHealthManager = new PointHealthManager();

        assertThrows(RuntimeException.class, () -> pointHealthManager.attack(player1, player1, 0));
    }

    @Test
    void characterCanAttackOther() {
        MeleeCharacter attacker = new MeleeCharacter(2);
        MeleeCharacter target = new MeleeCharacter(2);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 100);

        assertEquals(1000, attacker.getHealth());
        assertEquals(850, target.getHealth());
    }

    @Test
    void characterCanHealItself() {
        MeleeCharacter character = new MeleeCharacter(2);
        character.attack(100);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.heal(character, character, 10);

        assertEquals(910, character.getHealth());
    }

    @Test
    void characterCannotHealOther() {
        MeleeCharacter healer = new MeleeCharacter(2);
        MeleeCharacter target = new MeleeCharacter(2);
        target.attack(100);

        PointHealthManager pointHealthManager = new PointHealthManager();
        assertThrows(RuntimeException.class, () -> pointHealthManager.heal(healer, target, 10));
    }

    @Test
    void attackerWhenTargetLevelMoreAbove() {
        MeleeCharacter attacker = new MeleeCharacter(2);
        MeleeCharacter target = new MeleeCharacter(2);
        target.setLevel(7);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 2);

        assertEquals(999, target.getHealth());
    }

    @Test
    void attackerWhenTargetLevelBelowAbove() {
        MeleeCharacter attacker = new MeleeCharacter(2);
        MeleeCharacter target = new MeleeCharacter(2);
        attacker.setLevel(7);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 2);

        assertEquals(997, target.getHealth());
    }
}
