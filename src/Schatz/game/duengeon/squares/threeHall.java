package Schatz.game.duengeon.squares;

public class threeHall extends Square{
	public threeHall() {
		super();
		boolean[] sides = {  true,  true,  true,  false };
		openSides = sides;
		area=room;
	}

	private boolean[][] room = { {  true,  true,  true, false, false,  true,  true,  true },
							   	 {  true,  true,  true, false, false,  true,  true,  true },
								 {  true,  true,  true, false, false,  true,  true,  true },
								 { false, false, false, false, false, false, false, false },
								 { false, false, false, false, false, false, false, false },
								 {  true,  true,  true,  true,  true,  true,  true,  true },
								 {  true,  true,  true,  true,  true,  true,  true,  true },
								 {  true,  true,  true,  true,  true,  true,  true,  true } };
}
