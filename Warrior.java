package com.company;

public class Warrior extends  Player
{
    private int cooldown;
    private int remainingCooldown;

    public Warrior (String name, int healCapacity, int attack, int defense, int cooldown)
    {
        super(name, healCapacity, attack, defense);
        this.cooldown = cooldown;
        this.remainingCooldown = 0;
    }

    @Override
    public Position move(){
        remainingCooldown -= 1;

        Position newPos = super.move();

        if (newPos.equals(Position.at(-1,-1))){ //activate special ability
            if (remainingCooldown <= 0){
                remainingCooldown = cooldown;
                int currHealth = health.getHealthAmount();
                int maxHealth = health.getHealthPool();
                getHealth().setHealthAmount(Math.min(currHealth + (10 * defense),maxHealth));

                //find an enemy in range of 3 and attack him with 10% of health pool
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
        remainingCooldown = 0;
        health.setHealthPool(health.getHealthPool() + 5 * level);
        setAttack(attack + (2 * level));
        setDefense(defense + level);
    }

}
