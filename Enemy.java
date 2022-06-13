package com.company;

public class Enemy extends Unit
{

    private int experienceValue;

    public Enemy(char tile, Position pos, String name, int attack, int defense, Health health, int experienceValue)
    {
        super(tile, pos, name, attack, defense, health);
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {return this.experienceValue;}

    @Override
    public void move(char action)
    {

    }

    public void accept(Unit unit){

    }
}
