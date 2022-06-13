package com.company;

public class Player extends Unit
{
    private int experience;
    private int level;
    private static final char p = '@';

    public Player(Position pos, String name, int attack, int defense, Health health)
    {
        super(p, pos, name, attack, defense, health);
        this.experience = 0;
        this.level = 1;
    }

    public int getExperience() {return this.experience;}
    public int getLevel() {return this.level;}

    public void levelUp() {

    }

    @Override
    public void move(char action)
    {

    }

    public void accept(Unit unit){

    }
}
