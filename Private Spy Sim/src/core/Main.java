package core;
import processing.core.*;
import agents.*;
import missions.*;

public class Main extends PApplet{
	
	private PlayerStatus player;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup() {
		background(0);
		player = new PlayerStatus();
	}
	public void settings() {
		  size(500, 500);
	}
	
	//where the logic goes
	//loops at 60 fps
	public void draw() {
	    stroke(255);
	    if (mousePressed) {
	      line(mouseX,mouseY,pmouseX,pmouseY);
	    }
	}
}
