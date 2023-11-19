package Schatz.game.entities.creatures;

import Schatz.game.Handler;
import Schatz.game.entities.Entity;
import Schatz.game.tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 1.6f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64, DEFAULT_CREATURE_WEIGHT = 10;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	protected Double lookX, lookY;

	protected boolean hit;
	protected float hitX = 0f;
	protected float hitY = 0f;

	protected float impulseX, impulseY;

	public Creature(Handler handler, float x, float y, int width, int height, double weight, float speed, int num) {
		super(handler, x, y, width, height, weight, "CREATURE" + num);
		health = DEFAULT_HEALTH;
		this.speed = speed;
		xMove = 0;
		yMove = 0;

		lookX = 0.0;
		lookY = 0.0;

	}

	public Creature(Handler handler, float x, float y, int width, int height, int Health, double weight, float Speed,
			int num) {
		super(handler, x, y, width, height, weight, "CREATURE" + num);
		health = Health;
		speed = Speed;
		xMove = 0;
		yMove = 0;
		lookX = 0.0;
		lookY = 0.0;
	}

	public void move() {
		xMove += impulseX / (weight);
		yMove += impulseY / (weight);
		impulseX *= weight / 20;
		impulseY *= weight / 20;

		if (lookX <= 0) {
			hitX = (float) ((Math.cos(Math.atan(lookY / lookX))) * 64 * 2)+32;
			hitY = (float) ((Math.sin(Math.atan(lookY / lookX))) * 64 * 2)+32;
		} else if (lookX >= 0) {
			hitX = (float) ((Math.cos(Math.atan(lookY / lookX))) * 64 * -2)+32;
			hitY = (float) ((Math.sin(Math.atan(lookY / lookX))) * 64 * -2)+32;
		}

		if (!checkEntityCollisions(xMove, 0f)) {
			moveX();
		} else {

		}
		if (!checkEntityCollisions(0f, yMove)) {
			moveY();
		} else {

		}

	}

	public void moveX() {

		if (xMove > 0) {// Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

				x += xMove;

			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}

		} else if (xMove < 0) {// moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

				x += xMove;

			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}

	@Override
	public boolean isDead() {
		return health < 0;
	}

	public void moveY() {

		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		} else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	public void attack() {

		for (Entity e : handler.getWorld().getEntManag().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			// if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(hitX, hitY)))
			// {

			// System.out.println("hit x" + hitX + " y" + hitY);
			// e.hit(hitX, hitY);

			// }

			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (8 / 8.), y + (hitY) * (8 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (7 / 8.), y + (hitY) * (7 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (6 / 8.), y + (hitY) * (6 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (5 / 8.), y + (hitY) * (5 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (4 / 8.), y + (hitY) * (4 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (3 / 8.), y + (hitY) * (3 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (2 / 8.), y + (hitY) * (2 / 8.))) {
				e.hit(hitX, hitY);
			}
			if (e.getCollisionBounds(0f, 0f).contains(x + (hitX) * (1 / 8.), y + (hitY) * (1 / 8.))) {
				e.hit(hitX, hitY);
			}
			//if (e.getCollisionBounds(0f, 0f).contains(x, y)) {
			//	e.hit(hitX, hitY);
			//}

		}

	}

	@Override
	public void hit(float changeX, float changeY) {

		impulseX += changeX;
		impulseY += changeY;
		health--;

	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// GETTERS and SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}

	public static float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}

}
