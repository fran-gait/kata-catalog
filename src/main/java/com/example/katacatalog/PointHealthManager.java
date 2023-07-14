package com.example.katacatalog;

public class PointHealthManager {


    public void attack(Character attacker, Character target, int pointDamage) {
        if (attacker.equals(target)) {
            throw new RuntimeException("Cannot attack itself");
        }
        if (attacker.getRange() >= (Math.abs(attacker.getPosition() - target.getPosition()))) {
            throw new RuntimeException("Cannot stay into range");
        }
        if ((target.getLevel() - attacker.getLevel() > 5)) {
            target.attack(pointDamage / 2);
        } else {
            target.attack((float) (pointDamage * 1.5));
        }
    }

    public void heal(Character character, Character character2, int pointHealth) {
        if (!character.equals(character2)) {
            throw new RuntimeException("Cannot heal other");
        }
        character.heal(pointHealth);
    }
}
