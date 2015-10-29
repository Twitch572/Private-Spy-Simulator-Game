package core;

import java.util.ArrayList;

import core.GameData.BuildingData.room;
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
				roomlist.add(new room(LOBBY, 1,roomlist.get(0),(byte) 3));
				System.out.println(roomlist);
			}
		public static class room {
			public byte type;// Type of room, refer to list of constant ints in
								// parent class.
			public int level;// Level of the room, might effect size or shape.
			public room parent;// Reference to the room this room was built off
								// of
			public byte phook;// The hook on the parent which the room branches
								// from. 0 is none, 1 is top, 2 right, 3 bottom,
								// 4 left
			public PVector root;// The root coordinates the room will be drawn
								// from
			public final int width;// The width of the rect that will draw the
									// room
			public final int height;// The height of the rect that will draw the
									// room

			room(byte type, int level, room parent, byte hook) {
				this.type = type;
				this.level = level;
				this.parent = parent;
				this.phook = hook;
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				this.root = new PVector(160, -240);
			}

			room(byte type, int level) {
				if (type != ADMINDESK) {
					System.out.println("Can't create room this way");
					System.exit(1);
				}
				this.type = type;
				this.level = level;
				this.parent = null;
				this.root = new PVector(-160, -80);
				this.phook = 0;
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
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
