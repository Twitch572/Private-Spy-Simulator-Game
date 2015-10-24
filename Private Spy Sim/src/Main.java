import processing.core.*;

public class Main extends PApplet{
	
	private Room testRoom;

	public static void main(String[] args)
	{
		PApplet.main("Main");
	}

	//initialize everything in here
	public void setup()
	{
		testRoom = new Room(new Point(10,10,0), new Point(50,50,0), "Wood");
			
	}
	public void settings() {
		  size(200, 200);
	}
	
	//where the logic goes
	//loops as fast as it can
	public void draw()
	{

	    stroke(255);
	    if (mousePressed) {
	      line(mouseX,mouseY,pmouseX,pmouseY);
	    }
	    //returns things to be displayed here
	    testRoom.display();
	}
}
