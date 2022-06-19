package com.company;
import java.util.*;

public class GameController {
    private Board board;
    private Player p;

    public GameController(Board board){
        this.board = board;
        this.p = findPlayer();
    }

    public Player findPlayer(){
        return board.getPlayer();
    }

    public void startGame(){
        //need to choose the player somehow?

        while(isPlayerAlive()){
            //need to start a level, that after that level go to the next level
            tick();
            //update map
        }
        System.out.println("Game Over.");
    }

    private void tick(){
        Position playerDesiredPos = p.move();

        Tile nextTile;

        if (!playerDesiredPos.equals(Position.at(-1,-1))) { //the player did not activate his special ability
            nextTile = board.get(playerDesiredPos.getX(), playerDesiredPos.getY());
            p.interact(nextTile);
        }
        p.processStep();

        List<Enemy> enemies = board.getEnemies();
        for(Enemy e: enemies) {
            e.updatePlayerPos(p.getPosition());
            Position enemyDesiredPos = e.move();
            nextTile = board.get(enemyDesiredPos.getX(), enemyDesiredPos.getY());
            e.interact(nextTile);
        }

    }

    public boolean isPlayerAlive(){
        return findPlayer() != null;
    }

    private boolean isLevelDone(){
        List<Tile> tiles = board.getTiles();
        for(Tile t: tiles)
            if(t.isEnemy())
                return false;
        return true;
    }
}
