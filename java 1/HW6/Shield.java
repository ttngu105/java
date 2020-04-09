public class Shield extends Items
{
	private int hp;

	//consturctor
	public Shield(String name, int Hp)
	{
		super(name);
		this.hp = Hp;
	}

	//setter and getter
	public void setHp(int HP)
	{
		this.hp = HP;
	}

	public int getHp()
	{
		return this.hp;
	}

	
}