package Schatz.game.entities.statics;

import Schatz.game.Handler;
import Schatz.game.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height,100.0,("WALL"));
	}
	@Override
	public void changeX(float xMove) {
		
		
	}
	@Override
	public void changeY(float yMove) {
		
		
	}
	
}
