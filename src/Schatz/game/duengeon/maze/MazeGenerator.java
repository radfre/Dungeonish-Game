package Schatz.game.duengeon.maze;


import Schatz.game.duengeon.maze.mazes.*;
import Schatz.game.duengeon.maze.mazes.cells.cell;


public class MazeGenerator {

    Maze maze;



    public MazeGenerator(String Type, int width, int height) {


        switch (Type) {
            case "BinaryTree":
                maze = new BinaryTree(width, height, 1, 1, 1, false);
                break;
            case "SideWinder":
                maze = new SideWinder(width, height, 1, 1, 1, false);
                break;
            case "HuntKill":
                maze = new HuntKill(width, height, 1, 1, 1, false);
                break;
            case "BackTrack":
                maze = new BackTrack(width, height, 1, 1, 1, false);
                break;
            default:
                maze = new BackTrack(width, height, 1, 1, 1, false);
                break;
        }
        maze.work();
    }

    public cell[][] getMaze() {
        return maze.getCells();
    }
}

