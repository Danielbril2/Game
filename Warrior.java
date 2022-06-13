package com.company;

public class Warrior extends  Player
{
    private int cooldown;
    private int remainingCooldown;

    public Warrior (Position pos, String name, int attack, int defense, Health health, int cooldown)
    {
        super (pos, name, attack, defense, health);
        this.cooldown = cooldown;
        this.remainingCooldown = 0;
    }

    public int getRemainingCooldown() {return this.remainingCooldown;}
    public int getCooldown() {return this.cooldown;}

}
