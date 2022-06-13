package com.company;

public class Warrior extends  Player{
    private int cooldown;
    private int remainingCooldown;

    public Warrior (char tile, String name, int attack, int defense, int health,
                    int experience, int level, int cooldown)
    {
        super (tile, name, health, attack, defense, experience, level);
        this.cooldown = cooldown;
        this.remainingCooldown = 0;
    }

    public int getRemainingCooldown()
    {
        return this.remainingCooldown;
    }
    public int getCooldown()
    {
        return this.cooldown;
    }

}
