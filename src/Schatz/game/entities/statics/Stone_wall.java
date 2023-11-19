package Schatz.game.entities.statics;

import java.awt.Graphics;

import Schatz.game.Handler;
import Schatz.game.gfx.Assets;
import Schatz.game.tiles.Tile;

public class Stone_wall  extends StaticEntity{

	public Stone_wall(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x =-10;
		bounds.y =0;
		bounds.width = width+20;
		bounds.height = height-10;
	}
	

	@Override
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.stone, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
	}
}
