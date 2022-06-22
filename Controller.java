package com.company;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

import com.company.Enemies.Enemy;
import com.company.Players.Player;
import com.company.Tiles.Empty;
import com.company.Tiles.Tile;
import com.company.UI.CLI;

public class Controller {
    private GameController levelManager;
    private CLI uiController;
    private final TileFactory tf;
    private final String levelsPath;
    private int currLevel;
    private MessageCallback msg;
    private Player player;

    public Controller(String levelsPath){
        uiController = new CLI();
        tf = new TileFactory();
        this.levelsPath = levelsPath;
        this.currLevel = 1;
        msg = uiController.getMessageCallback();
        player = null;
    }

    public void startGame(){
        List<File> allLevels = getAllLevels(levelsPath);

        uiController.print("Select player: ");
        List<Player> players = tf.listPlayers();
        int playerCounter = 1;
        for (Player p: players) {
            uiController.print(Integer.toString(playerCounter) + ". " + p.describe() + "\n");
            playerCounter++;
        }

        Scanner input = new Scanner(System.in); //choose player
        int choosePlayer = Character.getNumericValue(input.next().charAt(0));

        boolean stopGame = true;
        for (currLevel = 1; currLevel <= allLevels.size() & stopGame; currLevel++) { //go through all levels
            Board levelBoard = getCurrLevel(allLevels, choosePlayer - 1);
            Player p = levelBoard.getPlayer();
            uiController.print("You have selected: \n" + p.getName());

            GameController levelManager = new GameController(levelBoard, msg);
            stopGame = levelManager.startGame(); //if player dead, returns false
            if (!stopGame)
                msg.send(levelBoard.toString()); //last update
        }
        msg.send("GAME OVER.");
    }

    private Board getCurrLevel(List<File> allLevels, int playerNum){
        String levelName = allLevels.get(currLevel - 1).getName();
        String levelPath = levelsPath + "\\" + levelName;

        List<String> lines = new ArrayList<>();

        try{ // reading from the file
            lines = Files.readAllLines(Paths.get(levelPath));
        }catch (IOException e) {
            uiController.print("Error while reading file: " + levelPath);
        }

        //need to create a 2d array of tiles
        Tile[][] tiles = text2Array(lines,playerNum);

        return new Board(tiles);
    }

    private Tile[][] text2Array(List<String> lines, int playerNum){
        int maxLineLen = 0;
        for (String line: lines)
            maxLineLen = Math.max(maxLineLen,line.length());

        Tile[][] tiles = new Tile[lines.size()][maxLineLen];

        int lineCounter = 0;
        for (String line: lines){
            int lineLen = line.length();
            for (int i = 0; i < lineLen; i++) {
                char currChar = line.charAt(i);
                Position currPos = Position.at(i, lineCounter);
                if (currChar == '.') //empty tile
                    tiles[lineCounter][i] = tf.produceEmpty(currPos);
                else if (currChar == '#') //wall tile
                    tiles[lineCounter][i] = tf.produceWall(currPos);
                else if (currChar == '@') { //player tile
                    if (player == null) //first level and we need to create new player
                        player = tf.producePlayer(playerNum, currPos, msg);
                    //continue with the last player
                    player.initialize(currPos,msg);
                    tiles[lineCounter][i] = player;
                }
                else {//enemy
                    Enemy e = tf.produceEnemy(currChar, currPos, msg);
                    if (e != null)
                        tiles[lineCounter][i] = e;
                    else
                        tiles[lineCounter][i] = tf.produceEmpty(currPos);
                }
            }
            lineCounter++;
        }

        return tiles;
    }

    private List<File> getAllLevels(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        return List.of(listOfFiles);
    }

}
