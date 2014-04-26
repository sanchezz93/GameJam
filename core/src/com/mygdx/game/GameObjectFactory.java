package com.mygdx.game;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class GameObjectFactory {

	private GameObjectFactory() { }
	
	public static Map createMap(int id) {
		FileHandle handle = Gdx.files.internal("data/maps/" + id + ".txt");
		String text = handle.readString();
				
		try(Scanner scanner = new Scanner(text)) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			
			Tile tiles[][] = new Tile[rows][columns];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < rows; j++) {
					int k = scanner.nextInt();
					System.out.println(k);
					boolean isObstacle = k == 1 ? true : false;
					tiles[i][j] = new Tile(isObstacle);
				}
			}
			
			return new Map(tiles);
		}
	}
	
}
