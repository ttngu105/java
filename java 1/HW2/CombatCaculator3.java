// import scanner object
import java.util.Scanner;
// declares public class
public class CombatCaculator3
{
	// declares main
	public static void main(String[] args)
	{
		// opens scanner object
		Scanner input = new Scanner(System.in);
	
		// declare monster data
		String monsNAME = "Goblin";
		int monsHP = 100;
		int monsATK= 15;
		
		// declare hero data
		int HeroHP = 100;
		int HeroATK = 12;
		int HeroMP = 0;
		int HeroFlee= 1;
		

		
		// start of game code
		{
			// print monster HP
			System.out.printf("You are fighting a %s\n", monsNAME);
			System.out.printf("Monster's HP: %s\n", monsHP);
			
			// print out player stats
			System.out.printf("Your HP: %s\n", HeroHP);
			System.out.printf("Your MP: %s\n", HeroMP);
			
			
			// prints combat options
			System.out.println("Combat Options\n");
			System.out.println("	1.) Sword Attack\n");
			System.out.println("	2.) Cast Spell\n");
			System.out.println("	3.) Charge Mana\n");
			System.out.println("	4.) Run Away\n");
			
			// print combat prompt
			System.out.println("What action do you want to perform?");
				int combat = input.nextInt();
			
		// end of game code
		}
	// ends public void
	}
// ends public class
}	
