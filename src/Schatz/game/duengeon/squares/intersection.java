package Schatz.game.duengeon.squares;

public class intersection extends Square {

	public intersection() {
		super();
		boolean[] sides = {  true,  true,  true,  true };
		openSides = sides;
		area=room;
	}

	private boolean[][] room = { {  true,  true,  true, false, false,  true,  true,  true },
							   	 {  true,  true,  true, false, false,  true,  true,  true },
								 {  true,  true,  true, false, false,  true,  true,  true },
								 { false, false, false, false, false, false, false, false },
								 { false, false, false, false, false, false, false, false },
								 {  true,  true,  true, false, false,  true,  true,  true },
								 {  true,  true,  true, false, false,  true,  true,  true },
								 {  true,  true,  true, false, false,  true,  true,  true } };

}
