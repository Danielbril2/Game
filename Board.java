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
        return null;
    }

    public void remove(Tile e) {
        tiles.remove(e);
        Position p = e.getPosition();
        tiles.add(new Empty(p));
    }

    @Override
    public String toString() {
        tiles = tiles.stream().sorted().collect(Collectors.toList());
        // TODO: Implement me
        throw new NoSuchElementException();
    }

    public List<Tile> getTiles() {return tiles;}

    public List<Enemy> getEnemies(){
        List<Enemy> res = new ArrayList<>();
        for (Tile t : tiles) {
            if (t.isEnemy())
                res.add(t.getEnemyVersion());
        }
        return res;
    }

    public Player getPlayer()
    {
        for (Tile t : this.tiles)
            if (t.isPlayer())
                return t.getPlayerVersion();
        return null;
    }


}
