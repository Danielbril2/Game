package com.company;
import java.util.*;

public class GameController {
    private Board board;
    private Player p;

    public GameController(Board board){
        this.board = board;
        findPlayer();
    }

    public void findPlayer(){
        this.p = board.getPlayer();
    }

    public void startGame(){
        while(!isGameDone()){
            tick();
            //update map
        }
    }

    private void tick(){
        p.move();

        List<Enemy> enemies = board.getEnemies();
        for(Enemy e: enemies) {
            e.updatePlayerPos(p.getPosition());
            e.move();
        }


    }

    private boolean isGameDone(){
        findPlayer();

        if (p == null) //checking if player dead
            return true;

        List<Tile> tiles = board.getTiles();
        for(Tile t: tiles)
            if(t instanceof Enemy) // CHANGE!!!!!!!!
                return false;
        return true;
    }
}
