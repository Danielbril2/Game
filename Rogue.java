package com.company;

public class Rogue extends Player
{
    private int cost;
    private int currEnergy;

    public Rogue (String name, int healCapacity, int attack, int defense, int cost)
    {
        super (name, healCapacity, attack, defense);
        this.cost = cost;
        this.currEnergy = 100;
    }

    @Override
    public Position move(){
        currEnergy = Math.min(currEnergy + 10,100);

        Position newPos = super.move();

        if (newPos.equals(Position.at(-1,-1))){ //activate special ability
            if (currEnergy >= cost){
                currEnergy -= cost;
                //for each enemy in range 2 deal damage equal to "attack". each enemy will try do defend itself
            }
            else
                throw new RuntimeException("Cannot cast special ability");

            return position;
        }
        else
            return newPos;
    }

    @Override
    public void levelUp(){
        super.levelUp();
        currEnergy = 100;
        setAttack(attack + (3 * level));
    }
}
