package com.company;

public abstract class Unit extends Tile{
    private String name;
    private int attack;
    private int defense;
    private int healthAmount;

    public Unit(char tile, String name, int healthAmount,int attack, int defense)
    {
        super(tile);
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.healthAmount = healthAmount;
    }

    public String getName() {return this.name;}
    public int getAttack() {return this.attack;}
    public int getDefense() {return this.defense;}
    public int getHealth() {return this.healthAmount;}

    public abstract void move(char action);

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }
}
