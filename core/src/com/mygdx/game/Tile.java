package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

	public static final float SIZE = .9f;
	private Texture texture;
	private float speed;
	
	public Tile(Texture texture, float speed) {
		this.speed = speed;
		this.texture = texture;
	}

	public void render(SpriteBatch batch, float x, float y) {
		batch.draw(texture, x, y, Tile.SIZE, Tile.SIZE);
	}

	public float getSpeed() {
		return speed;
	}
	
	public boolean isObstacle() {
		return speed == 0;
	}
	
}
