public class Room {
	
	/**
	 * the display state for a room
	 *
	 */
	public enum roomState{
		ROOM, MENU, ACTION;
	}
	
	/**
	 * this holds the types of tiles a room can have
	 * for example, it can have a floor, walls, doors,etc
	 *
	 */
	public enum roomTile{
		FLOOR, WALL;
	}
	
	/**
	 * the types of floor
	 *
	 */
	public enum floorType{
		WOOD, LAMINATE, TILE;
	}
	
	private Point topLeft, botRight;
	private String floorType;
	private roomTile[][] roomDisplay; 
	private roomState state;
	

	public Room(Point topLeft, Point botRight, String floorType)
	{
		this.topLeft = topLeft;
		this.botRight = botRight;
		this.floorType = floorType;
		this.state = roomState.ROOM;
	}
	
	/**
	 * assigns the tiles to the room 
	 */
	public void makeRoom()
	{
		for(int x = topLeft.x; x < botRight.x; x++)
		{
			for(int y = topLeft.y; y < botRight.y; y++)
			{
				if(x == topLeft.x || x == (botRight.x-1) || y == topLeft.y || y == (botRight.y-1))
				{
					roomDisplay[x][y] = roomTile.WALL;
				}
				else
				{
					roomDisplay[x][y] = roomTile.FLOOR;
				}
			}
		}
	}
	
	/**
	 * draws out the room
	 */
	public void displayRoom()
	{
		for(int x = topLeft.x; x < botRight.x; x++)
		{
			for(int y = topLeft.y; y < botRight.y; y++)
			{
				if(roomDisplay[x][y].equals(roomTile.FLOOR))
				{
					if(floorType.equals("wood"))
					{
						
					}
					else
					{
						
					}
				}
			}
		}
	}
	
	public void display()
	{
		switch(state)
		{
		case ROOM: //show the room
			display()
			if(clicked)
				state = roomState.MENU;
			break;
		case MENU: //show the menu for the room			
			runMenu()
			if(clicked)
				state = roomState.ACTION;
			break;
		case ACTION: //run the appropriate action from a menu option
			if(Action.done())
			{
				state = roomState.ROOM;
			}
			break;
		default:
			System.out.println("WTF!!!!!");
			break;
		}
		
	}
	

}
