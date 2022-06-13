package com.company;
import java.util.*;

public class GameController {
    private Board board;

    public GameController(Board board){
        this.board = board;
    }

    public void startGame(){
        while(!isGameDone()){
            round();
        }
    }

    public void round(){
        List<Tile> tiles = board.getTiles();
        for(Tile t: tiles)
            t.move();
    }

    public boolean isGameDone(){
        List<Tile> tiles = board.getTiles();
        for(Tile t: tiles)
            if(t instanceof Enemy) // CHANGE!!!!!!!!
                return false;
        return true;
    }
}
