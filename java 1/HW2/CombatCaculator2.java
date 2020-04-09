// import scanner object
import java.util.Scanner;
// declares public class
public class CombatCaculator2
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
		
		// loops ends when monster HP is zero or when HeroFlee doesn't equal to 1
		while (monsHP > 0 && HeroFlee == 1)
		
		// start of game code
		{
			// print monster HP
			System.out.printf("You are fighting a %s\n", monsNAME);
			System.out.printf("Monster's HP: %s\n", monsHP);
			
			// print out player stats
			System.out.printf("Your HP: %s\n", HeroHP);
			System.out.printf("Your MP: %s\n", HeroMP);
	
		// end of game code
		}
	// ends public void
	}
// ends public class
}	
