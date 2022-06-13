package com.company;

public class Health {
    private int healthPool; //max health
    private int healthAmount; //curr health

    public Health(int healthPool, int healthAmount){
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
    }

    public int getHealthAmount() {return healthAmount;}
    public int getHealthPool() {return healthPool;}

    public void setHealthPool(int healthPool){
        this.healthPool = healthPool;
    }

    public void setHealthAmount(int healthAmount){
        this.healthAmount = healthAmount;
    }
}
