package com.company;

public class Mage extends Player{

    private int manaPool;
    private int currMana;
    private int manaCost;
    private int spellPower;
    private int hitCounter;
    private int abilityRange;


    public Mage(char tile, int x, int y, String name, int attack, int defense, Health health,
                int experience, int level, int manaPool, int manaCost, int spellPower,
                int hitCounter, int abilityRange)
    {
        super (tile, x, y, name, attack, defense, health, experience, level);
        this.manaPool = manaPool;
        this.currMana = this.manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitCounter = hitCounter;
        this.abilityRange = abilityRange;
    }

    public int gteCurrMana()
    {
        return this.currMana;
    }
    public int getAbilityRange()
    {
        return this.abilityRange;
    }
}
