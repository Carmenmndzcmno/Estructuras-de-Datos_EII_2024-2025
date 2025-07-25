package recursividad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Algoritm {

	@Test
	void testFactorial() {
		assertEquals(1,Algoritmos.recursiveFactorial(1));
		assertEquals(Algoritmos.recursiveFactorial(13),6227020800.0);
		assertEquals(120,Algoritmos.recursiveFactorial(5));
		
		assertEquals(1,Algoritmos.iterativeFactorial(1));
		assertEquals(Algoritmos.iterativeFactorial(13),6227020800.0);
		assertEquals(120,Algoritmos.iterativeFactorial(5));
	}
	
	@Test
	void testFibonacci() {
		assertEquals(Algoritmos.iterativeFibonacci(8),21);
		assertEquals(Algoritmos.iterativeFibonacci(0),0);
		assertEquals(Algoritmos.iterativeFibonacci(13),233);
		
		assertEquals(Algoritmos.recursiveFibonacci(8),21);
		assertEquals(Algoritmos.recursiveFibonacci(0),0);
		assertEquals(Algoritmos.recursiveFibonacci(13),233);
	}
	
	@Test
	void testPotencia() {
		assertEquals(Algoritmos.recursivePow(1,0),1);
		assertEquals(Algoritmos.recursivePow(0,0),0);
		assertEquals(Algoritmos.recursivePow(2,8),256);
		
		assertEquals(Algoritmos.iterativePow(1,0),1);
		assertEquals(Algoritmos.iterativePow(0,0),0);
		assertEquals(Algoritmos.iterativePow(2,8),256);
		
		assertEquals(Algoritmos.recursivePow0(0),1);
		assertEquals(Algoritmos.recursivePow0(2),4);
		assertEquals(Algoritmos.recursivePow0(8),256);
		
		assertEquals(Algoritmos.recursivePow(1),2);
		assertEquals(Algoritmos.recursivePow(0),1);
		assertEquals(Algoritmos.recursivePow(8),256);
		
		assertEquals(Algoritmos.recursivePow2(1),2);
		assertEquals(Algoritmos.recursivePow2(0),1);
		assertEquals(Algoritmos.recursivePow2(8),256);
		
		assertEquals(Algoritmos.recursivePow3(1),2);
		assertEquals(Algoritmos.recursivePow3(0),1);
		assertEquals(Algoritmos.recursivePow3(8),256);
	}
}
