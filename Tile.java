package com.company;

public abstract class Tile {
    private char tile;
    private Position pos;

    public Tile(char tile, Position pos)
    {
        this.tile = tile;
        this.pos = pos;
    }

    public char getTile() {return this.tile;}
    public Position getPosition() {return this.pos;}
    public void setPosition(Position pos) {this.pos = pos;}
    public abstract void accept(Unit unit);
    public abstract void move(char action);

//    @Override
//    public int compareTo(Tile tile) {
//        return getPosition().compareTo(tile.getPosition());
//    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }
}
