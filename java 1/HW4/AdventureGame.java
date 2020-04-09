import java.util.Scanner;
class AdventureGame
{
	//initalize class variables 
	private static String [] rooms = new String [7];
	private static int [][] exit = new int [7][4];
	private static int currentroom = 1;
	private static int north = 0;
	private static int south = 3;
	private static int east = 1;
	private static int west = 2;
	
	//main method
		public static void main(String [] args)
		{
			//initalize rooms
			rooms[0] = "You are in the guest bedroom, exits are north and east.";
			rooms[1] = "You are in the South Hall, exits are north, east, and west.";
			rooms[2] = "You are in the Dining Room, exits are north and west.";
			rooms[3] = "You are in the Master Beedroom, exits are east and south.";
			rooms[4] = "You are in the North Hall, exits are north, east, west, and south.";
			rooms[5] = "You are in the kitchen, exits are west and south.";
			rooms[6] = "you are on the Balcony, exits are south.";
			
			// initalize exits
			int exit [][] = 
						{
							{3,1,-1,-1},
							{4,2,0,-1},
							{5,-1,1,-1},
							{-1,4,-1,0},
							{6,5,3,1},
							{-1,-1,4,2},
							{-1,-1,-1,4},
						};
			System.out.println("You enter a haunted castle\n");
			//starts infinate loop
			while(true)
			{
				Scanner input = new Scanner (System.in);
				System.out.println(rooms[currentroom]);
				System.out.println("Where would you like to go?\nW: to go north\nS: to go south\nD: to go east\nA: to go west\nOr select Q to quit\n");
				// variable for player input
				char playerChoice = input.next().charAt(0);
				
				if(playerChoice == 'w'||playerChoice == 'W')
				{
					if(exit[currentroom][north] == -1){
						System.out.println("You can't go this way");
					}
					else
					{
						currentroom = exit[currentroom][north];
					}
				}
				else if (playerChoice == 'a'||playerChoice == 'A')
				{
					if(exit[currentroom][west] == -1)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentroom = exit[currentroom][west];
					}
				}
				else if (playerChoice == 's'||playerChoice == 'S')
				{
					if(exit[currentroom][south] == -1)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentroom = exit[currentroom][south];
					}
				}
				else if (playerChoice == 'd'||playerChoice == 'D')
				{
					if(exit[currentroom][east] == -1)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentroom = exit[currentroom][east];
					}
				}
				else if (playerChoice == 'q' || playerChoice == 'Q'){
					System.out.println("You left the castle");
					break;
				}
				else {
					System.out.println("invalid option");
				}
					
				
			}// end while	
		}
	
}
