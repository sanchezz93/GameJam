package com.mygdx.game;


import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	private static java.util.Map<String, Texture> textures = new HashMap<String, Texture>();
	
	private TextureManager() { }
	
	public static Texture getTexture(String path) {
		if(textures.containsKey(path)) {
			return textures.get(path);
		}
		
		Texture texture = new Texture(path); 
		textures.put(path, texture);
		return texture;
	}
	
}
