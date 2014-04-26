package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Character {

	private Rectangle rectangle;
	private Texture texture;
	private Vector2 speed;

	public Character(Rectangle rectangle, Texture texture) {
		this.rectangle = rectangle;
		this.texture = texture;
		speed = new Vector2();
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}
	
	public void update() {
		rectangle.x += speed.x * Gdx.graphics.getDeltaTime();
		rectangle.y += speed.y * Gdx.graphics.getDeltaTime();
	}
	
	protected Rectangle getRectangle() {
		return rectangle;
	}
	
	protected Vector2 getSpeed() {
		return speed;
	}
	
}
