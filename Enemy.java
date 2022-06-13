package com.company;

public class Enemy extends Unit{

    private int experience;

    public Enemy(char tile, String name, int attack, int defense, int health, int experience)
    {
        super(tile, name, health, attack, defense);
        this.experience = experience;
    }

    public int getExperience()
    {
        return this.experience;
    }

    @Override
    public void move(char action)
    {

    }
}
