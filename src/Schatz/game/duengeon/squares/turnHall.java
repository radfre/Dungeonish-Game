package Schatz.game.duengeon.squares;

public class turnHall extends Square {
	public turnHall() {
		super();
		boolean[] sides = {  true,  true,  false,  false };
		openSides = sides;
		area=room;
	}

	private boolean[][] room = { {  true,  true,  true, false, false,  true,  true,  true },
		   	 						{  true,  true,  true, false, false,  true,  true,  true },
		   	 						{  true,  true,  true, false, false,  true,  true,  true },
		   	 						{ false, false, false, false, false, true,  true,  true },
		   	 						{ false, false, false, false, false, true,  true,  true },
		   	 						{  true,  true,  true,  true,  true,  true,  true,  true },
		   	 						{  true,  true,  true,  true,  true,  true,  true,  true },
		   	 						{  true,  true,  true,  true,  true,  true,  true,  true } };
}
