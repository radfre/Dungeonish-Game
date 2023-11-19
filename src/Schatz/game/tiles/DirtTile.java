package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class DirtTile extends Tile{

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
