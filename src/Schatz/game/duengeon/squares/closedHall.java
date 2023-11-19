package Schatz.game.duengeon.squares;

public class closedHall extends Square {
	public closedHall() {
		super();
		boolean[] sides = {  true,  false,  false,  false };
		openSides = sides;
		area=room;
	}

	private boolean[][] room = { {  true,  true,  true,  true, true,  true,  true,  true },
							   	 {  true,  true,  true,  true, true,  true,  true,  true },
								 {  true,  true,  true,  true, true,  true,  true,  true },
								 { false, false, false, false, false, true, true,  true },
								 { false, false, false, false, false, true, true,  true },
								 {  true,  true,  true,  true, true,  true,  true,  true },
								 {  true,  true,  true,  true, true,  true,  true,  true },
								 {  true,  true,  true,  true, true,  true,  true,  true } };
}
