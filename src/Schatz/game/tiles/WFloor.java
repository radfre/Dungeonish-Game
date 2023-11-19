package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class WFloor extends Tile{

	public WFloor(int id) {
		super(Assets.wfloor, id);
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
