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
		if(aiCounter == 40) {
			aiCounter = 0;
			ai(map);
		}
	}
	
	public void ai(Map map) {
		int bestRow = 0, bestCol = 0;
		for(int i = 0; i < map.rows; i++) {
			for(int j = 0; j < map.columns; j++) {
				if(getRank(i, j, player) > getRank(bestRow, bestCol, player)) {
					bestRow = i;
					bestCol = j;
				}
			}
		}
		goToTile(bestRow, bestCol);
	}
	
	private double getRank(int row, int col, Player player) {
		
		double dx1 = player.getRectangle().x + player.getRectangle().width/2 - getRectangle().x - getRectangle().width/2;
		double dy1 = player.getRectangle().y + player.getRectangle().height/2 - getRectangle().y - getRectangle().height/2;
		double dx2 = col * Tile.SIZE + Tile.SIZE/2 - getRectangle().x - getRectangle().width/2;
		double dy2 = row * Tile.SIZE + Tile.SIZE/2 - getRectangle().y - getRectangle().height/2;
		
		Vector2 v1 = new Vector2((float) dx1, (float) dy1);
		Vector2 v2 = new Vector2((float) dx2, (float) dy2);
		
		return distanceTo(player, row, col) / (v1.dot(v2));
	}
	
	private double distanceTo(Player player, int row, int col) {
		double dx = (col * Tile.SIZE + Tile.SIZE/2) - player.getRectangle().x;
		double dy = (row * Tile.SIZE + Tile.SIZE/2) - player.getRectangle().y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public void goToTile(int row, int column) {
		Vector2 direction = new Vector2((column * Tile.SIZE + Tile.SIZE/2) - getRectangle().x, (row * Tile.SIZE + Tile.SIZE/2) - getRectangle().y);
		getSpeed().set(direction.nor().scl(2));
	}
	
	

}
