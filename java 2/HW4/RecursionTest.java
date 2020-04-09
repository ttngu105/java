import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;
public class RecursionTest{
	//make arraylist String named list
	ArrayList <String> list ;

/*before the test initalize the arraylist and add people to arraylist*/

@Before
public void setup(){
	list = new ArrayList<String>();
	list.add("Arron");
	list.add("berret");
	list.add("Aron");
	list.add("Tommy");
	list.add("jake");
	list.add("JAKE");
	}

 /*test compareTo method for output*/

@Test
public void testcompareTo(){
	assertTrue(Recursion.compareTo(list.get(0),list.get(1))== -1);
	assertTrue(Recursion.compareTo(list.get(1),list.get(2))== 1);
	assertTrue(Recursion.compareTo(list.get(4),list.get(5))== 0);
}

/*test the findminimum method*/

@Test
public void testfindminimum(){
	assertTrue(Recursion.findMinimum(list)== "Aron");
}

}
