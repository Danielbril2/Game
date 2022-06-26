package com.company;

public class Main {

    public static void main(String[] args) {
        //String path = args[0];
        String path2 = "C:\\Users\\yuval yael\\Desktop\\New folder\\levels_dir";
        Controller game = new Controller(path2);
        game.startGame();
    }
}
