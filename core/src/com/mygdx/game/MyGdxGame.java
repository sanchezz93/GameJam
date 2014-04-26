package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends Game {
	public enum GameState {
		GAME_PAUSED, GAME_PLAYING, GAME_MENU 
	}
	GameState gameState = GameState.GAME_PLAYING;

	@Override
	public void create () {
		switch (gameState){
		case GAME_PAUSED:
			break;
		case GAME_PLAYING:
			setScreen(new GameScreen(GameObjectFactory.createMap(1)));
			break;
		case GAME_MENU:
			setScreen(new MenuScreen());
		}

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		getScreen().render(Gdx.graphics.getDeltaTime());
	}
}
