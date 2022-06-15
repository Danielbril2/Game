package com.company;

public class Warrior extends  Player
{
    private int cooldown;
    private int remainingCooldown;

    public Warrior (String name, int healCapacity, int attack, int defense, int cooldown)
    {
        super (name, healCapacity, attack, defense);
        this.cooldown = cooldown;
        this.remainingCooldown = 0;
    }

    public int getRemainingCooldown() {return this.remainingCooldown;}
    public int getCooldown() {return this.cooldown;}

}
