package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Player extends Unit
{
    private int experience;
    private int level;
    private static final char p = '@';

    public Player(String name, int healCapacity, int attack, int defense)
    {
        super(p, name, healCapacity, attack, defense);
        this.experience = 0;
        this.level = 1;
    }

    public int getExperience() {return this.experience;}
    public int getLevel() {return this.level;}

    public void levelUp() {

    }


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

    @Override
    public void move(){
        //accept info from user
        Scanner input =  new Scanner(System.in);

        char action = input.next().charAt(0);

        char[] moves = {'w','s','a','d'};
        int[][] posUpdates = {{0,1},{0,-1},{-1,0},{1,0}}; //up, down, left, right

        for (int i = 0; i < moves.length; i++)
            if (moves[i] == action)
                getPosition().addPos(Position.at(posUpdates[i][0],posUpdates[i][1])); //updating the position
    }
}
