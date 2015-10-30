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
				roomlist.add(new room(LOBBY, 1,roomlist.get(0), (byte)20 ,(byte) 41));
				roomlist.add(new room(LOBBY, 1,roomlist.get(1), (byte)33 ,(byte) 13));
				System.out.println(roomlist);
			}			
/*
  _____                                                                _                                 _                                                     _                _                         _                       _              _         _______                                 _                         _                                               _ 
 |  __ \                                                              | |                               | |                                                   | |              | |                       | |                     (_)            | |       |__   __|                               | |                       | |                                             | |
 | |  | |   __ _   _ __     __ _    ___   _ __    ___    _   _   ___  | |  _   _     _   _   _ __     __| |   ___     ___   _   _   _ __ ___     ___   _ __   | |_    ___    __| |     __ _   _ __     __| |   __      __   ___   _   _ __    __| |          | |     _ __    __ _  __   __   ___  | |   ___   _ __   ___    | |__     ___  __      __   __ _   _ __    ___  | |
 | |  | |  / _` | | '_ \   / _` |  / _ \ | '__|  / _ \  | | | | / __| | | | | | |   | | | | | '_ \   / _` |  / _ \   / __| | | | | | '_ ` _ \   / _ \ | '_ \  | __|  / _ \  / _` |    / _` | | '_ \   / _` |   \ \ /\ / /  / _ \ | | | '__|  / _` |          | |    | '__|  / _` | \ \ / /  / _ \ | |  / _ \ | '__| / __|   | '_ \   / _ \ \ \ /\ / /  / _` | | '__|  / _ \ | |
 | |__| | | (_| | | | | | | (_| | |  __/ | |    | (_) | | |_| | \__ \ | | | |_| |   | |_| | | | | | | (_| | | (_) | | (__  | |_| | | | | | | | |  __/ | | | | | |_  |  __/ | (_| |   | (_| | | | | | | (_| |    \ V  V /  |  __/ | | | |    | (_| |  _       | |    | |    | (_| |  \ V /  |  __/ | | |  __/ | |    \__ \   | |_) | |  __/  \ V  V /  | (_| | | |    |  __/ |_|
 |_____/   \__,_| |_| |_|  \__, |  \___| |_|     \___/   \__,_| |___/ |_|  \__, |    \__,_| |_| |_|  \__,_|  \___/   \___|  \__,_| |_| |_| |_|  \___| |_| |_|  \__|  \___|  \__,_|    \__,_| |_| |_|  \__,_|     \_/\_/    \___| |_| |_|     \__,_| (_)      |_|    |_|     \__,_|   \_/    \___| |_|  \___| |_|    |___/   |_.__/   \___|   \_/\_/    \__,_| |_|     \___| (_)
                            __/ |                                           __/ |                                                                                                                                                                                                                                                                                              
                           |___/                                           |___/                                                                                                                                                                                                                                                                                               		 
*/
			public static class room {
			public byte type;
			public int level;
			public room parent;
			public PVector root;
			public final int width;
			public final int height;
			private int[] ohooks = new int[8];

			room(byte type, int level, room parent, byte phook,byte hook) {
				this.type = type;
				this.level = level;
				this.parent = parent;
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				this.parent.ohooks[0] = phook;
				this.ohooks[0] = hook;
				this.root = getRoot(phook, hook);
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
			public PVector getRoot(byte phook, byte hook){
				int x =0, y=0;
				PVector phcoord = new PVector(0,0);
				byte pside = (byte)(phook/10);
				byte psh = (byte)(phook%10);
				byte side = (byte)(hook/10);
				byte sh = (byte)(hook%10);
				if(this.parent.type == ADMINDESK){
					switch(pside){
					case 2: 
						phcoord.set((int)this.parent.root.x+this.parent.width,(int)this.parent.root.y+this.parent.height/2);
						break;
					case 4:
						phcoord.set((int)this.parent.root.x,(int)this.parent.root.y+this.parent.height/2);
						break;
					}
				}
				else if(this.parent.type == LOBBY){
					switch(pside){
					case 1:
						phcoord.set(this.parent.root.x + ((psh+1)*this.parent.width/4)-this.parent.width/8,this.parent.root.y);
						break;
					case 2: 
						phcoord.set(this.parent.root.x+this.width,this.parent.root.y + ((psh+1)*this.parent.height/4)-this.parent.height/8);
						break;
					case 3:
						phcoord.set(this.parent.root.x /*+ ((psh)*this.parent.width/4)-this.parent.width/8*/,this.parent.root.y+this.parent.height);
						break;
					case 4:
						phcoord.set(this.parent.root.x+this.width,this.parent.root.y + ((psh+1)*this.parent.height/4)-this.parent.height/8);
						break;
					}
				}
				
				if(this.type == LOBBY){
					
					switch(side){
					case 1:
						x  = (int)phcoord.x - (sh*this.width/4)-this.width/8;
						y = (int)phcoord.y;
						break;
					case 2:
						x = (int)phcoord.x-this.width;
						y = -(int)phcoord.y - (sh*this.height/4)-this.height/8;
						break;
					case 3:
						x  = (int)phcoord.x - ((3-sh)*this.width/4)-this.width/8;
						y = (int)phcoord.y-this.height;
						break;
					case 4:
						x = (int)phcoord.x;
						y = (int)phcoord.y - ((3-sh)*this.height/4)-this.width/8;
						break;

					}
				}
				return(new PVector(x,y));
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
