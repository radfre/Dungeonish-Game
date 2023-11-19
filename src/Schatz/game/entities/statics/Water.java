package Schatz.game.entities.statics;

import java.awt.Graphics;

import Schatz.game.Handler;
import Schatz.game.gfx.Assets;
import Schatz.game.tiles.Tile;

public class Water extends StaticEntity{

	public Water(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	}

	@Override
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.water1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
	}
}
