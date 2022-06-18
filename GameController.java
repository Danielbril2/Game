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
        Position playerDesiredPos = p.move();
        //need to check if player can move here. If the desired position contains empty tile, wall tile
        //or enemy tile

        //interact does change the inner position of the player(Unit)
        //but need to change the curr pos to dot if moving
        p.interact(board.get(playerDesiredPos.getX(), playerDesiredPos.getY()));


        List<Enemy> enemies = board.getEnemies();
        for(Enemy e: enemies) {
            e.updatePlayerPos(p.getPosition());
            Position enemyDesiredPos = e.move();
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
