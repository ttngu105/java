import java.util.Scanner;
import java.util.Random;
public class ExpandedCombatSystem
{	

// delcare class variables
public static int HeroHP;
public static int HeroATK;
public static int HeroMP;
public static int currentPoints;
public static int HeroLVL = 20;
public static int HeroEXP;
public static int HeroFLEE = 0;
public static boolean infinateloop = true;
public static String MonsNAME;
public static int MonsHP;
public static int MonsEXP;
public static int MonsATK;
public static int monsterChoice;
public static int monsterAttack;
public static Scanner input = new Scanner(System.in);
			
	//main method		
	public static void main(String[] args)
		{
			
			Hero();
			Monster();
			
			
			
				//if loop to initate level up method
				while (infinateloop = true)
				{
					Game();
					if (HeroEXP>=10)
					{
						currentPoints++;
						Lvlup();
					}
				}
			
			
		}
	
	//hero method
	private static void Hero()
		{
			HeroHP = 0;
			currentPoints = 20;
			HeroATK = 0;
			HeroMP = 0;
			
			//Code for character stats system
			Scanner input = new Scanner(System.in);
			//while loop for character creation
			while (1 <= currentPoints)
			{
			System.out.printf("Health: " + HeroHP + "," + "Attack:" + HeroATK+ "," + " Magic:" + HeroMP);
			System.out.println("\nYou have " + currentPoints + " points to spend\n");
			System.out.println("Health: \n" + HeroHP);
			System.out.println("Attack Power: \n" + HeroATK);
			System.out.println("Magic Power: \n" + HeroMP);
		
				String choice = input.nextLine();
				//to Enter Add point commands
				if (choice.equals("1"))
				{
					//To Increase Hero's Health
					HeroHP  += 10; 
					currentPoints = currentPoints - 1;
					System.out.println("Health: \n" + HeroHP);
					System.out.println("You have " + currentPoints + " points to spend\n");
				}
				else if (choice.equals("2"))
				{
					//To Increase Hero's Attack Power
					HeroATK +=  3 ;
					currentPoints =currentPoints- 1;
					System.out.println("Attack Power: \n" + HeroATK);			
					System.out.println("You have " + currentPoints + " points to spend\n");
				}	
				else if (choice.equals("3"))
				{
					//To Increase Hero's Magic Power
					HeroMP += 1;
					currentPoints = currentPoints - 1;
					System.out.println("Magic Power: \n" + HeroMP);
					System.out.println("You have " + currentPoints + " points to spend\n");
				}
			}
		}//end hero method
		// monster method
		private static void Monster()
			{
					// Code for a random monster
					Random monster = new Random();
					 monsterChoice = monster.nextInt(3);
							MonsNAME = "";
							MonsHP = 0;
							MonsATK = 0;
							MonsEXP = 0;
						
						if(monsterChoice == 0)
							{
								// Stats for Goblin
								MonsNAME = "Goblin";
								MonsHP = 75;
								MonsATK = 8;
								MonsEXP = 1;
							}	
						if(monsterChoice == 1)
							{
								//Stats for Orc
								MonsNAME = "Orc";
								MonsHP = 100;
								MonsATK = 12;
								MonsEXP = 3;
							}
						if(monsterChoice == 2)
							{
								//Stats for Trolls
								MonsNAME = "Troll";
								MonsHP = 150;
								MonsATK = 15;
								MonsEXP = 5;
							}	
						
							//encounter a monster promt
						System.out.println ("You have encountered a "+MonsNAME);
			} //end monster method
	
	// start game method
	private static void Game()
	{
				//while loop for game
				while( MonsHP >= 0 && HeroHP > 0)
				// start of game code
				{						
							int monsterAttack =(int)(Math.random()+.5);
								// print monster HP
								System.out.printf("You are fighting a %s\n", MonsNAME);
								System.out.printf("Monster's HP: %s\n", MonsHP);
								
								// print out player stats
								System.out.printf("Your HP: %s\n", HeroHP);
								System.out.printf("Your MP: %s\n", HeroMP);
								System.out.printf("Your EXP: %s\n", HeroEXP);
																	
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
									MonsHP= (MonsHP-HeroATK);
									//prints attack promt
									System.out.printf("You strike the %s with your sword for %s damage.\n", MonsNAME, HeroATK);
									}//ends loop
									
								// if player choses 2 starts condition statement
								else if (combat==2)
								{
									// only if manna >= 3 player can use ability
									if (HeroMP >= 3)
									{
										// spell attack subtracts 3 MP
										HeroMP-=3;
											
										// spell damage is half of current 
										MonsHP= (MonsHP/2);
											
										// prints spell prompt
										System.out.printf("You cast a weakening spell on the monster.\n");
										
									}//ends >= loop
										
									else
									{
										// if manna is not >= 3 then print line
										System.out.println("NEED MORE MP\n");
										
									}// ends not = loop	
								}//ends loop
								
								
									
								// if player choses 3 starts condition statement
								else if (combat==3)
								{
									HeroMP += 1;
									System.out.printf("You foucus and charge your magic power\n");
									
								}//ends loop			
									
									
									// if player choses 4 starts condition statement
								else if (combat==4)
								{
									// if hero flee is greater than 1 run statement
									HeroFLEE=-1;
									// prints line
									System.out.println("You ran away!\n");
									
								}//ends loop
									
								// if player doesn't chose a valid number start loop
								else 
								{
									// prints line 
									System.out.println("I don't understand that command.\n");
								
								}//ends loop
									
								if(monsterAttack==1)
								{
									HeroHP = HeroHP-MonsATK;
									System.out.printf("the %s has attacked you for %s\n", MonsNAME,MonsATK);
								}

								
								
				}
	}// end game method
	//start level up method
	private static void Lvlup()
	{
		
		 //promt user to lvl up
		 System.out.printf("Congratulations you have leveled up!!\n");
		//print stats
		 System.out.printf("Health: \n Attack: \n Magic: \n",HeroHP,HeroATK,HeroMP);
			System.out.println("\nYou have " + currentPoints + " points to spend\n");
			System.out.println("Health: \n" + HeroHP);
			System.out.println("Attack Power: \n" + HeroATK);
			System.out.println("Magic Power: \n" + HeroMP);
		//get input form the scanner
		String choice = input.nextLine();
				
				//decide what stats to lvl up
				if (choice.equals("1"))
				{
					//To Increase Hero's Health
					HeroHP  += 10; 
					currentPoints = currentPoints - 1;
					System.out.println("Health: \n" + HeroHP);
					System.out.println("You have " + currentPoints + " points to spend\n");
				}
				else if (choice.equals("2"))
				{
					//To Increase Hero's Attack Power
					HeroATK +=  3 ;
					currentPoints =currentPoints- 1;
					System.out.println("Attack Power: \n" + HeroATK);			
					System.out.println("You have " + currentPoints + " points to spend\n");
				}	
				else if (choice.equals("3"))
				{
					//To Increase Hero's Magic Power
					HeroMP += 1;
					currentPoints = currentPoints - 1;
					System.out.println("Magic Power: \n" + HeroMP);
					System.out.println("You have " + currentPoints + " points to spend\n");
				}
		 //reset EXP variables
		 HeroEXP-=HeroEXP;
	} // end level up method
		
	
}//end class	