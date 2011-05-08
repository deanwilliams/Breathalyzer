
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;


public class testBreathalyzer {

	private static String[] acceptedWords;
	
	@BeforeClass
	public static void getAcceptedWords() throws FileNotFoundException {
		acceptedWords = breathalyzer.getAcceptedWords();
	}
	
	@Test
	public void testDistance4() throws FileNotFoundException {
		assertEquals(4, breathalyzer.getTotalEditDistance("./tests/4.in"));
	}
	
	@Test
	public void testDistance12() throws FileNotFoundException {
		assertEquals(12, breathalyzer.getTotalEditDistance("./tests/12.in"));
	}
	
	@Test
	public void testDistance63() throws FileNotFoundException {
		assertEquals(63, breathalyzer.getTotalEditDistance("./tests/63.in"));
	}
	
	@Test
	public void testDistance86() throws FileNotFoundException {
		assertEquals(86, breathalyzer.getTotalEditDistance("./tests/86.in"));
	}
	
	@Test
	public void testDistance187() throws FileNotFoundException {
		assertEquals(187, breathalyzer.getTotalEditDistance("./tests/187.in"));
	}
}
