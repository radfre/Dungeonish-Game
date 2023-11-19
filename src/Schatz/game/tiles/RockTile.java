package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
