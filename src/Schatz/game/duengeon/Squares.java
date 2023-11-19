package Schatz.game.duengeon;

import Schatz.game.duengeon.squares.Square;
import Schatz.game.duengeon.squares.*;

public class Squares {

	public Squares() {

	}

	public Square rotateSquare(Square square) {

		return square;
	}

	public Square[][] createLevel(int w, int h) {
		// TODO Auto-generated method stub


		Square[][] level = new Square[h][w];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if(Math.random()>0.75) {
					level[i][j]=new threeHall();
				}else
				level[i][j] = new intersection();

			}
		}

		return level;
	}

}
