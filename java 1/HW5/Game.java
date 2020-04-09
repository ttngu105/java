import java.util.Scanner;

public class Game
{
	//instances variables 
	private static Room currentRoom;
	private static Scanner input = new Scanner(System.in);
	
	//main method
	public static void main(String[] args)
	{
		//call dungeon class
		Dungeon hauntedHouse = new Dungeon();
		// call spawn room
		currentRoom = hauntedHouse.getRoom0();
		// call control method
		controls();
		
	}
	
	public static void controls()
	{
		while(true)
		{
				// print controls
				System.out.println("Where would you like to go?\nW: to go north\nS: to go south\nD: to go east\nA: to go west\nOr select Q to quit\n");
				System.out.printf("%s\n",currentRoom);
				// variable for player input
				char playerChoice = input.nextLine().charAt(0);
			if(playerChoice == 'w'||playerChoice == 'W')
				{
					if(currentRoom.getNorth() == null){
						System.out.println("You can't go this way");
					}
					else
					{
						
						currentRoom = currentRoom.getNorth();
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
					}
				}
			else if (playerChoice == 'q' || playerChoice == 'Q'){
					System.out.println("You left the castle");
					break;
				}
			else 
				{
					System.out.println("invalid option");
				}
		}
	}
	
}