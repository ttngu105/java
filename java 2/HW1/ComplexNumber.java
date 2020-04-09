public class ComplexNumber
{
	/**
	*@author Thien Tommy Nguyen
	*@version Verison V.1
	*the instance variables a and b are representing the real parts of the complex number
	*/
	private float a;
	private float b;
	private ComplexNumber newComplexNumb;
	public ComplexNumber(float a, float b)
	{
		//initalize varaibles
		this.a = a;
		this.b = b;
	}
	/**
	*@since add method V.1
	* this method adds a number to a complex number
	*@return newComplexNumb returns the final answer to the addition of numbers containing i
	*/
	public ComplexNumber add(ComplexNumber otherNumb)
	{
		float newA = a + b;
		float newB = otherNumb.getA() + otherNumb.getB();
		newComplexNumb = new  ComplexNumber (newA, newB);

		return newComplexNumb;
	}
	/**
	*@since subtract method V.1
	* this method subtracts a number to a complex number
	*@return newComplexNumb returns the final answer to the subtraction of numbers containing i
	*/
	public ComplexNumber subtract(ComplexNumber otherNumb)
	{
		float newA = a - b;
		float newB = otherNumb.getA() - otherNumb.getB();
		newComplexNumb = new ComplexNumber (newA, newB);

		return newComplexNumb;
	}
	/**
	*@since multiply method V.1
	* this method multiply a number to a complex number then subtracts the other complex number
	*@return newComplexNumb returns the final answer to the multiplication of numbers containing i
	*/
	public ComplexNumber multiply(ComplexNumber otherNumb)
	{
		float newA = ((a*b) - (otherNumb.getA()*otherNumb.getB()));
		float newB = ((b * otherNumb.getA()) + (a * otherNumb.getB()));
		newComplexNumb = new ComplexNumber (newA, newB);

		return newComplexNumb;
	}
	/**
	*divide method V.1
	* this method multiplies a two numbers to two complex numbers
	*@return newComplexNumb returns the final answer to division of numbers containing i
	*/
	public ComplexNumber divide(ComplexNumber otherNumb)
	{
		float newA = ((a * b) + (otherNumb.getA()* otherNumb.getB()))/
					 ((b * b) + (otherNumb.getB() * otherNumb.getB()));
		float newB = ((otherNumb.getA() * b) + (otherNumb.getB() * a))/
					 ((b * b) + (otherNumb.getB() * (otherNumb.getB())));
		newComplexNumb = new ComplexNumber (newA, newB);

		return newComplexNumb;
	}
	/**
	*@return getA returns the value for the float a
	*/
	public float getA()
	{
			return this.a;
	}
	/**
	*@return getB returns the value for float b
	*/
	public float getB()
	{
			return this.b;
	}

	/**
	@return this returns formated text and adds the i for the imanganary number 
	*/	
	public String toString()
	{
		String finalAnswer = String.format("%.1f + %.1fi", a, b);
		return finalAnswer;
	}
	//uses the equal method from Object.util
	public boolean equals(Object otherNumb)
	{
		// boolean to check if otherNumb is a ComplexNumber
		if(otherNumb instanceof ComplexNumber)
		{
		//cast otherNumb as a ComplexNumber
		ComplexNumber number=(ComplexNumber) otherNumb;
		//if other number has no value if it does return false
		if(number!=null)
		{
			// if getA=a & getB=b then return true if not return false
			if(number.getA()==a)
			{
			if(number.getB()==b)
			{
				return true;
			}
			else
			{
				return false;
			}	
			} 
			else
			{
				return false;
			}
		}
			else
			{
				return false;
			}
		}
			else
			{
				return false;
			}
	}
}