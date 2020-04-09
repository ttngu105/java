/**import*/
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
public class RedirectTester {
/**instace variables*/
private ByteArrayOutputStream output = new ByteArrayOutputStream();
private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
private String lineSeparator = System.getProperty("line.separator");
private Pokemon bob;
private Pokemon joe;
private Pokemon haydar;
private Pokemon stimpy;
private PokemonTrainer larry;
private PokemonTrainer camille;
private PokemonTrainer devin;
/**setup before running test*/
@Before
public void setup() {
bob = new Pokemon("Bob",100,70);
joe = new Pokemon("Joe",80,12);
haydar = new Pokemon("Haydar",70,22);
stimpy = new Pokemon("Stimpy",95,11);

// build some PokemonTrainer objects
larry = new PokemonTrainer("Larry");
camille = new PokemonTrainer("Camille");
devin = new PokemonTrainer("Devin");
System.setOut(new PrintStream(output));
System.setErr(new PrintStream(errorOutput));
} // end @Before method
/**test get name*/
@Test 
public void testgetPokemonName(){
	assertEquals("Bob",bob.getName());
	assertEquals("Joe",joe.getName());
	assertEquals("Haydar",haydar.getName());
	assertEquals("Stimpy",stimpy.getName());
}
/**test output*/
@Test
public void testStdOut() {
System.out.println("hello");
assertEquals("hello" + lineSeparator, output.toString());
}
/**test errorOutput*/
@Test
public void testStdErr() {
System.err.println("good bye");
assertEquals("good bye" + lineSeparator, errorOutput.toString());
}
/**test attack()*/
@Test 
public void testAttack(){
	bob.attack(joe);
	assertEquals(10,joe.getHealth());
	haydar.attack(bob);
	assertEquals(78,bob.getHealth());
	stimpy.attack(haydar);
	assertEquals(59,haydar.getHealth());
}

/**test isDead()*/
@Test
public void testIsDead(){
	bob.takeDamage(100,haydar);
	assertTrue(bob.isDead());
	haydar.takeDamage(70,stimpy);
	assertTrue(haydar.isDead());
}

/**test trainer.getname()*/
@Test
public void testGetTrainerName(){
	assertEquals("Larry",larry.getName());
	assertEquals("Camille",camille.getName());
	assertEquals("Devin",devin.getName());
}
/**test test update()*/
@Test
public void testUpdate(){
	larry.update(bob,"Bob got attacked");
	assertEquals("PokemonTrainer Larry is notified that Bob got attacked"+ lineSeparator,output.toString());
/**test update()*/
}
@Test
public void testUpdate2(){
	camille.update(haydar,"Haydar got attacked");
	assertEquals("PokemonTrainer Camille is notified that Haydar got attacked"+ lineSeparator,output.toString());
}
/**reset streams*/

@After
public void resetStreams() {
System.setOut(System.out);
System.setErr(System.err);
} // end @After method
} // end class RedirectTester