package com.company;

public class Main {

    public static void main(String[] args) {
        String path = args[3];
        //String path = "C:\\Users\\yuval yael\\Desktop\\New folder\\levels_dir";
        Controller game = new Controller(path);
        game.startGame();
    }
}
