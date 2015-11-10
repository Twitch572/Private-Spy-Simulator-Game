package core;

import processing.core.*;
import processing.opengl.*;

public class Renderer extends PApplet {
	PImage frame;
	PImage inGameBG;
	
	PFont pixfont;
	PShader MenuBG;
	PImage ShaderTex;
	int[] winloc = new int[2];
	int[][] roomloc;
	PImage menuFrame;
	
	private static int winx = GameSettings.winx;
	private static int winy = GameSettings.winy;
	private static float zoomlevel = 1.0f;
	private static PVector pan = new PVector(0,0);
	private static PVector basecs = new PVector(winx/2,winy/2);
	private static float rotationangle = 0.0f;
	
	public void setup() {		
		ShaderTex = createImage(winx, winy, ARGB);
		background(0);
		frame = loadImage("../assets/ui/folderframe.png");
		inGameBG = loadImage("../assets/backgrounds/IslandPSG.png");
		menuFrame = loadImage("../assets/ui/GameInterface.png");
		pixfont = createFont("../assets/ui/VCR_OSD_MONO.ttf", 28);
		MenuBG = loadShader("../assets/shaders/MenuFrag.glsl", "../assets/shaders/PixelVert.glsl");
		MenuBG.set("ar", (float) winy / (float) winx);
		winloc[0] = (winx - frame.width) / 2;
		winloc[1] = 0;
	}

	public void settings() {
		size(winx, winy, P3D);
	}
	
	public void draw() {
		switch(GameData.AppData.context){
		case 0:
			MainMenu();
			break;
		case 1:
			update();
			BackgroundLayer();
			MenuLayer();
			break;
		}
	}
	public void update() {
		GameData.PlayerData.update();
	}
	
	public static void enterGameView(){
		GameData.AppData.context = GameData.AppData.Game;
		
	}
	public static void incrZoom(boolean in){
		if(in & zoomlevel+GameSettings.zoomincr < 5.0f){
			zoomlevel+=GameSettings.zoomincr;
		} else if(zoomlevel-GameSettings.zoomincr > .1f){
			zoomlevel-=GameSettings.zoomincr;
		}
	}
	public static void setZoom(int in){
		if(in > .1f & in < 5.0f){
			zoomlevel = in;
		}
	}
	public static void moveview(int x, int y){
		PVector transformrec = new PVector(x, y).rotate(rotationangle);
		pan.add(transformrec);
	}

	private void MainMenu() {
		ortho();
		shader(MenuBG);
		MenuBG.set("time", millis() / 1000.0f);
		textureMode(NORMAL);
		beginShape();
		texture(ShaderTex);
		vertex(0, 0, -9, 0.0f, 0.0f);
		vertex(winx, 0, -9, 1.0f, 0.0f);
		vertex(winx, winy, -9, 1.0f, 1.0f);
		vertex(0, winy, -9, 0.0f, 1.0f);
		endShape(CLOSE);
		resetShader();
		fill(0);
		image(frame, winloc[0], winloc[1]);
		textFont(pixfont);
		text("The Game", 236, 68);
	}
	private void BackgroundLayer() {
		ortho();
		translate(basecs.copy().add(pan));
		image(inGameBG, -inGameBG.width/2, -inGameBG.height/2);
	}
	private void MenuLayer() {
		ortho();
		image(menuFrame, -GameSettings.winx/2-pan.x, -GameSettings.winy/2-pan.y);
	}
	private void translate(PVector in){
		translate(in.x,in.y);
	}
}
	

