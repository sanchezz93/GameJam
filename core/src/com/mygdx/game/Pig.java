package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Pig extends Character {

	public Pig() {
		super(new Rectangle(14, 2, Tile.SIZE, Tile.SIZE), new Texture("images/pig.png"));
	}
	
}
