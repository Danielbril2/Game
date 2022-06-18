package com.company;
import java.lang.Math;

public abstract class Unit extends Tile
{
    private String name;
    private int attack;
    private int defense;
    private Health health;

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

    public void accept(Unit unit){

    }

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

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
        //check if tile a dor than change its position and our position
        //if tile a wall do nothing
        //if tile an enemy start a combat
        if (tile.getTile() == '.'){ //if empty tile than just switch between the places
            Position emptyPos = tile.getPosition();
            tile.position.SetPosition(this.position);
            this.setPosition(emptyPos);
        }
        else if (tile.getTile() == '#'){return;}//if trying to do to the wall do nothing. Need to be empty case
        // because we want the "else" later.
        else{ //trying to attack

        }
    }

    public void visit(Empty e){

    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    // Combat against another unit.
    protected void battle(Unit u){
        int ourMove;
        int opponentMove;
        //the attacker turn
        ourMove = attack();
        opponentMove = u.defend();
        if (ourMove > opponentMove)
            u.acceptDamage(ourMove - opponentMove);
        //the opponent turn
         opponentMove = u.attack();
         ourMove = defend();
         if (opponentMove > ourMove)
             acceptDamage(opponentMove - ourMove);
    }

    public void acceptDamage(int damage) {health.setHealthAmount(health.getHealthAmount() - damage);}

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }

    public abstract Position move();
}
