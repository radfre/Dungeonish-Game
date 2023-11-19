package Schatz.game.entities.creatures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Schatz.game.Handler;
import Schatz.game.entities.Entity;
import Schatz.game.gfx.Animation;
import Schatz.game.gfx.Assets;

public class Player extends Creature {

	// Animations

	private Animation animDown, animUp, animLeft, animRight;

	public Player(Handler handler, float x, float y, int num) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 20, 2.5f, num);

		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;

		// Animations

		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		// Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
	

		lookX = (double) ((x - handler.getGameCamera().getxOffset()) - handler.getMouseManager().getMouseX())+32;
		lookY = (double) ((y - handler.getGameCamera().getYOffset()) - handler.getMouseManager().getMouseY())+32;

		if (hit)
			hit = false;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = +speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = +speed;

		if (handler.getMouseManager().isLeftPressed()) {

			attack();

		}

		setdx(xMove);
		setdy(yMove);

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getYOffset()), width, height, null);

		g.setColor(Color.RED);
		g.drawLine((int) (32+x - handler.getGameCamera().getxOffset()), 
				   (int) (32+y - handler.getGameCamera().getYOffset()),
				   (int) ((x -handler.getGameCamera().getxOffset()) + hitX),
				   (int) ((y -handler.getGameCamera().getYOffset()) + hitY));
	} 

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return Assets.player_down[0];
		}
	}
}
