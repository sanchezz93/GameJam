package com.mygdx.game;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Animation {

	private int frameCount;
	private Texture idle;
	private float durations[];
	
	public Animation(String path) {
		
		FileHandle handle = Gdx.files.internal(path + "/frames.txt");
		try(Scanner scanner = new Scanner(handle.readString())) {
			frameCount = scanner.nextInt();
			
		}
		
	}
	
}
