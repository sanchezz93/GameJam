package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen, InputProcessor {

	private SpriteBatch batch;
	private Map map;
	private OrthographicCamera camera;
	private Player player;
	private Pig pig;
	
	public static final int GAME_PAUSED = 0;
    public static final int GAME_PLAY = 1;
    public static final int GAME_MENU = 2;
    Character pauseChar= new Character(new Rectangle(.5f, 2f, 16f, 9f), new Texture("Images/paused.png"), null);
 
			
	private int gameStatus=1;
	
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
				
		player = new Player();
		pig = new Pig();
		
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
			pig.render(batch);
			player.render(batch);
			batch.end();
			break;
		}
	}

	public void update() {
		map.update();
		player.update(map);
		gameStatus = player.getGameStatus();
		pig.update(map);
		
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
