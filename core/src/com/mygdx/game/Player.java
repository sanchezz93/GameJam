package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Character implements InputProcessor {
	
	private float speed;
	private int gameStatus=1;
	
	public Player() {
		super(new Rectangle(8, 6, Tile.SIZE, Tile.SIZE), new Texture("Images/player/1.png"), getAnimation());
	}

	private static Animation getAnimation() {
		TextureRegion frames[] = new TextureRegion[6];
		
		for(int i = 1; i <= 6; i++) {
			frames[i-1] = new TextureRegion(new Texture("Images/player/" + i + ".png"));
		}
		
		return new Animation(.1f, frames);
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Input.Keys.D:
			getSpeed().x = 1;
			return true;
		case Input.Keys.A:
			getSpeed().x = -1;
			return true;
		case Input.Keys.W:
			getSpeed().y = -1;
			return true;
		case Input.Keys.S:
			getSpeed().y = 1;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Input.Keys.D:
			getSpeed().x = 0;
			return true;
		case Input.Keys.A:
			getSpeed().x = 0;
			return true;
		case Input.Keys.W:
			getSpeed().y = 0;
			return true;
		case Input.Keys.S:
			getSpeed().y = 0;
			return true;
		case Input.Keys.P:
			this.setGameStatus(0);
			return true;
		case Input.Keys.L:
			this.setGameStatus(1);
			return true;
		}
		
		return false;
	}

	@Override
	public void update(Map map) {
		super.update(map);
		int tileRow = (int) ((getRectangle().y) / Tile.SIZE);
		int tileCol = (int) ((getRectangle().x) / Tile.SIZE);
		speed = map.getTile(tileRow, tileCol).getSpeed();
		getSpeed().nor().scl(speed);
	}

	@Override
	public void move(Vector2 vector, Map map) {
		super.move(vector, map);
		
		if(getRectangle().x - getRectangle().width/4 < 0 || getRectangle().x + getRectangle().width/4 > map.columns * Tile.SIZE) {
			getRectangle().x -= vector.x;
		}
		
		if(getRectangle().y - getRectangle().height/4 < 0 || getRectangle().y + getRectangle().height/4 > map.rows * Tile.SIZE) {
			getRectangle().y -= vector.y;
		}
		
//		int ix;
//		int jx;
//		if(vector.x >= 0){
//			ix = 1;
//		} else ix = -1;
//		if(vector.y >= 0){
//			jx = 1;
//		} else jx = -1;
//		
//
//		while(map.getTile( 
//				(int) ((getRectangle().y + getRectangle().height/4f * ix)/Tile.SIZE), 
//				(int) ((getRectangle().x + getRectangle().width/4f * jx)/Tile.SIZE)).isObstacle()){
//			getRectangle().x -= vector.x;//* ix;
//			getRectangle().y -= vector.y;// * jx;
//		}


		if(map.getTile( (int) (getRectangle().y/Tile.SIZE), (int) (getRectangle().x/Tile.SIZE)).isObstacle()){
			getRectangle().x -= vector.x;
			getRectangle().y -= vector.y;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public int getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(int gameStatus) {
		this.gameStatus = gameStatus;
	}

}
