package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen, InputProcessor {

	private SpriteBatch batch;
	private Map map;
	private OrthographicCamera camera;
	private Player player;
	private List<Pig> drove;
	
	public static final int PIG_COUNT = 50;
	
	public static final int GAME_PAUSED = 0;
    public static final int GAME_PLAY = 1;
    public static final int GAME_MENU = 2;
    Character pauseChar = new Character(new Rectangle(.5f, 2f, 16f, 9f), TextureManager.getTexture("Images/paused.png"), null);
			
	private int gameStatus = 1;
	private int score = 0;
	
    public int getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(int gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	
	public GameScreen(Map map) {
		batch = new SpriteBatch();
		this.map = map;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 16, 9);
				
		player = new Player(camera);
		
		drove = new ArrayList<>();
		
		Random random = new Random();
		for(int i = 0; i < PIG_COUNT; i++) {
			drove.add(new Pig(player, random.nextInt(15) + 1, random.nextInt(7) + 1));
		}
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this);
		multiplexer.addProcessor(player);
		Gdx.input.setInputProcessor(multiplexer);
	}
	
	@Override
	public void render(float delta) {
		update();
		switch(gameStatus){
		case(GAME_MENU):
		case(GAME_PAUSED):
			Gdx.gl.glClearColor(0, 0, 0, 1);
			String pause="Paused.";
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			pauseChar.render(batch);
			batch.end();
			break;
			
		case(GAME_PLAY):
			
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			map.render(batch);
			for(Pig pig: drove) {
				pig.render(batch);
			}
			player.render(batch);
			batch.end();
			break;
		}
	}

	public void update() {
		map.update();
		player.update(map);
		gameStatus = player.getGameStatus();
		
		Iterator<Pig> it = drove.iterator();
		while(it.hasNext()) {
			Pig pig = it.next();
			pig.update(map);
			if(pig.grab()) {
				score++;
				it.remove();
			}
		}
		
		if(player.getRectangle().x + camera.viewportWidth/2 < map.columns * Tile.SIZE &&
		   player.getRectangle().x - camera.viewportWidth/2 >= 0) {
			camera.position.x = player.getRectangle().x + player.getRectangle().width/2;
		}
		if(player.getRectangle().y + camera.viewportHeight/2 < map.rows * Tile.SIZE &&
		   player.getRectangle().y - camera.viewportHeight/2 >= 0) {
			camera.position.y = player.getRectangle().y + player.getRectangle().height/2;
		}
		camera.update();
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
		pauseGame();
		
	}

	private void pauseGame() {
		gameStatus=GAME_PAUSED;
		
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
