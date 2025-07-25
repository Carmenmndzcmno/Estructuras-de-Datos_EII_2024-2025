package p3Arboles;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import p3Arboles.EDBinaryHeap;
/**
 * Clase de prueba para Colas de Prioridad
 * @author Carmen Méndez Camino [UO299841]
 *
 */
public class ColasDePrioridadTests {
	
	@Test
	void testAdd( ) {
		EDBinaryHeap cola = new EDBinaryHeap(3);
		
		assertEquals(cola.add(4),true);
		assertEquals(cola.add(1),true);
		assertEquals(cola.add(2),true);
		assertEquals(cola.add(8),false);
		System.out.println(cola.toString());
	}
	
	@Test
	void testAdd2( ) {
		EDBinaryHeap cola = new EDBinaryHeap(8);
		
		assertEquals(cola.add(4),true);
		assertEquals(cola.add(1),true);
		assertEquals(cola.add(2),true);
		assertEquals(cola.add(8),true);
		assertEquals(cola.add(50),true);
		assertEquals(cola.add(89),true);
		assertEquals(cola.add(38),true);
		assertEquals(cola.add(3),true);
		System.out.println(cola.toString());
	}
	
	@Test
	void testAdd3( ) {
		EDBinaryHeap cola = new EDBinaryHeap(10);
		
		assertEquals(cola.add(12),true);
		assertEquals(cola.add(14),true);
		assertEquals(cola.add(15),true);
		assertEquals(cola.add(20),true);
		assertEquals(cola.add(16),true);
		assertEquals(cola.add(17),true);
		assertEquals(cola.add(19),true);
		assertEquals(cola.add(24),true);
		System.out.println(cola.toString()+"\nAñadimos el 18:");
		assertEquals(cola.add(18),true);
		System.out.println(cola.toString());
	}
	
	/**practicaa
	 * 
	 */
	
	@Test
	void testDevolverMax( ) {
		EDBinaryHeap cola = new EDBinaryHeap(7);
		
		cola.add(12);
		cola.add(14);
		cola.add(15);
		cola.add(20);
		cola.add(16);
		cola.add(17);
		cola.add(19);
		
		assertEquals(20,cola.encuentraMax());
		
		System.out.println(cola.toString());
	}
	
	@Test
	void testCambiarPrioridad1( ) {
		EDBinaryHeap cola = new EDBinaryHeap(7);
		
		cola.add(12);
		cola.add(14);
		cola.add(15);
		cola.add(20);
		cola.add(16);
		cola.add(17);
		cola.add(19);
		
		System.out.println(cola.toString());
		
		assertEquals(true,cola.cambiarPrioridad(15,2));
		
		System.out.println(cola.toString());
		
		assertEquals(false,cola.cambiarPrioridad(15,2));
	}
	
	@Test
	void testCambiarPrioridad2( ) {
		EDBinaryHeap cola = new EDBinaryHeap(7);
		
		cola.add(12);
		cola.add(14);
		cola.add(15);
		cola.add(20);
		cola.add(16);
		cola.add(17);
		cola.add(19);
		
		System.out.println(cola.toString());
		
		assertEquals(true,cola.cambiarPrioridad(15,30));
		
		System.out.println(cola.toString());
	}
}