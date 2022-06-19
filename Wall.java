package com.company;

public class Wall extends Tile{
    private static final char wall = '#';

    public Wall(Position pos){
        super(wall);
        initialize(pos);
    }

    public void accept(Unit unit){

    }
}
