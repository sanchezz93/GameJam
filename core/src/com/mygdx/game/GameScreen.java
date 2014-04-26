package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen, InputProcessor {

	private SpriteBatch batch;
	private Map map;
	private OrthographicCamera camera;
	
	public GameScreen(Map map) {
		batch = new SpriteBatch();
		this.map = map;
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 16, 9);
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render(float delta) {
		update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		map.render(batch);
		batch.end();
	}
	
	public void update() {
		map.update();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		Vector2 vector = new Vector2();
		switch(keycode) {
		case Input.Keys.RIGHT:
			vector.x += .5;
			break;
		case Input.Keys.LEFT:
			vector.x -= .5;
			break;
		case Input.Keys.UP:
			vector.y -= .5;
			break;
		case Input.Keys.DOWN:
			vector.y += .5;
			break;
		}
		
		camera.translate(vector);
		camera.update();
		
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
