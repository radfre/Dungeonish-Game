package Schatz.game.duengeon.squares;

public class straightHall extends Square {
	
	public straightHall() {
		super();
		boolean[] sides = {  true,  false,  true,  false };
		openSides = sides;
		area=room;
	}

	private boolean[][] room = { {  true,  true,  true, true,  true,  true,  true,  true },
								{  true,  true,  true,  true,  true,  true,  true,  true },
								{  true,  true,  true,  true,  true,  true,  true,  true },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{  true,  true,  true,  true,  true,  true,  true,  true },
								{  true,  true,  true,  true,  true,  true,  true,  true },
								{  true,  true,  true,  true,  true,  true,  true,  true } };
}
