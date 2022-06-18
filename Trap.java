package com.company;

public class Trap extends  Enemy {
    private int visibilityTime;
    private int invisibilityTime;
    private int tickCounter;
    private boolean visible;

    public Trap(char tile,String name, int healCapacity, int attack, int defense, int experienceValue,
                int visibilityTime, int invisibilityTime)
    {
        super(tile, name, healCapacity, attack, defense, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.tickCounter = 0;
        this.visible = true;
    }
    public int getVisibilityTime() {return this.visibilityTime;}
    public int getInvisibilityTime() {return this.invisibilityTime;}
    public int getTickCounter() {return this.tickCounter;}
    public boolean getIsVisible() {return this.visible;}

    public void setVisible(boolean isVisible){this.visible = isVisible;}
    public void setTicks(int ticks) {this.tickCounter = ticks;}

    @Override
    public Position move(){
        visible = tickCounter < visibilityTime;
        if (tickCounter == (visibilityTime + invisibilityTime))
            tickCounter = 0;
        else
            tickCounter++;

        if (findRange(this.playerPos) < 2) {
            int attckValue = attack();
            //need to do some more
        }
        return position;

    }



}