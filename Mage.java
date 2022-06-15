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

    public int gteCurrMana() {return this.currMana;}
    public int getAbilityRange() {return this.abilityRange;}
    public int getManaPool() {return this.manaPool;}
    public int getManaCost() {return this.manaCost;}
    public int getSpellPower() {return this.spellPower;}
    public int getHitCounter() {return this.hitCounter;}

}
