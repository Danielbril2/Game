package com.company;

public class Rogue extends Player
{
    private int cost;
    private int currEnergy;

    public Rogue (Position pos, String name, int attack, int defense, Health health, int cost)
    {
        super (pos, name, attack, defense, health);
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
