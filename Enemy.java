package com.company;

public abstract class Enemy extends Unit
{
    private int experienceValue;
    protected Position playerPos;

    public Enemy(char tile,String name, int healCapacity, int attack, int defense, int experienceValue)
    {
        super(tile, name, healCapacity, attack, defense);
        this.experienceValue = experienceValue;
        playerPos = new Position(0,0);
    }

    public void updatePlayerPos(Position pos){
        playerPos = pos;
    }

    public int getExperienceValue() {return this.experienceValue;}


    public void accept(Unit unit){

    }

    public void visit(Player p){
        //probably not need to implement
    }

    public void visit(Enemy e){

    }

    public void processStep(){

    }

    public void onDeath(){

    }

    public abstract void move();
}
