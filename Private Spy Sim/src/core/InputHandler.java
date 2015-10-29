package core;

public class InputHandler {
	
	private PlayerStatus player;
	
	public InputHandler(PlayerStatus player) {
		this.player = player;
	}
	
	public void UniversalKeyPress(int keyCode) {
		switch(keyCode) {
		case 27: // escape pressed
			System.exit(0);
			break;
		}
	}
	public void MenuKeyPress(int keyCode) {
		switch(keyCode) {
		case 10: // escape pressed
			GameData.startGame();
			break;
		}
	}
	public void GameKeyPress(int keyCode) {
		switch(keyCode) {
		case 70: // escape pressed
			System.out.print("Center camera");
			break;
		}
	}
	public void GameScrollWheel(int dir){
		 if(dir < 0){ Renderer.incrZoom(true); }
		 else{Renderer.incrZoom(false);}
	}
	
}
