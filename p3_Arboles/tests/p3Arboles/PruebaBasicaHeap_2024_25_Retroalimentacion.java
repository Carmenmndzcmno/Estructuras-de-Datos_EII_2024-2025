package p3Arboles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

import evalNestor.Alumno;

/**
 * Prueba de monticulos
 * 
 * @author Nestor
 *
 */
public class PruebaBasicaHeap_2024_25_Retroalimentacion {
	/**
	 * Main test
	 */
	@Test
	public void main() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;

		try {
			file = new FileWriter(al.getNombreFicheroAlumno() + "-BasicaHeap.txt", true);
			pw = new PrintWriter(file);
			pruebaBasicaAddPoll(pw);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * pruebaBasicaAddPoll
	 * 
	 * @param pw pw
	 */
	static public void pruebaBasicaAddPoll(PrintWriter pw) {
		EDBinaryHeap<Integer> g = new EDBinaryHeap<Integer>(10);
		int linea = 1;
		boolean resultAdd;
		Integer resultPoll;
		pw.println("Empieza la prueba basica de Heap: ");
		System.out.println("Empieza la prueba basica de Heap: ");
		pw.println("g=new EDBinaryHeap<Integer>(10): ");
		System.out.println("g=new EDBinaryHeap<Integer>(10): ");

		for (int nodo = 10; nodo >= 0; nodo--) {
			resultAdd = g.add(nodo);
			pw.println((linea) + " g.addNode(" + nodo + "): " + resultAdd);
			System.out.println((linea++) + " g.addNode(" + nodo + "): " + resultAdd);
			pw.println(g.toString());
			System.out.println(g.toString());
		}

		for (int nodo = 10; nodo >= 0; nodo--) {
			resultPoll = g.poll();
			pw.println((linea) + " g.poll(): " + resultPoll + "\n");
			System.out.println((linea++) + " g.poll(): " + resultPoll + "\n");
			pw.println(g.toString());
			System.out.println(g.toString());
		}

		pw.println("Termina la prueba basica de Heap.\n");
		System.out.println("Termina la prueba basica de Heap.\n");

	}

}
