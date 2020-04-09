// import scanner object
import java.util.Scanner;
// declares public class
public class CombatCaculator5
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
			
			// if player choses 1 starts condition statement
			if (combat==1)
			{
				// monster HP - hero attack
				monsHP= (monsHP-HeroATK);
				
				//prints attack promt
				System.out.printf("You strike the %s with your sword for %s damage.\n", monsNAME, HeroATK);
			
			//ends loop
			}
			// if player choses 2 starts condition statement
			else if (combat==2)
			{
				// only if manna >= 3 player can use ability
				if (HeroMP >= 3)
				{
					// spell attack subtracts 3 MP
					HeroMP-=3;
					
					// spell damage is half of current 
					monsHP= (monsHP/2);
					
					// prints spell prompt
					System.out.printf("You cast a weakening spell on the monster.\n");
				
				//ends >= loop
				}
				else
				{
					// if manna is not >= 3 then print line
					System.out.println("NEED MORE MP\n");
				
				// ends not = loop	
				}
			
			//ends loop
			}
			
			// if player choses 3 starts condition statement
			else if (combat==3)
			{
				HeroMP += 1;
				System.out.printf("You foucus and charge your magic power\n");
			
			//ends loop			
			}
			
			// if player choses 4 starts condition statement
			else if (combat==4)
			{
				
				// prints line
				System.out.println("You ran away!\n");
			
			//ends loop
			}
			
			// if player doesn't chose a valid number start loop
			else 
			{
				// prints line 
				System.out.println("I don't understand that command.\n");
			
			//ends loop
			}
	 
			
		// end of game code
		}
	// ends public void
	}
// ends public class
}	
