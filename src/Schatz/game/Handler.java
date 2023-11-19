package Schatz.game;

import Schatz.game.gfx.GameCamera;
import Schatz.game.input.KeyManager;
import Schatz.game.input.MouseManager;
import Schatz.game.worlds.Worlds;

public class Handler {

	private Game game;
	private Worlds world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Worlds getWorld() {
		return world;
	}

	public void setWorld(Worlds world) {
		this.world = world;
	}
}
