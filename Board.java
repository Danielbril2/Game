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
        return tiles.stream().filter((t) -> t.position.equals(Position.at(x,y))).toList().get(0);
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
        List<Enemy> enemies = tiles.stream().filter(Tile::isEnemy).map(Tile::getEnemyVersion).toList();
        return enemies;

    }

    public Player getPlayer()
    {
        return tiles.stream().filter(Tile::isPlayer).map(Tile::getPlayerVersion).toList().get(0);
    }


}
