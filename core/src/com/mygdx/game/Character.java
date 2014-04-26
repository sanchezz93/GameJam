package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Character {

	private Rectangle rectangle;
	private Sprite sprite;
	private Vector2 speed;
	private Animation animation;
	private float stateTime;

	public Character(Rectangle rectangle, Texture texture, Animation animation) {
		this.rectangle = rectangle;
		this.sprite = new Sprite(texture);
		this.animation = animation;
		speed = new Vector2();
	}
	
	public void render(SpriteBatch batch) {
		
		if(speed.equals(Vector2.Zero)) {
			sprite.setOrigin(rectangle.width/2, rectangle.height/2);
			sprite.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
			sprite.draw(batch);
		} else {
			sprite.setRotation((float) Math.toDegrees(Math.atan2(speed.y, speed.x)) + 90);
	        stateTime += Gdx.graphics.getDeltaTime();
			Sprite frame = new Sprite(animation.getKeyFrame(stateTime, true));
			frame.setOrigin(rectangle.width/2, rectangle.height/2);
			frame.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
			frame.setRotation((float) Math.toDegrees(Math.atan2(speed.y, speed.x)) + 90);
			frame.draw(batch);
		}
		
	}
	
	public void update(Map map) {
		move(speed.cpy().scl(Gdx.graphics.getDeltaTime()), map);
	}
	
	public void move(Vector2 vector, Map map) {
		rectangle.x += vector.x;
		rectangle.y += vector.y;
	}
	
	protected Rectangle getRectangle() {
		return rectangle;
	}
	
	protected Vector2 getSpeed() {
		return speed;
	}
	
	
	
}
