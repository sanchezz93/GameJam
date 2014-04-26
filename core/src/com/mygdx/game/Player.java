package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Character implements InputProcessor {

	public Player() {
		super(new Rectangle(5, 4, Tile.WIDTH, Tile.HEIGHT), new Texture("images/player.png"));
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Input.Keys.D:
			getSpeed().x = 3;
			return true;
		case Input.Keys.A:
			getSpeed().x = -3;
			return true;
		case Input.Keys.W:
			getSpeed().y = -3;
			return true;
		case Input.Keys.S:
			getSpeed().y = 3;
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
		}
		
		return false;
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

}
