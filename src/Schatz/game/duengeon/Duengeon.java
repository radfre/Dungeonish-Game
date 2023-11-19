package Schatz.game.duengeon;

import Schatz.game.duengeon.squares.Square;


public class Duengeon {
	public int width, height, totalexp;
	private Squares squares;

	private Square[][] level;

	public Duengeon(int width, int height, int totalexp) {
		this.width = width;
		this.height = height;
		this.totalexp = totalexp;
		squares = new Squares();
		level = new Square[width / 8][height / 8];
	}

	public String[] CreatDuengeon() {
		String[] duengeon = new String[4 + width * height];
		level = squares.createLevel(width / 8, height / 8);
		int index = 0;
		duengeon[index++] = width + "";
		duengeon[index++] = height + "";
		duengeon[index++] = 150 + "";
		duengeon[index++] = 150 + "";

		// startpoint

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				if (level[(i / 8)][(j / 8)].area[i % 8][j % 8])
					duengeon[index++] = 2 + "";
				else {

					
						duengeon[index++] = 1 + "";
				}

			}
		}

		return duengeon;
	}

}
