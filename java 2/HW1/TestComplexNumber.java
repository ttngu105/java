//imports junit util
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;


public class TestComplexNumber
{	/**
	*@author Thien Tommy Nguyen
	*@version Verison V.1
	*/

	//class variables
	private ComplexNumber numb1;
	private ComplexNumber numb2;
	private ComplexNumber numb3;
	private ComplexNumber numb4;

	@Before
	//sets valuales before running ComplexNumber.java
	public void setVals()
	{
		numb1 = new ComplexNumber (1.0f,1.0f);
		numb2 = new ComplexNumber (2.0f,2.0f);
		numb3 = new ComplexNumber (3.0f,3.0f);
		numb4 = new ComplexNumber (4.0f,4.0f);
	}

	@Test
	// plugs in values in to method ComplexNumber.add()
	public void testAdd()
	{
		//assertEquals(expected,actual);
		//toString formats float and adds i to the the last value
		assertEquals("2.0 + 4.0i",numb1.add(numb2).toString());
		assertEquals("4.0 + 6.0i",numb2.add(numb3).toString());
		assertEquals("6.0 + 8.0i",numb3.add(numb4).toString());	
	}

	@Test
	// plugs in values in to method ComplexNumber.subtract()
	public void testSub()
	{
		//assertEquals(expected,actual);
		//toString formats float and adds i to the the last value
		assertEquals("0.0 + 0.0i",numb1.subtract(numb2).toString());
		assertEquals("0.0 + 0.0i",numb2.subtract(numb3).toString());
		assertEquals("0.0 + 0.0i",numb3.subtract(numb4).toString());
	}

	@Test
	// plugs in values in to method ComplexNumber.multiply()
	public void testMulti()
	{
		//assertEquals(expected,actual);
		//toString formats float and adds i to the the last value
		assertEquals("-3.0 + 4.0i",numb1.multiply(numb2).toString());
		assertEquals("-5.0 + 12.0i",numb2.multiply(numb3).toString());
		assertEquals("-7.0 + 24.0i",numb3.multiply(numb4).toString());
	}

	@Test
	// plugs in values in to method ComplexNumber.divide()
	public void testDiv()
	{
		//assertEquals(expected,actual);
		//toString formats float and adds i to the the last value
		assertEquals("1.0 + 0.8i",numb1.divide(numb2).toString());
		assertEquals("1.0 + 0.9i",numb2.divide(numb3).toString());
		assertEquals("1.0 + 1.0i",numb3.divide(numb4).toString());
	}



}