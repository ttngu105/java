public  class Room
{
//instance variables
private String description;
private Room north;
private Room east;
private Room west;
private Room south;
private Room currentRoom;
private Monster monster;
private Items items;

	//consturctor
	public Room(String desc)

		{
			this.description = desc;
		}		

	//setters
	public void setNorth(Room north)
	
		{
			this.north = north;
		}

	public void setSouth(Room south)
	
		{
			this.south = south;
		}

	public void setEast(Room east)
	
		{
			this.east = east;
		}

	public void setWest(Room west)
	
		{
			this.west = west;
		}

	public void setCurrentRoom(Room currentRoom)
		
		{
			this.currentRoom = currentRoom;
		}

	public void setExits(Room north, Room west, Room east, Room south)
	
		{
		    this.north = north;
		    this.east = east;
		    this.south = south;
		    this.west = west;
		}

	public void setMonster(Monster monster)
	
		{
			this.monster = monster;
		}

		//getters
	public String getMonster()
	
		{
			return monster.getName();
		}

	public Monster getMonsterturn()
	
		{
			return this.monster;
		}

	public int getMonsterHp()
		{
			return this.monster.getHp();
		}

	public Room getNorth()
		{
			return this.north;
		}

	public Room getSouth()
		{
			return this.south;
		}

	public Room getEast()
		{
			return this.east;
		}

	public Room getWest()
		{
			return this.west;
		}

	public String getExits()
	    {
	        String exits = "Your exits are: ";
	        
	        if(this.north != null)
	        {
	            exits += "north ";
	        }
	        
	        if(this.east != null)
	        {
	            exits += "east ";
	        }
	        
	        if(this.south != null)
	        {
	            exits += "south ";
	        }
	        
	        if(this.west != null)
	        {
	            exits += "west ";
	        }
	        
	        return exits;
	    }
		
	 public String toString()
	{
	   return description + "\n" + getExits();
	}
			
//end room class
}



