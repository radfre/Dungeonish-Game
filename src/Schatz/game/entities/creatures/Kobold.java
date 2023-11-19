package Schatz.game.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Schatz.game.Handler;
import Schatz.game.gfx.Animation;
import Schatz.game.gfx.Assets;

public class Kobold extends Creature {

	// Animations

	private Animation animDown, animUp, animLeft, animRight;
	private double time1 = 0, time2 = 20, time3 = 9, time4 = 0;
	private float goingX = 0f, goingY = 0f;

	public Kobold(Handler handler, float x, float y, int num) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH - 8, Creature.DEFAULT_CREATURE_HEIGHT - 8, 5, 5, 2.75f,
				num);

		bounds.x = 16;
		bounds.y = 16;
		bounds.width = 32;
		bounds.height = 32;

		// Animations

		animDown = new Animation(200, Assets.kobold_down);
		animUp = new Animation(200, Assets.kobold_up);
		animLeft = new Animation(200, Assets.kobold_left);
		animRight = new Animation(200, Assets.kobold_right);
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
		// handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		lookX = (double) (handler.getWorld().getEntManag().getPlayer().getX() - x);
		lookY = (double) (handler.getWorld().getEntManag().getPlayer().getY() - y);

		if (hit) {
			hit = false;
			time1 = time2;
		}
		if ((Math
				.sqrt(Math.pow(handler.getWorld().getEntManag().getPlayer().getX() - x, 2)
						+ Math.pow(handler.getWorld().getEntManag().getPlayer().getY() - y, 2)) < 128
				&& time3 - 40 > 0)) {
			time3 = 0;
			//attack();
		}

		if (time1 >= time2) {
			if ((Math.sqrt(Math.pow(handler.getWorld().getEntManag().getPlayer().getX() - x, 2)
					+ Math.pow(handler.getWorld().getEntManag().getPlayer().getY() - y, 2)) < 32 * 10)) {
				if (handler.getWorld().getEntManag().getPlayer().getX() - x == 0) {
					goingX = 0;
				} else if (handler.getWorld().getEntManag().getPlayer().getX() - x > 0) {
					goingX = speed;
				} else {
					goingX = -speed;
				}

				if (handler.getWorld().getEntManag().getPlayer().getY() - y == 0) {
					goingY = 0;
				} else if (handler.getWorld().getEntManag().getPlayer().getY() - y > 0) {
					goingY = speed;
				} else {
					goingY = -speed;
				}
				time1 = 0;
				time2 = (int) ((Math.random() * 60)) + 40;

			} else {
				goingX = (int) ((Math.random() * speed * 2) - speed);
				goingY = (int) ((Math.random() * speed * 2) - speed);
				time1 = 0;
				time2 = (int) ((Math.random() * 60)) + 60;
			}
		} else {
			time1++;
			time3++;
			// time2 = (int) ((Math.random() * 30)) + 60;
		}

		xMove += goingX;
		yMove += goingY;
		setdx(xMove);
		setdy(yMove);

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getYOffset()), width, height, null);

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
			return Assets.kobold_down[0];
		}
	}
}
