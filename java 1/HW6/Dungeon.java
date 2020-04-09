public class Dungeon{
	//class variables
	private Room northHall;
	private Room southHall;
	private Room bedRoom1;
	private Room bedRoom2;
	private Room balcony;
	private Room dining;
	private Room kitchen;
	private Monster goblin;
	private Monster orc;
	private Monster troll;
	private Monster dragon;
	private Monster ghost;
	private Monster slime;
	private Items greatShield;
	private Items greatSword;

	
	
	//constructor
	public Dungeon()
	{
		southHall = new Room("You've entered south hall.");
		bedRoom2 = new Room("You've entered the second Bedroom.");
		bedRoom1 = new Room("You've entered the first Bedroom.");
		northHall = new Room("You've entered northHall.");
		kitchen = new Room("you've entered the Kitchen.");
		dining = new Room("you've entered the Dining room.");
		balcony = new Room("you've entered the Balcony.");
		

		southHall.setExits( northHall, bedRoom2, dining, null);
		bedRoom2.setExits( bedRoom1, null,southHall,null);
		bedRoom1.setExits( null, null, northHall, bedRoom2);
		northHall.setExits( balcony, bedRoom1, kitchen, southHall);
		kitchen.setExits( null, northHall, null, dining);
		dining.setExits(kitchen, southHall, null, null);
		balcony.setExits(null, null, null, northHall);

		DungeonMonsters();
		

	}

	//create monster method
	public void DungeonMonsters()
	{
		goblin = new Monster("Goblin",75,8,2);
		orc =  new Monster("Orc",100,12,3);
		troll =  new Monster("Troll",150,15,5);
		dragon = new Monster("Dragon",1000,40,10);
		ghost = new Monster("Ghost",50,5,1);
		slime = new Monster("Slime",10,1,1);

		northHall.setMonster(goblin);
		bedRoom2.setMonster(orc);
		kitchen.setMonster(troll);
		balcony.setMonster(dragon);
		bedRoom1.setMonster(slime);
		dining.setMonster(ghost);

		
	}
	
	//getter
	public Room getRoom0()
	{
		return southHall;
	}	
	
// end dungeon 
}