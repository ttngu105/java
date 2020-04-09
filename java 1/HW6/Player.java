import java.util.Scanner;
import java.util.Random;
public class Player extends GameCharacter
{
	//player instance variables
	protected int mp;
	private int exp;
	private  Scanner input = new Scanner(System.in);
	private Shield greatShield = new Shield("Great Shield",50);
	private Sword greatSword = new Sword("Great Sword",50);
	private Items[] weapons = new Items[2];
	private Monster monster;
 	

	//player constructor
	public Player(String name, int hp, int atk, int mp)
	{
		super(name, hp, atk);
		this.mp = mp;
		this.exp = exp;



	}

	//player attack method
	public void attack(Monster monster)
	{
		monster.setHp(monster.getHp() - this.atk);
	}

	//cast spell method
	public void castSpell(Monster monster)
	{
		monster.setHp(monster.getHp()/2);
		this.mp=this.mp-3;
	}

	//charge mana method
	public void chargeMana()
	{
		this.mp++;
	}

	public void takeTurn(Monster monster)
	{
		//infinate loop
		while(true)

			{	
				//combat display and logic
				System.out.printf("\nYou have encountered a: %s\nmonster's HP:%s\n",monster.getName(),monster.getHp());
				display();
				int combat = input.nextInt();

				if (combat==1)
					{
						attack(monster);
					}
				if (combat==2)
					{
						castSpell(monster);
					}
				if (combat==3)
					{
						chargeMana();
					}
				if(combat==4)
					{
						break;
					}
				monster.takeTurn(this);

				if(monster.getHp()<=0)
					{
				//break code if monster dies and respawn
						ItemGenerator();
						monster.Monsterrespawn();
						break;
					}

			}

	}

	//display method
	public void display()
	{
		System.out.printf("\nYour Hp:%s\nYour Mp:%s\nYour Atk:%s\nYour Exp:%s\n\nCombat Options:\n1:Attack\n2:Spell\n3:Charge Mana\n4:Run Away\n",hp,mp,atk,exp);
	}

	//random item generator ane println
	public void ItemGenerator()
	{
		weapons[0] = greatSword;
		weapons[1] = greatShield;

		Random itemPicker = new Random();

		int item = itemPicker.nextInt(weapons.length);

		System.out.println("You killed " +/*monster.getName()*/". It dropped "+ weapons[item].getName());
	
		if (weapons[item] == weapons[0])
		{
			setAtk(this.greatSword.getAtk()+this.atk);
		}

		if (weapons[item] == weapons[1])
		{
			setHp(this.greatShield.getHp()+this.hp);
		}
	}

	//getter and setter 
	public int getMana()
	{
		return this.mp;
	}

	public void setMP(int mana)
	{
		this.mp= mana;
	}

	




//end class
}