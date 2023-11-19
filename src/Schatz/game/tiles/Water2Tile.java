package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class Water2Tile extends Tile {

	private int id;
	public Water2Tile(int id) {
		super(Assets.water2, id);
		this.id = id;
		
	}
	
	public boolean isSolid() {
		if(id == 3)
			return true;
		else
			return false;
	}
}
