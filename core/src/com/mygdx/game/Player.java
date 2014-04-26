package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Player extends Character implements InputProcessor {
	
	private float speed;
	private int gameStatus=1;
	private OrthographicCamera camera;
	
	public Player(OrthographicCamera camera) {
		super(new Rectangle(8, 6, 1, 1), TextureManager.getTexture("Images/player/1.png"), getAnimation());
		this.camera = camera;
	}

	private static Animation getAnimation() {
		TextureRegion frames[] = new TextureRegion[6];
		
		for(int i = 1; i <= 6; i++) {
			frames[i-1] = new TextureRegion(TextureManager.getTexture("Images/player/" + i + ".png"));
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
		getSpeed().nor().scl(speed);
		super.update(map);
		int tileRow = (int) ((getRectangle().y) / Tile.SIZE);
		int tileCol = (int) ((getRectangle().x) / Tile.SIZE);
		speed = map.getTile(tileRow, tileCol).getSpeed();
		getSpeed().nor().scl(speed);
	}

	@Override
	public void move(Vector2 vector, Map map) {
		super.move(vector, map);
		
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
		Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
		Vector3 v = camera.unproject(worldCoordinates);
		
		getSpeed().x = v.x - getRectangle().x;
		getSpeed().y = v.y - getRectangle().y;
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		getSpeed().x = 0;
		getSpeed().y = 0;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
		Vector3 v = camera.unproject(worldCoordinates);
		
		getSpeed().x = v.x - getRectangle().x;
		getSpeed().y = v.y - getRectangle().y;
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
