package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Pig extends Character {

	private Player player;
	int aiCounter;
	
	public Pig(Player player) {
		super(new Rectangle(14, 2, Tile.SIZE, Tile.SIZE), new Texture("Images/pig.png"), getAnimation());
		this.player = player;
	}
	
	private static Animation getAnimation() {
		TextureRegion frames[] = new TextureRegion[1];
		
		frames[0] = new TextureRegion(new Texture("Images/pig.png"));
		
		return new Animation(.1f, frames);
	}
	
	public void update(Map map) {
		super.update(map);
		aiCounter++;
		if(aiCounter == 200) {
			aiCounter = 0;
			int maxRow = 0, maxCol = 0;
			for(int i = 0; i < map.rows; i++) {
				for(int j = 0; j < map.columns; j++) {
					if(distanceTo(i, j) > distanceTo(maxRow, maxCol)) {
						maxRow = i;
						maxCol = j;
					}
				}
			}
			goToTile(maxRow, maxCol);
		}
	}
	
	private double distanceTo(int row, int col) {
		double dx = (col * Tile.SIZE + Tile.SIZE/2) - getRectangle().x;
		double dy = (row * Tile.SIZE + Tile.SIZE/2) - getRectangle().y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public void goToTile(int row, int column) {
		Vector2 direction = new Vector2((column * Tile.SIZE + Tile.SIZE/2) - getRectangle().x, (row * Tile.SIZE + Tile.SIZE/2) - getRectangle().y);
		getSpeed().set(direction.nor().scl(3));
	}
	
	

}
