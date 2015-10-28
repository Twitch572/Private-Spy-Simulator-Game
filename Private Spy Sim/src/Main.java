import processing.core.*;
import core.*;
import processing.opengl.*;

public class Main extends PApplet {

	private static PlayerStatus player;
	private KeyHandler keyHandler;

	// Assets-----------
	PImage frame;
	PFont pixfont;
	PShader MenuBG;
	PImage ShaderTex;
	int[] winloc = new int[2];
	// -------------

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	// initialize everything in here
	public void setup() {
		
		ShaderTex = createImage(GameSettings.winx, GameSettings.winy, ARGB);
		background(90);
		player = new PlayerStatus();
		keyHandler = new KeyHandler(player);
		frame = loadImage("../assets/ui/folderframe.png");
		pixfont = createFont("../assets/ui/VCR_OSD_MONO.ttf", 28);
		MenuBG = loadShader("../assets/shaders/MenuFrag.glsl", "../assets/shaders/PixelVert.glsl");
		MenuBG.set("ar", (float) GameSettings.winy / (float) GameSettings.winx);
		winloc[0] = (GameSettings.winx - frame.width)/2; winloc[1] = 0;
	}

	public void settings() {
		size(GameSettings.winx, GameSettings.winy, P3D);
	}

	public void MainMenu() {
		ortho();
		shader(MenuBG);
		MenuBG.set("time", millis() / 1000.0f);
		textureMode(NORMAL);
		beginShape();
		texture(ShaderTex);
		vertex(0, 0, -9, 0.0f, 0.0f);
		vertex(GameSettings.winx, 0, -9, 1.0f, 0.0f);
		vertex(GameSettings.winx, GameSettings.winy, -9, 1.0f, 1.0f);
		vertex(0, GameSettings.winy, -9, 0.0f, 1.0f);
		endShape(CLOSE);
		resetShader();
		fill(0);
		image(frame, winloc[0], winloc[1]);
		textFont(pixfont);
		text("The Game", 236, 68);
	}
	public void BackgroundLayer(){
		ortho();
		background(60);
		/*shader(MenuBG);
		MenuBG.set("time", millis() / 1000.0f);
		textureMode(NORMAL);
		beginShape();
		texture(ShaderTex);
		vertex(0, 0, -9, 0.0f, 0.0f);
		vertex(GameSettings.winx, 0, -9, 1.0f, 0.0f);
		vertex(GameSettings.winx, GameSettings.winy, -9, 1.0f, 1.0f);
		vertex(0, GameSettings.winy, -9, 0.0f, 1.0f);
		endShape(CLOSE);
		resetShader();*/
		
	}
	public void BuildingLayer(){
		ortho();
	}
	// where the logic goes
	// loops at 60 fps
	public void draw() {
		//MainMenu();
		BackgroundLayer();
	}

	public void keyPressed() {
		if (keyHandler.changeBGcheck()) {
			// bg = loadImage("assets/tempbg2.jpg");
			return;
		}
		keyHandler.KeyPressed(key);
	}
}
