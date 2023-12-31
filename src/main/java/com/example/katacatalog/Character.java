package com.example.katacatalog;

import java.util.UUID;

public class Character {

    private static final int MAX_HEALTH = 1000;
    private UUID uuid = UUID.randomUUID();
    private int health;
    private int level;
    private boolean life;

    public Character() {
        this.health = MAX_HEALTH;
        this.level = 1;
        this.life = true;
    }

    public void attack(int damage) {
        if (damage >= this.health) {
            this.health = 0;
            this.life = false;
        } else {
            this.health -= damage;
        }
    }

    public void heal(int healPoint) {
        if (!this.isLife()) {
            throw new RuntimeException("Cannot to healPoint Character");
        }

        int newHealth = this.health + healPoint;
        if (newHealth > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else {
            this.health += healPoint;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isLife() {
        return life;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return uuid != null ? uuid.equals(character.uuid) : character.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Character{" +
               "health=" + health +
               ", level=" + level +
               ", life=" + life +
               '}';
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
