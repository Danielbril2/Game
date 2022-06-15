package com.company;

public class Wall extends Tile{
    private static final char wall = '#';

    public Wall(Position pos){
        super(wall);
    }

    public void accept(Unit unit){

    }
}
