package com.company;

public abstract class Unit extends Tile
{
    private String name;
    private int attack;
    private int defense;
    private Health health;

    public Unit(char tile, Position pos, String name, int attack, int defense, Health health)
    {
        super(tile, pos);
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public String getName() {return this.name;}
    public int getAttack() {return this.attack;}
    public int getDefense() {return this.defense;}
    public Health getHealth() {return this.health;}


    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }
}
