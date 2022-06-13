package com.company;

public class Empty extends Tile{

    private static final char dot = '.';

    public Empty(Position pos){
        super(dot, pos);
    }
    public void accept(Unit unit){

    }
}
