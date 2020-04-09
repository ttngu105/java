import org.junit.*;
import static org.junit.Assert.*;
public class DLLTester{
	//make a linkedlist
private static LinkedList<String> list = new LinkedList<String>();
	
	//add nodes to linked list before testing
	@Before
	public void setup(){
	list.add("Ash");
	list.add("Pikachu");
	list.add("Charazard");
	list.add("Masterball");	
	list.add("Brock");
	list.add("Misty",2);
}
	@Test
	public void testContains(){
		assertTrue(list.contains("Ash") == true);
		assertTrue(list.contains("Charazard") == true);
		assertTrue(list.contains("Brock") == true);
		assertTrue(list.contains("Misty") == true);
	}

	@Test
	public void testIndexOf(){
		assertTrue(list.indexOf("Pikachu") == 2);
		assertTrue(list.indexOf("Misty") == 3);
		assertTrue(list.indexOf("Ash") == 1);


	}
	@Test
	public void testGet(){}

	@Test
	public void testIteratorAt(){
		assertEquals(list.iteratorAt("Misty").next(),"Misty");
		assertEquals(list.iteratorAt("Pikachu").next(),"Pikachu");
		assertEquals(list.iteratorAt("Masterball").next(),"Masterball");
		assertEquals(list.iteratorAt("Charazard").next(),"Charazard");
	}

}