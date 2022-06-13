package com.company;

public class Player extends Unit{
    private int experience;
    private int level;

    public Player(char tile, String name, int attack, int defense, int health)
    {
        super(tile, name, health,attack, defense);
        this.experience = 0;
        this.level = 0;
    }

    public int getExperience()
    {
        return this.experience;
    }

    public int getLevel()
    {
        return this.level;
    }

    @Override
    public void move(char action)
    {

    }
}
