import processing.core.*;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup() {
		background(0);
	}
	public void settings() {
		  size(200, 200);
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
