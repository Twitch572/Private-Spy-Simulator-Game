package core;

import java.util.ArrayList;

import processing.core.PVector;

public class GameData {
	public static BuildingData CurrentBD = new BuildingData();
	public static class AppData {
		public static int context = 0;
		public static final int MainMenu = 0;
		public static final int Game = 1;
	}

	public static class SaveData {
		public static String path = "./saves/save1.sv";
	}

	public static PlayerStatus PlayerData = new PlayerStatus();

	public static class BuildingData {
		public final static byte ADMINDESK = 0;
		public final static byte LOBBY = 1;
		public final static byte HR = 2;
		public final static byte RND = 3;
		public final static byte SURVEY = 4;
		//public final static room admin = ;// Every game has a admin room placed at the root of the coordinate system
		//public final static room lobby = ;
		public ArrayList<room> roomlist = new ArrayList<room>();
			BuildingData(){
				roomlist.add(new room(ADMINDESK, 1));
				//roomlist.add(new room(LOBBY, 1,roomlist.get(0), (byte)21 ,(byte) 31));
				System.out.println(roomlist);
			}
		public static class room {
			public byte type;// Type of room, refer to list of constant ints in
								// parent class.
			public int level;// Level of the room, might effect size or shape.
			public room parent;// Reference to the room this room was built off
								// of
			public byte phook;// The hook on the parent which the room branches.
								// hook format uses the first digit to define the side
								// side of the room: 1 top, 2 right, 3 bottom, 4 left
								// the second digit counts along the side. The order goes
								// clockwise. So for the top hook on the left side of a 
								// lobby the hook would be 44. For rooms with only 1 hook on a
								// side the last digit is irrelevant. 
								// A value of 0 indicates no hook, as is the
								// case for the admin room
			
			public byte hook;
			
			public PVector root;// The root coordinates the room will be drawn
								// from
			public final int width;// The width of the rect that will draw the
									// room
			public final int height;// The height of the rect that will draw the
									// room
			private int[] ohooks = new int[8];

			room(byte type, int level, room parent, byte phook,byte hook) {
				this.type = type;
				this.level = level;
				this.parent = parent;
				this.phook = phook;
				this.phook = hook;
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				this.root = getRoot();
			}

			room(byte type, int level) {
				if (type != ADMINDESK) {
					System.out.println("Can't create room this way");
					System.exit(1);
				}
				this.type = type;
				this.level = level;
				this.parent = null;
				this.root= new PVector(-160,-80);
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				
			}
			public PVector getRoot(){
				this.parent.ohooks[0] = phook;
				byte pside = (byte)(this.phook/10);
				byte psh = (byte)(this.phook%10);
				if(this.parent.type == ADMINDESK){
					
				}
				return(new PVector(0,0));
			}

		}
		

		public static int getWidth(byte type, int level) {
			if (type == 0) {
				return (320);
			}
			switch (type) {
			case 1:
				return (640);
			case 2:
				return (160);
			case 3:
				return (160);
			case 4:
				return (160);
			}
			return (0);
		}

		public static int getHeight(byte type, int level) {
			if (type == 0) {
				return (160);
			}
			switch (type) {
			case 1:
				return (640);
			case 2:
				return (160);
			case 3:
				return (160);
			case 4:
				return (160);
			}
			return (0);
		}
	}

	public static void startGame() {
		Renderer.enterGameView();
	}
}
