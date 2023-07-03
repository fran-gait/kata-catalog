package com.example.katacatalog;

public class Character {

    private static final int MAX_HEALTH = 1000;
    private int health;
    private int level;
    private boolean life;

    public Character() {
        this.health = MAX_HEALTH;
        this.level = 1;
        this.life = true;
    }

    public void toDamage(int damage) {
        if (damage >= this.health) {
            this.health = 0;
            this.life = false;
        } else {
            this.health -= damage;
        }
    }

    public void toHeal(int heal) {
        if (!this.isLife()) {
            throw new RuntimeException("Cannot to heal Character");
        }

        int newHealth = this.health + heal;
        if (newHealth > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else {
            this.health += heal;
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
    public String toString() {
        return "Character{" +
               "health=" + health +
               ", level=" + level +
               ", life=" + life +
               '}';
    }
}
