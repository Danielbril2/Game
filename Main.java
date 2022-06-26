package com.company;

public class Main {

    public static void main(String[] args) {
        String path = args[0];
        Controller game = new Controller(path);
        game.startGame();
    }
}
