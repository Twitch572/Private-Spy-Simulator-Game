
import processing.core.*;
import core.*;

public class Main extends PApplet{
	
	private PlayerStatus player;
	private KeyHandler keyHandler;
	
	//Assets-----------
	PImage frame;
	PFont pixfont;
	//-------------
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup() {
		background(0);
		player = new PlayerStatus();
		keyHandler = new KeyHandler(player);
		frame = loadImage("../assets/ui/folderframe.png");
		pixfont = createFont("../assets/ui/VCR_OSD_MONO.ttf",28);
	}
	public void settings() {
		  size(GameSettings.WIN_DIMENSIONS[0], GameSettings.WIN_DIMENSIONS[1],P2D);
	}
	
	//where the logic goes
	//loops at 60 fps
	public void draw() {
		image(frame,(GameSettings.WIN_DIMENSIONS[0]-frame.width)/2,0);
		textFont(pixfont);
		text("The Game",236,68);
		fill(0);
	}
	
	public void keyPressed() {
		keyHandler.KeyPressed(key);
	}
}
