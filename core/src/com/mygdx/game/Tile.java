package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

	public static final float SIZE = 1f;
	private boolean isObstacle;
	private Texture texture;
	
	public Tile(boolean isObstacle) {
		this.setObstacle(isObstacle);
		if(isObstacle) {
			texture = new Texture("images/rocks.png");
		} else {
			texture = new Texture("images/grass.png");
		}
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}

	public void render(SpriteBatch batch, float x, float y) {
		batch.draw(texture, x, y, Tile.SIZE, Tile.SIZE);
	}
	
}
