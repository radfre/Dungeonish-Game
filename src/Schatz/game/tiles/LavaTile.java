package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class LavaTile extends Tile{

	public LavaTile(int id) {
		super(Assets.lava, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
