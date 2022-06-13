package com.company;

public class Monster extends Enemy{

    private int visionRange;

    public Monster(char tile, String name, int attack, int defense,
                   int health, int experience, int visionRange)
    {
        super (tile, name, health, attack, defense, experience);
        this.visionRange = visionRange;
    }

    public int getVisionRange()
    {
        return this.visionRange;
    }
}
