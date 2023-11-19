package Schatz.game.tiles;

import Schatz.game.gfx.Assets;

public class Water1Tile extends Tile{
	
	private int id;
	public Water1Tile(int id) {
		super(Assets.water1, id);
		this.id = id;
		
	}
	
	public boolean isSolid() {
		if(id == 3)
			return true;
		else
			return false;
	}
}
