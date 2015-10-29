package core;

public class GameData {
	public static class AppData{
	public static int context = 0;
	public static final int MainMenu = 0;
	public static final int Game = 1;
	}
	public static class SaveData{
		public static String path = "./saves/save1.sv";
	}
	public static PlayerStatus PlayerData = new PlayerStatus();
	public static class buildingdata{
		
		
	}
	public static void startGame(){
		Renderer.enterGameView();
	}
}
