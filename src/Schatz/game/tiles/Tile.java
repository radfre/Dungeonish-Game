package Schatz.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Tile {
	
	//Static Stuff
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(4);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new Water1Tile(5);
	public static Tile watertile = new Water2Tile(5);
	public static Tile lavatile = new LavaTile(3);
	public static Tile wfloor = new WFloor(1);
	
	
	//CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
