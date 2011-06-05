
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;


public class testBreathalyzer {
	
	@Test
	public void testDistance4() throws FileNotFoundException {
		breathalyzer b = new breathalyzer("./tests/4.in");
		assertEquals(4, b.getTotalEditDistance());
	}
	
	@Test
	public void testDistance12() throws FileNotFoundException {
		breathalyzer b = new breathalyzer("./tests/12.in");
		assertEquals(12, b.getTotalEditDistance());
	}
	
	@Test
	public void testDistance63() throws FileNotFoundException {
		breathalyzer b = new breathalyzer("./tests/63.in");
		assertEquals(63, b.getTotalEditDistance());
	}
	
	@Test
	public void testDistance86() throws FileNotFoundException {
		breathalyzer b = new breathalyzer("./tests/86.in");
		assertEquals(86, b.getTotalEditDistance());
	}
	
	@Test
	public void testDistance187() throws FileNotFoundException {
		breathalyzer b = new breathalyzer("./tests/187.in");
		assertEquals(187, b.getTotalEditDistance());
	}
}
