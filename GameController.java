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
        //need to choose the player somehow?

        //also need to go to next level
        while(!isGameDone()){
            tick();
            //update map
        }
    }

    private void tick(){
        Position playerDesiredPos = p.move();

        Tile nextTile = board.get(playerDesiredPos.getX(), playerDesiredPos.getY());
        p.interact(nextTile);

        List<Enemy> enemies = board.getEnemies();
        for(Enemy e: enemies) {
            e.updatePlayerPos(p.getPosition());
            Position enemyDesiredPos = e.move();
            nextTile = board.get(enemyDesiredPos.getX(), enemyDesiredPos.getY());
            e.interact(nextTile);
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
