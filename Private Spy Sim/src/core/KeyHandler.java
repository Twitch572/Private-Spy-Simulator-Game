package core;

public class KeyHandler {
	
	private PlayerStatus player;
	
	public KeyHandler(PlayerStatus player) {
		this.player = player;
	}
	
	public void KeyPressed(int keyCode) {
		switch(keyCode) {
		case 27:
			System.exit(0);
		}
	}

}
