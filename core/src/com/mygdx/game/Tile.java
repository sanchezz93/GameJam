package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

	public static final float WIDTH = 1.12f, HEIGHT = .63f;
	private boolean isObstacle;
	private Texture texture;
	
	public Tile(boolean isObstacle) {
		this.setObstacle(isObstacle);
		if(isObstacle) {
			texture = new Texture("images/cuadro_Blanco.png");
		} else {
			texture = new Texture("images/cuadro_Negro.png");
		}
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}

	public void render(SpriteBatch batch, float x, float y) {
		batch.draw(texture, x, y, Tile.WIDTH, Tile.HEIGHT);
	}
	
}
