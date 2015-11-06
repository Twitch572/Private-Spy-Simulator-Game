package core;

import java.util.ArrayList;

import missions.*;
import processing.core.PVector;

public class GameData {
	
	public static PlayerStatus PlayerData = new PlayerStatus();
	
	public GameData() {
		PlayerData.addMission(new AssassinateMission(3, 1));
	}
	
	public static BuildingData CurrentBD = new BuildingData();
	public static class AppData {
		public static int context = 0;
		public static final int MainMenu = 0;
		public static final int Game = 1;
	}

	public static class SaveData {
		public static String path = "./saves/save1.sv";
	}


	public static class BuildingData {
		public final static byte ADMINDESK = 0;
		public final static byte LOBBY = 1;
		public final static byte HR = 2;
		public final static byte RND = 3;
		public final static byte SURVEY = 4;
		public ArrayList<room> roomlist = new ArrayList<room>();
			BuildingData(){
				roomlist.add(new room(ADMINDESK, 1));
				roomlist.add(new room(HR, 1,roomlist.get(0),new byte[]{2,0}));
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
			public byte[] gridspace = new byte[3*16];

			room(byte type, int level, room parent, byte[] pcoord) {
				for(int i = 0; i < 3*16;i+=2){
						gridspace[i] = -1;
				}
				this.type = type;
				this.level = level;
				this.parent = parent;
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				this.root = getRoot(pcoord);
			}

			room(byte type, int level) {
				if (type != ADMINDESK) {
					System.out.println("Can't create room this way");
					System.exit(1);
				}
				this.type = type;
				this.level = level;
				this.parent = null;
				this.root= new PVector(0,0);
				this.width = getWidth(this.type, this.level);
				this.height = getHeight(this.type, this.level);
				
			}
			public PVector getRoot(byte[] pcoord){
				int x =0, y=0;
				if(this.parent.type == ADMINDESK){
					
				}
				else if(this.parent.type == LOBBY){

				}
				else if(this.parent.type == HR){
					
				}
				
				if(this.type == LOBBY){
					
				}
				else if(this.type == HR){
					this.gridspace[0]=pcoord[0];this.gridspace[1]=pcoord[1];
					this.gridspace[2] = this.type;
					
					x = pcoord[0]*160;
					y = pcoord[1]*160;
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
