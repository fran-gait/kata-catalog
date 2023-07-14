package com.example.katacatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Iteration2Test {

    @Test
    void characterCannotAttackItself() {
        Character player1 = new Character();

        PointHealthManager pointHealthManager = new PointHealthManager();

        assertThrows(RuntimeException.class, () -> pointHealthManager.attack(player1, player1, 0));
    }

    @Test
    void characterCanAttackOther() {
        Character attacker = new Character();
        Character target = new Character();

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 100);

        assertEquals(1000, attacker.getHealth());
        assertEquals(800, target.getHealth());
    }

    @Test
    void characterCanHealItself() {
        Character character = new Character();
        character.attack(100);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.heal(character, character, 10);

        assertEquals(910, character.getHealth());
    }

    @Test
    void characterCannotHealOther() {
        Character healer = new Character();
        Character target = new Character();
        target.attack(100);

        PointHealthManager pointHealthManager = new PointHealthManager();
        assertThrows(RuntimeException.class, () -> pointHealthManager.heal(healer, target, 10));
    }

    @Test
    void attackerWhenTargetLevelMoreAbove() {
        Character attacker = new Character();
        Character target = new Character();
        target.setLevel(7);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 2);

        assertEquals(999, target.getHealth());
    }

    @Test
    void attackerWhenTargetLevelBelowAbove() {
        Character attacker = new Character();
        Character target = new Character();
        target.setLevel(7);

        PointHealthManager pointHealthManager = new PointHealthManager();
        pointHealthManager.attack(attacker, target, 2);

        assertEquals(999, target.getHealth());
    }
}
