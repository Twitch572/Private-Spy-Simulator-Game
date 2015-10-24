
import processing.core.*;
import core.*;

public class Main extends PApplet{
	
	private PlayerStatus player;
	private KeyHandler keyHandler;
	private PImage bg;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup() {
		bg = loadImage("assets/tempbg.jpg");
		player = new PlayerStatus();
		keyHandler = new KeyHandler(player);
	}
	public void settings() {
		  size(500, 500);
	}
	
	//where the logic goes
	//loops at 60 fps
	public void draw() {
	    image(bg, 0, 0);
	}
	
	public void keyPressed() {
		keyHandler.KeyPressed(key);
	}
	
}
