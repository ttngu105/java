public class GameCharacter
{
	//instance variables
	protected String name;
	protected int hp;
	protected int atk;
	
	//constructor
	public GameCharacter(String name, int hp, int atk)
	{
		
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	//getters
	public String getName()
	{
		return this.name;
	}

	public int getHp()
	{
		return this.hp;
	}

	public int getAtk()
	{
		return this.atk;
	}

	// setter
	public void setHp(int health)
	{
		this.hp = health;
	}
	public void setAtk(int Atk)
	{
		this.atk = Atk;
	}


//end class
}