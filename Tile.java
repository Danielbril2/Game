package com.company;

public class Tile {
    private char tile;
    private Position pos;

    public Tile(char tile)
    {
        this.tile = tile;
    }

    public char getTile() {return this.tile;}
    public Position getPos() {return this.pos;}
    public void setPos(Position pos){this.pos = pos;}

}