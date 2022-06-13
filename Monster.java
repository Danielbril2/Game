package com.company;

public class Monster extends Enemy{

    private int visionRange;

    public Monster(char tile, Position pos, String name, int attack, int defense,
                   Health health, int experienceValue, int visionRange)
    {
        super (tile, pos, name, attack, defense, health, experienceValue);
        this.visionRange = visionRange;
    }

    public int getVisionRange() {return this.visionRange;}
}
