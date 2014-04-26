package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Pig extends Character {

	public Pig() {
		super(new Rectangle(14, 2, Tile.WIDTH, Tile.HEIGHT), new Texture("images/pig.png"));
	}
	
}
