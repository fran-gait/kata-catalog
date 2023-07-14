package com.example.katacatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Iteration1Test {

    @Test
    void createNewCharacter() {
        MeleeCharacter character = new MeleeCharacter(2);

        assertEquals(1000, character.getHealth());
        assertEquals(1, character.getLevel());
        assertTrue(character.isLife());
    }

    @Test
    void toDamageWhenHurtNotExceedsCurrentHealth() {
        MeleeCharacter character = new MeleeCharacter(2);

        character.attack(50);
        assertEquals(950, character.getHealth());
        assertTrue(character.isLife());
    }

    @Test
    void toDamageWhenHurtEqualsCurrentHealth() {
        MeleeCharacter character = new MeleeCharacter(2);

        character.attack(1000);
        assertEquals(0, character.getHealth());
        assertFalse(character.isLife());
    }

    @Test
    void toDamageWhenHurtExceedsCurrentHealth() {
        MeleeCharacter character = new MeleeCharacter(2);

        character.attack(1001);
        assertEquals(0, character.getHealth());
        assertFalse(character.isLife());
    }

    @Test
    void toHealWhenCharacterIsDie() {
        MeleeCharacter character = new MeleeCharacter(2);
        character.attack(1000);

        assertThrows(RuntimeException.class, () -> character.heal(10));
    }

    @Test
    void toHealWhenCharacterHealthIsMore1000() {
        MeleeCharacter character = new MeleeCharacter(2);
        character.heal(10);

        assertEquals(1000, character.getHealth());
    }

    @Test
    void toHealWhenCharacterHealthIsLess1000() {
        MeleeCharacter character = new MeleeCharacter(2);
        character.attack(500);
        character.heal(50);

        assertEquals(550, character.getHealth());
    }
}