package recursividad;

import java.io.IOException;

/**
 * Clase Main
 * Mediante métodos, medimos los tiempos de carga de trabajo de los distintos métodos que se crearon en recursividad.Algoritmos
 * @author Carmen Méndez Camino [UO299841]
 *
 */

public class Main{
	/**
	 * Método main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		TestBench.testAlgorithm("Algoritmos", "iterativefactorial", 6);
		System.out.println(TestBench.testAlgorithm("recursividad.Algoritmos", "iterativeFactorial", 6));
		TestBench.test("recursividad.Algoritmos",5,1,5,"recursividad.Algoritmos","iterativeFactorial");
		
		TestBench.test("lineal.csv",10,1,10,"recursividad.Algoritmos","lineal");
		TestBench.test("quadratic.csv",5,1,10,"recursividad.Algoritmos","quadratic");
		TestBench.test("cubic.csv",5,1,10,"recursividad.Algoritmos","cubic");
		TestBench.test("logarithmic.csv",5,1,10,"recursividad.Algoritmos","logarithmic");
		
		TestBench.test("recursivePow0.csv",5,1,10,"recursividad.Algoritmos","recursivePow0");
		TestBench.test("recursivePow.csv",5,1,10,"recursividad.Algoritmos","recursivePow");
		TestBench.test("recursivePow1.csv",5,1,10,"recursividad.Algoritmos","recursivePow1");
		TestBench.test("recursivePow2.csv",5,1,10,"recursividad.Algoritmos","recursivePow2");
		TestBench.test("recursivePow3.csv",5,1,10,"recursividad.Algoritmos","recursivePow3");
		
		
	}
}