package com.company;

public class Rogue extends Player{

    private int cost;
    private int currEnergy;

    public Rogue (char tile, int x, int y, String name, int attack, int defense, Health health,
                  int experience, int level, int cost)
    {
        super (tile, x, y, name, attack, defense, health, experience, level);
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
