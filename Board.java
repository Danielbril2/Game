package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Board
{
    private List<Tile> tiles;

    public Board(Tile[][] board)
    {
        tiles = new ArrayList<>();
        for(Tile[] line : board)
            tiles.addAll(Arrays.asList(line));
    }

    public Tile get(int x, int y) {
        for(Tile t : tiles)
            if (t.getPosition().equals(Position.at(x, y)))
                return t;
        throw new NoSuchElementException("There is no tile in this position");
    }

    public void remove(Enemy e) {
        tiles.remove(e);
        Position p = e.getPosition();
        tiles.add(new Empty(p));
    }

    public static double findRange(int x1, int y1, int x2, int y2)
    {
        return Math.abs(Math.sqrt(x1 - x2) + Math.sqrt(y1 - y2));
    }
    @Override
    public String toString() {
        tiles = tiles.stream().sorted().collect(Collectors.toList());
        // TODO: Implement me
        throw new NoSuchElementException();
    }

    public List<Tile> getTiles() {return tiles;}


}
