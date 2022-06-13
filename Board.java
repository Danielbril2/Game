package com.company;

public class Board {
    private char[] board;

    public Board(char[] board)
    {
        this.board = board;
    }

    public static double findRange(int x1, int y1, int x2, int y2)
    {
        double dist = Math.abs(Math.sqrt(x1 - x2) + Math.sqrt(y1 - y2));
        return dist;
    }
}
