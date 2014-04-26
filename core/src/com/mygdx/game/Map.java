package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {

	private Tile[][] tiles;
	
	public Map(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public void render(SpriteBatch batch) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].render(batch, j*Tile.SIZE, i*Tile.SIZE);
			}
		}
	}
	
	public Tile getTile(int row, int column){
		return this.tiles[row][column];
	}
	

	public void update() {
		
	}
	
}
