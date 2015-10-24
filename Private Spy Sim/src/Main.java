

import processing.core.*;
import core.*;
import processing.opengl.*;

public class Main extends PApplet{
	
	private static PlayerStatus player;
	private KeyHandler keyHandler;
	
	//Assets-----------
	PImage frame;
	PFont pixfont;
	PShader MenuBG;
	//-------------
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup() {
		background(90);
		player = new PlayerStatus();
		keyHandler = new KeyHandler(player);
		frame = loadImage("../assets/ui/folderframe.png");
		pixfont = createFont("../assets/ui/VCR_OSD_MONO.ttf",28);
		MenuBG = loadShader("../assets/shaders/MenuFrag.glsl","../assets/shaders/MenuVert.glsl");
	
	}
	public void settings() {
		  size(GameSettings.WIN_DIMENSIONS[0], GameSettings.WIN_DIMENSIONS[1],P3D);
	}
	
	//where the logic goes
	//loops at 60 fps
	public void draw() {
		fill(0);
		image(frame,(GameSettings.WIN_DIMENSIONS[0]-frame.width)/2,0);
		textFont(pixfont);
		text("The Game",236,68);
		shader(MenuBG);
		stroke(30);
		/*fill(180);
		beginShape();
		vertex(0,0,-1);
		vertex(GameSettings.WIN_DIMENSIONS[0],0,-9);
		vertex(GameSettings.WIN_DIMENSIONS[0],GameSettings.WIN_DIMENSIONS[1],-9);
		vertex(0,GameSettings.WIN_DIMENSIONS[1],-9);
		endShape(CLOSE);*/
	}
	
	public void keyPressed() {
		if (keyHandler.changeBGcheck()) {
			//bg = loadImage("assets/tempbg2.jpg");
			return;
		}
		keyHandler.KeyPressed(key);
	}
}
