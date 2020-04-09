import java.util.Scanner;

public class Game
{
	//instances variables 
	private static Room currentRoom;
	private static Scanner input = new Scanner(System.in);
	private static String playerName;
	private static	int playerHP;
	private static	int playerATK;
	private static	int playerMP;
	public static int currentPoints = 20;
	private static boolean playerAlive= true;
	

	
	//main method
	public static void main(String[] args)
	{	
			PlayerCreation();

			Player player = new Player( playerName, playerHP, playerATK, playerMP);
				
		//call dungeon class
			Dungeon hauntedHouse = new Dungeon();
		// call spawn room
			currentRoom = hauntedHouse.getRoom0();
		

		
		while(playerAlive = true)	
		{
			
			// call control method
			controls1();
			
			// if monster spawn logic
			if(currentRoom.getMonsterturn()!= null && currentRoom.getMonsterturn().getHp()>=0)
				{
					player.takeTurn(currentRoom.getMonsterturn());

				}


			//player dead logic
			if (playerHP <=0)
				{
					System.out.println ("You are DEAD!!!");
					System.exit(0);
				}

		}	

	}

	//controls method
	public static void controls1()
	{
		//infinate loop
		while(true)
		{	

			// print controls
			System.out.println("Where would you like to go?\nW: to go north\nS: to go south\nD: to go east\nA: to go west\nQ: to quit\n");
			System.out.printf("%s\n",currentRoom);
			// variable for player input
			char playerChoice = input.nextLine().charAt(0);
			
			//Player movement logic
			if(playerChoice == 'w'||playerChoice == 'W')
				{
					if(currentRoom.getNorth() == null){
						System.out.println("You can't go this way");
					}
					else
					{
						
						currentRoom = currentRoom.getNorth();
						break;
					}
				}
			else if (playerChoice == 'a'||playerChoice == 'A')
				{
					if(currentRoom.getWest() == null)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentRoom = currentRoom.getWest();
						break;
					}
				}
			else if (playerChoice == 's'||playerChoice == 'S')
				{
					if(currentRoom.getSouth() == null)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentRoom = currentRoom.getSouth();
						break;
					}
				}
			else if (playerChoice == 'd'||playerChoice == 'D')
				{
					if(currentRoom.getEast() == null)
					{
						System.out.println("You can't go this way");
					}
					else
					{
						currentRoom = currentRoom.getEast();
						break;
					}
				}
			else if (playerChoice == 'q' || playerChoice == 'Q'){
					System.out.println("You left the castle");
					System.exit(0);
				}
			else 
				{
					System.out.println("invalid option");
				}
		}
	}

	//make a player method
	public static void PlayerCreation()
	{

				Scanner input = new Scanner(System.in);
				

				System.out.println("Please input the player's name");
				String playerName = input.nextLine();



			do
				{
					//prints out choices for player 
					System.out.println("\nChose one to add a point to HP\nChose two to add a point to ATK\nChose three to add a point to MP\n");

					//prints name, current points, HP, ATK, and MP
					System.out.printf("%s\nHP: %d\nATK: %d\nMP: %d\nPoints: %d\n\n",playerName,playerHP,playerATK,playerMP,currentPoints);

					String choice = input.nextLine();

					//player creation logic
					if(choice.equals("1"))
					{
						playerHP= playerHP+10;
						currentPoints--;
					}
					
					else if(choice.equals("2"))
					{
						playerATK= playerATK+10;
						currentPoints--;
					}

					else if(choice.equals("3"))
					{
						playerMP= playerMP+3;
						currentPoints--;
					}

					else 
					{
						System.out.println("invalid option");
					}
				//end do-while
				}
				while(currentPoints>=1);
	}
//end class
}