package p4Hash;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TablasTest {
	
	@Test
	public void encontrarMax() {
		ClosedHashTable tabla = new ClosedHashTable(5, 0);
		
		tabla.add(1);
		tabla.add(8);
		tabla.add(2);
		tabla.add(3);
		tabla.add(7);
		
		assertEquals(8,tabla.obtenerMax());
	}
}
