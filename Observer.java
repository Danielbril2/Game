package com.company;
import java.util.*;

public class Observer {
    private Board b;
    private Player p;

    public Observer(Board b){
        this.b = b;
        this.p = b.getPlayer();
    }

    public List<Enemy> findEnemiesInRange(int range){
        List<Enemy> enemies = new ArrayList<>();
        for(Enemy e: b.getEnemies())
            if (e.findRange(p.getPosition()) == range)
                enemies.add(e);
        return enemies;
    }
}
