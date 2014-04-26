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
	
	public void update(Map map) {
		move(speed.cpy().scl(Gdx.graphics.getDeltaTime()), map);
	}
	
	public void move(Vector2 vector, Map map) {
		
	}
	
	protected Rectangle getRectangle() {
		return rectangle;
	}
	
	protected Vector2 getSpeed() {
		return speed;
	}
	
	
	
}
