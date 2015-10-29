package core;

import processing.core.*;
import processing.opengl.*;

public class Renderer extends PApplet {
	PImage frame;
	PFont pixfont;
	PShader MenuBG;
	PImage ShaderTex;
	int[] winloc = new int[2];
	
	private static int winx = GameSettings.winx;
	private static int winy = GameSettings.winy;
	private static float zoomlevel = 1.0f;
	private static PVector pan = new PVector(0,0);
	private static PVector basecs = new PVector(winx/2,winy/2);
	private static float rotationangle = 0.0f;
	
	public void setup() {
		//basecs.set(winx/2,winy/2);
		ShaderTex = createImage(winx, winy, ARGB);
		background(90);
		frame = loadImage("../assets/ui/folderframe.png");
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
			BackgroundLayer();
			FloorLayer();
		}
	}
	
	public static void enterGameView(){
		GameData.AppData.context = GameData.AppData.Game;
		
	}
	public static void incrZoom(boolean in){
		if(in & zoomlevel+GameSettings.zoomincr < 5.0f){
			zoomlevel+=GameSettings.zoomincr;
			}
		else if(zoomlevel-GameSettings.zoomincr > .1f){
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
		background(50);
	}
	private void FloorLayer(){
		ortho();
		translate(basecs.copy().add(pan));
		rotateZ(rotationangle);
		fill(188);
		rect(-75*zoomlevel,-75*zoomlevel,150*zoomlevel,150*zoomlevel);
		rect(75*zoomlevel,-75*zoomlevel,150*zoomlevel,150*zoomlevel);
		rect(75*zoomlevel,75*zoomlevel,150*zoomlevel,150*zoomlevel);

	}
	private void translate(PVector in){
		translate(in.x,in.y);
	}
}
	

