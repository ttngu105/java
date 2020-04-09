
public class Monster extends GameCharacter
{
	//monster intance variables
	protected int exp;
	protected int health;
	private Monster goblin;
	private Monster orc;
	private Monster troll;
	private Monster dragon;
	private Monster ghost;
	private Monster slime;
	
	// monster constructor
	public Monster(String name, int hp, int atk, int exp)
	{
		super(name,hp,atk);
		this.exp = exp;
		
	}
	//Monster respawn method
	public void Monsterrespawn()
	{
		//if monster name equals monster, fill health
		if(this.name.equals("Goblin"))
		
		{
			setHp(75);
		}
		
		if(this.name.equals("Orc"))
		{
			setHp(100);
		}

		if(this.name.equals("Troll"))
		{
			setHp(150);
		}

		if(this.name.equals("Ghost"))
		{
			setHp(50);
		}

		if(this.name.equals("Slime"))
		{
			setHp(10);
		}
	}

	// attack method
	public void attack(Player player)
	{
		
		player.setHp(player.getHp()-this.atk);	
	}

	// turn method
	public void takeTurn(Player player)
	{
	
		this.attack(player);
	}

	//setter and getter
	public int getEXP()
	{
		return this.exp;
	}

	public void setExp(int EXP)
	{
		this.exp = EXP;
	}
//end class
}