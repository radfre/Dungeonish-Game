package Schatz.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Schatz.game.Handler;
import Schatz.game.entities.creatures.Creature;

public abstract class Entity {

	protected Handler handler;
	protected Creature creature;
	protected float x, y, dx, dy, dirx, diry;
	protected int width, height;
	protected Rectangle bounds;
	protected double weight;
	protected String Type;

	public Entity(Handler handler, float x, float y, int width, int height, double weight, String Type) {
		this.handler = handler;
		
		
		this.x = x;
		this.y = y;
		this.dy = 0;
		this.dx = 0;
		this.diry = 0;
		this.dirx = 0;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.Type = Type;

		bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public boolean checkEntityCollisions(float xOffset, float YOffset) {
		for (Entity e : handler.getWorld().getEntManag().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, YOffset))) {

				
					return true;
				
			}
		}
		return false;
	}

	
	
	
	public void hit(float changeX,float changeY) {
		
		
	
	}

	public Rectangle getCollisionBounds(float xOffset, float YOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + YOffset), bounds.width,
				bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setdx(float mx) {
		dx = mx;
	}

	public float getY() {
		return y;
	}
	public boolean isDead() {
		return false;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setdy(float my) {
		dy = my;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void changeX(float xMove) {
		x+=xMove;//dirx = (xMove + dirx) / 2;

	}

	public void changeY(float yMove) {
		y+=yMove;//diry = (yMove + diry) / 2;

	}

	public void getCreature() {

	}
}
