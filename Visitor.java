package com.company;

public interface Visitor {
    void visit(Player p);
    void visit(Enemy p);
}
