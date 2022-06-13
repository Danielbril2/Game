package com.company;

public class Trap extends  Enemy {
    private int visibilityTime;
    private int invisibilityTime;
    private int tickCounter;
    private boolean visible;

    public Trap(char tile, String name, int attack, int defense,
                int health, int experience, int visibilityTime, int invisibilityTime, boolean visible)
    {
        super(tile, name, health, attack, defense, experience);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.tickCounter = 0;
        this.visible = visible;
    }
    public int getVisibilityTime()
    {
        return this.visibilityTime;
    }
    public int getInvisibilityTime()
    {
        return this.invisibilityTime;
    }
    public int getTickCounter()
    {
        return this.tickCounter;
    }
    public boolean getIsVisible()
    {
        return this.visible;
    }

    @Override
    public void move(char action)
    {

    }
}