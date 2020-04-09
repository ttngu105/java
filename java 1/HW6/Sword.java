public class Sword extends Items
{
	private int atk;

	//constructor
	public Sword(String name, int Atk)
	{
		super(name);
		this.atk = Atk;
	}

	//setter ane getter
	public void setAtk(int Atk)
	{
		this.atk = Atk;
	}

	public int getAtk()
	{
		return this.atk;
	}


}