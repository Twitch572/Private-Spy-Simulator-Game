package core;
import processing.core.PVector;
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
	public class buildingdata{
		public final byte ADMINDESK = 0;
		public final byte LOBBY = 1;
		public final byte HR = 2;
		public final byte RND = 3;
		public final byte SURVEY = 4;
		public final room admin = new room(ADMINDESK,1);
		
		
        public class room{
        	private byte type;
        	private int level;
        	private room parent;
        	private byte phook;
        	private PVector root;
        	private final int width;
        	private final int height;
        	room(byte type,int level,room parent, byte hook){
        		this.type = type;
        		this.level = level;
        		this.parent = parent;
        		this.phook = hook;
        		this.width = getWidth(this.type,this.level);
        		this.height = getHeight(this.type,this.level);
        	}
        	room(byte type,int level){
        		if(type != ADMINDESK){System.exit(1);}
        		this.type = type;
        		this.level = level;
        		this.parent = null;
        		this.root = new PVector(0,0);
        		this.phook = 0;
        		this.width = getWidth(this.type,this.level);
        		this.height = getHeight(this.type,this.level);
        	}
			
		}
        public int getWidth(byte type, int level){
        	if(type == 0){return(320);}
        	switch(type){
        	case 1:
        		return(640);
        	case 2:
        		return(160);
        	case 3:
        		return(160);
        	case 4:
        		return(160);
        	}
        	return(0);
        }
		public int getHeight(byte type, int level){
			if(type == 0){return(160);}
        	switch(type){
        	case 1:
        		return(640);
        	case 2:
        		return(160);
        	case 3:
        		return(160);
        	case 4:
        		return(160);
        	}
        	return(0);
		}
	}
	public static void startGame(){
		Renderer.enterGameView();
	}
}
