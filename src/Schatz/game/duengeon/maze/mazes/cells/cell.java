package Schatz.game.duengeon.maze.mazes.cells;



import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class cell {
    private final boolean empty;
    public int x, y, size;
    public boolean visited = false;
    public boolean pathed = false;
    private ArrayList<Boolean> openings;// 0-down,1-left,2-up,3-right
    public boolean start,end;


    public cell(int x, int y, int size,boolean empty) {
        Random r = new Random();

        this.x = x;
        this.y = y;
        this.size = size;
        this.empty=empty;
        openings = new ArrayList<Boolean>(5);
        for (int i = 0; i < 5; i++) {
            openings.add(empty);
        }

        start=false;
        end=false;

    }



    public void draw(Graphics g, Color color0, Color color1) {
        // g.drawRect(x, y, size, size);

        if (start) {
            g.setColor(Color.red);
            g.fillRect(1 + x + size / 4, 1 + y + size / 4, -1 + size / 2, -1 + size / 2);
        }
        if (end) {
            g.setColor(Color.orange);
            g.fillRect(1 + x + size / 4, 1 + y + size / 4, -1 + size / 2, -1 + size / 2);
        }
        if (pathed) {
            g.setColor(Color.orange);
            g.fillRect(1 + x + size / 16, 1 + y + size / 16, size - (size / 8) - 2, size - (size / 8) - 2);
        }
        g.setColor(color0);

        if (openings.get(0)) {
            // g.setColor(Color.BLUE);

            g.drawLine(x, y + size, x + size, y + size);
        }/*else{
            g.setColor(color1);
            g.drawLine(x, y + size, x + size, y + size);
            g.setColor(color0);
        }*/
        if (openings.get(1)) {
            // g.setColor(Color.RED);
            g.drawLine(x, y, x, y + size);
        }/*else{
            g.setColor(color1);
            g.drawLine(x, y, x, y + size);
            g.setColor(color0);
        }*/

        if (openings.get(2)) {
            // g.setColor(Color.GREEN);
            g.drawLine(x, y, x + size, y);
        }/*else{
            g.setColor(color1);
            g.drawLine(x, y, x + size, y);
            g.setColor(color0);
        }*/
        if (openings.get(3)) {
            // g.setColor(Color.ORANGE);
            g.drawLine(x + size, y, x + size, y + size);
        }/*else{
            g.setColor(color1);
            g.drawLine(x + size, y, x + size, y + size);
            g.setColor(color0);
        }*/

    }

    // 0-down,1-left,2-up,3-right
    public void eraseUp() {
        openings.remove(2);
        openings.add(2, !empty);
    }

    public void eraseDown() {
        openings.remove(0);
        openings.add(0, !empty);
    }

    public void eraseRight() {
        openings.remove(3);
        openings.add(3, !empty);
    }

    public void eraseLeft() {
        openings.remove(1);
        openings.add(1, !empty);
    }

    public void visit() {

        visited = true;

    }

}
