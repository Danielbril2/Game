package com.company.Tiles;
import com.company.*;
import com.company.Enemies.Enemy;
import com.company.Players.Player;

import java.lang.Math;

public abstract class Unit extends Tile implements Visitor {
    protected String name;
    protected int attack;
    protected int defense;
    protected Health health;
    protected Observer observer;
    protected MessageCallback messageCallback;

    public Unit(char tile,String name, int healCapacity, int attack, int defense)
    {
        super(tile);
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = new Health(healCapacity);
    }

    public String getName() {return this.name;}
    public int getAttack() {return this.attack;}
    public int getDefense() {return this.defense;}
    public Health getHealth() {return this.health;}

    public void setAttack(int attack) {this.attack = attack;}
    public void setDefense(int defense) {this.defense = defense;}

    protected void initialize(Position position, MessageCallback messageCallback){
        this.initialize(position);
        this.messageCallback = messageCallback;
    }

    protected void initializeObserver(Observer observer){
        this.observer = observer;
    }


    protected int attack(){
        int roll = (int)(Math.random() * this.attack);
        messageCallback.send(getName() + " rolled " + roll + " attack points.");
        return roll;
    }

    public int defend(){
        int roll = (int)(Math.random() * this.defense);
        messageCallback.send(getName() + " rolled " + roll + " defense points.");
        return roll;
    }

    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();

    // What happens when the unit dies
    public abstract void onDeath();

    public abstract void accept(Unit unit);

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
        if (tile.getTile() != '#')// we cannot go to a wall
            tile.accept(this);
    }

    public void visit(Empty e){
        Position emptyPos = e.getPosition();
        emptyPos = Position.at(emptyPos.getX(),emptyPos.getY());
        e.position.SetPosition(this.position);
        this.setPosition(emptyPos);
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    public abstract boolean isAlive();

    // Combat against another unit.
    public boolean battle(Unit u){
        messageCallback.send(getName() + " engaged in combat with " + u.getName());
        messageCallback.send(describe());
        messageCallback.send(u.describe());

        int ourMove = attack();
        int opponentMove = u.defend();

        if (ourMove > opponentMove) {
            StringBuilder sb = new StringBuilder();
            sb.append(getName());
            sb.append("dealt ").append(Integer.toString(ourMove - opponentMove));
            sb.append(" damage to ").append(u.getName());
            messageCallback.send(sb.toString());
            u.acceptDamage(ourMove - opponentMove);
        }

        return !u.isAlive(); //return true if the unit killed
    }

    public void acceptDamage(int damage) {
        health.setHealthAmount(health.getHealthAmount() - damage);
        if (health.getHealthAmount() <= 0)
            onDeath();
    }

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth().getHealthAmount()+"/"+getHealth().getHealthPool(), getAttack(), getDefense());
    }

    public abstract Position move(); // return the estimated next position
}
