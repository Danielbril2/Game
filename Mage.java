package com.company;

public class Mage extends Player
{

    private int manaPool;
    private int currMana;
    private int manaCost;
    private int spellPower;
    private int hitCounter;
    private int abilityRange;


    public Mage(String name, int healCapacity, int attack, int defense, int manaPool, int manaCost,
                int spellPower, int hitCounter,int abilityRange)
    {
        super (name, healCapacity, attack, defense);
        this.manaPool = manaPool;
        this.currMana = this.manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitCounter = hitCounter;
        this.abilityRange = abilityRange;
    }



    public Position move(){
        currMana = Math.min(manaPool, currMana + level);

        Position newPos = super.move();

        if (newPos.equals(Position.at(-1,-1))){ //activate special ability
            if (currMana >= manaCost){
                currMana = currMana - manaCost;
                int hits = 0;

                while (hits < hitCounter /* and there are existing enemies in the abilityRange*/){
                    //select random enemy in the range
                    //deal damage equal to spell power(enemy can defend itself)
                    hits++;
                }
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
        manaPool += 25 * level;
        currMana = Math.min(currMana + manaPool/4,manaPool);
        spellPower += 10 * level;
    }

}
