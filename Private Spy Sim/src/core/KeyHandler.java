package core;

public class KeyHandler {
	
	private PlayerStatus player;
	
	public KeyHandler(PlayerStatus player) {
		this.player = player;
	}
	
	public void KeyPressed(int keyCode) {
		switch(keyCode) {
		case 10: // enter pressed
			if (player.activeScreen == GameSettings.TITLE_SCREEN) {
				player.activeScreen = GameSettings.IN_GAME_SCREEN;
			}
			break;
		case 27: // escape pressed
			System.exit(0);
			break;
		}
	}

	public boolean changeBGcheck() {
		return true;
	}
	
}
