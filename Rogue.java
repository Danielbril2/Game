package com.company;

public class Rogue extends Player
{
    private int cost;
    private int currEnergy;

    public Rogue (String name, int healCapacity, int attack, int defense, int cost)
    {
        super (name, healCapacity, attack, defense);
        this.cost = cost;
        this.currEnergy = 100;
    }

    public int getCurrEnergy()
    {
        return this.currEnergy;
    }
    public int getCost()
    {
        return this.cost;
    }
}
