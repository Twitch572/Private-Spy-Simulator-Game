import processing.core.*;
import processing.event.MouseEvent;
import core.*;

public class Main extends Renderer {

	private static PlayerStatus player = new PlayerStatus();
	private static InputHandler inputHandler = new InputHandler(player);
	
	public static void main(String[] args) {
		PApplet.main("Main");
		while (true){ //Might seem sketchy, but processing's environment automatically kills the program on close or call to exit() so to decouple the game from the graphics this is ok.
		
		}
	}
	
	public void keyPressed(){
		inputHandler.UniversalKeyPress(key);
		switch(GameData.AppData.context){
		case GameData.AppData.MainMenu:
			inputHandler.MenuKeyPress(key);
		case GameData.AppData.Game:
			inputHandler.GameKeyPress(key);
		}
	}
	public void mouseWheel(MouseEvent event){
		int e = event.getCount();
		//System.out.println(e);
		inputHandler.GameScrollWheel(e);
	}
	public void mouseDragged(MouseEvent event){
		Renderer.moveview(mouseX-pmouseX,mouseY-pmouseY);
	}

	// initialize everything in here

}
