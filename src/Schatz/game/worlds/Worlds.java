package Schatz.game.worlds;

import java.awt.Graphics;
import java.util.ArrayList;
import Schatz.game.Game;
import Schatz.game.Handler;
import Schatz.game.entities.Entity;
import Schatz.game.entities.EntityManager;
import Schatz.game.entities.creatures.Kobold;
import Schatz.game.entities.creatures.Player;
import Schatz.game.entities.statics.Bot_Wall;
import Schatz.game.entities.statics.Stone_wall;
import Schatz.game.entities.statics.Water;
import Schatz.game.tiles.Tile;
import Schatz.game.utils.Utils;
import Schatz.game.duengeon.*;

public class Worlds {

	private Handler handler;
	private int width, height;
	private static int spawnX;
	private static int spawnY;
	private int[][] tiles;
	private int entityCount;
	// Entities
	private EntityManager entManag;
	private ArrayList<Entity> entityque;
	
	//deungeon
	private Duengeon duengeon;

	public Worlds(Handler handler, String path) {
		this.handler = handler;
		entManag = new EntityManager(handler, new Player(handler, 100, 100, 0));

		entityque = new ArrayList<Entity>();
		
		duengeon=new Duengeon(64,64,1000);
		

		loadWorld(path);
		for (int i = entityque.size() - 1; i >= 0; i--)
			entManag.addEntity(entityque.get(i));

		entManag.getPlayer().setX(spawnX);
		entManag.getPlayer().setY(spawnY);
		
	}

	public EntityManager getEntManag() {
		return entManag;
	}

	public void tick() {
		entManag.tick();
	}

	public void render(Graphics g) {
		int xStart = (int) (Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH));
		int xEnd = (int) (Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1));
		int yStart = (int) (Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILEHEIGHT));
		;
		int yEnd = (int) (Math.min(height,
				(handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1));

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()));
			}
		}
		// Entities
		entManag.render(g);

	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;

		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		//String[] tokens = file.split("\\s+");
		
		String[] tokens= duengeon.CreatDuengeon();

		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);

				if (tiles[x][y] == 2) {
					entManag.addEntity(new Stone_wall(handler, (x * 64), y * 64));
				}
				if (tiles[x][y] == 9) {

					tiles[x][y] = 1;// Utils.parseInt(tokens[(x + y * width) + 4]);
					entityque.add(new Kobold(handler, (x * 64), y * 64, entityCount));
				}

			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public static int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
}
