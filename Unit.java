package com.company;
import java.lang.Math;

public abstract class Unit extends Tile implements Visitor {
    protected String name;
    protected int attack;
    protected int defense;
    protected Health health;

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
        //add something more
    }

    protected int attack(){
        return (int)(Math.random() * this.attack);
    }

    protected int defend(){
        return (int)(Math.random() * this.defense);
    }

    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();

    // What happens when the unit dies
    public abstract void onDeath();

    public abstract void accept(Unit unit);

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
        if (tile.getTile() != '#')//if we want to go to a wall we are unable to do it
            tile.accept(this);
    }

    public void visit(Empty e){
        Position emptyPos = e.getPosition();
        e.position.SetPosition(this.position);
        this.setPosition(emptyPos);
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    // Combat against another unit.
    protected void battle(Unit u){
        int ourMove = attack();
        int opponentMove = u.defend();

        if (ourMove > opponentMove)
            u.acceptDamage(ourMove - opponentMove);
    }

    public void acceptDamage(int damage) {health.setHealthAmount(health.getHealthAmount() - damage);}

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }

    public abstract Position move();
}
