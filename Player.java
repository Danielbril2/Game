package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Player extends Unit
{
    private int experience;
    protected int level;
    private static final char p = '@';

    public Player(String name, int healCapacity, int attack, int defense)
    {
        super(p, name, healCapacity, attack, defense);
        this.experience = 0;
        this.level = 1;
    }

    private int getExperience(){return this.experience;}
    public void setExperience(int experience){ this.experience = experience;}

    public void levelUp() {
        experience -= 50 * level;
        level++;
        health.setHealthPool(health.getHealthPool() + 10 * level);
        health.setHealthAmount(health.getHealthPool());
        attack += 4 * level;
        defense += level;
    }

    public void accept(Unit unit){
        unit.visit(this);
    }

    public void visit(Player p){
        throw new RuntimeException("Player cannot visit another player");
    }

    public void visit(Enemy e){
        //need to implement combat
        battle(e);
        e.battle(this);
    }

    public void processStep(){

    }

    public void onDeath(){

    }

    @Override
    public Position move() {
        while (true) {

            Scanner input = new Scanner(System.in); //accept input from user

            char action = input.next().charAt(0); //convert input into char

            char specialAbility = 'e';
            char[] moves = {'w', 's', 'a', 'd', 'q'};
            int[][] posUpdates = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {0, 0}}; //up, down, left, right

            for (int i = 0; i < moves.length; i++) {
                if (moves[i] == action) {
                    Position move = Position.at(posUpdates[i][0], posUpdates[i][1]);
                    return position.addPos(move);
                } else if (action == specialAbility)
                    return Position.at(-1, -1); //means the player wants the special ability activated
            }
        }
    }
}
