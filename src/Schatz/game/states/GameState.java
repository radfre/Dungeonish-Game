package Schatz.game.states;

import java.awt.Graphics;

import Schatz.game.Game;
import Schatz.game.Handler;
import Schatz.game.entities.creatures.Player;
import Schatz.game.entities.statics.Water;
import Schatz.game.gfx.Assets;
import Schatz.game.ui.UIManager;
import Schatz.game.worlds.Worlds;


public class GameState extends State{

	private Player player;
	private Worlds world;

	
	public GameState(Handler handler) {
		super(handler);
		
		world = new Worlds(handler, "res/worlds/world_00.txt");
		handler.setWorld(world);
	}
	
	@Override
	public UIManager getui() {
		return null;
	}
	
	@Override
	public void tick() {
		world.tick();
		
		if(handler.getKeyManager().esc) {
			
			handler.getGame().igoptionsState = new InGameOptionState(handler);
			State.setState(handler.getGame().igoptionsState);
			
		
			handler.getMouseManager().setUIManager(handler.getGame().igoptionsState.getui());
		}
	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	
	
}