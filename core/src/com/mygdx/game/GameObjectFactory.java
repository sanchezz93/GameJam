package com.mygdx.game;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class GameObjectFactory {

	private GameObjectFactory() { }
	
	public static Map createMap(int id) {
		FileHandle handle = Gdx.files.internal("data/maps/" + id + ".txt");
				
		try(Scanner scanner = new Scanner(handle.readString())) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			
			Tile tiles[][] = new Tile[rows][columns];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < rows; j++) {
					tiles[i][j] = createTile(scanner.nextInt());
				}
			}
			
			return new Map(tiles);
		}
	}
	
	public static Tile createTile(int id) {
		FileHandle handle = Gdx.files.internal("data/tiles/" + id + ".txt");
		
		try(Scanner scanner = new Scanner(handle.readString())) {
			String textureFileName = scanner.next();
			
			Texture texture = new Texture("Images/Tiles/" + textureFileName);

			float speed = scanner.nextFloat();
			
			return new Tile(texture, speed);
		}
	}
	
}
