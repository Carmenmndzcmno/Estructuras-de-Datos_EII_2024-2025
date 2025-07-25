package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import evalNestor.Alumno;
import evalNestor.EvalBSTree;

class BSTreeTestSesion8 {
	static final int HORA_INICIAL=19;

	LocalDateTime localTime = LocalDateTime.now();
	int hora  = localTime.getHour();

	@Test
	void testSesion8() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;
		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-BSTree-ADD.txt",true);
			pw = new PrintWriter(file);
			
			pw.println("Fecha y hora: "+localTime.toString());
			
			Sesion8AddYRecorridos(pw);
			
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

	@Test
	void testSesion8Final() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;

		if (hora >= HORA_INICIAL) {
			try
			{
				file = new FileWriter(al.getNombreFicheroAlumno()+"-BSTree-REMOVE.txt",true);
				pw = new PrintWriter(file);

				pw.println("Fecha y hora: "+localTime.toString());
				
				Sesion8Remove(pw);

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
		

	}


	private void Sesion8AddYRecorridos(PrintWriter pw) {
		BSTree<Integer> t = new BSTree<Integer>();
		int n=0;

		Integer[] nodos=new Integer[] {100,50,150,70,60,30,200,90,120,170,210};
		
		for (Integer i:nodos) {
			assertEquals(true,t.addNode(i));
			pw.println("Arbol prueba "+(++n)+" despues de addNode("+i+"):\n"+t);
			System.out.println("Arbol prueba "+(n)+" despues de addNode("+i+"):\n"+t);
		}

		pw.println("Arbol prueba ADD final preOrder():\n"+t.preOrder());
		System.out.println("Arbol prueba ADD final preOrder():\n"+t.preOrder());

		pw.println("Arbol prueba ADD final inOrder():\n"+t.inOrder());
		System.out.println("Arbol prueba ADD final inOrder():\n"+t.inOrder());

		pw.println("Arbol prueba ADD final postOrder():\n"+t.postOrder());
		System.out.println("Arbol prueba ADD final postOrder():\n"+t.postOrder());

		assertEquals(false,t.addNode(60));
		pw.println("\nArbol prueba "+(++n)+" despues de addNode(60) que ya existe:\n"+t);
		System.out.println("\nArbol prueba "+(n)+" despues de addNode(60) que ya existe:\n"+t);

		try {
			assertFalse(t.addNode(null));
		}
		catch (NullPointerException e) {
			pw.println(e.getMessage());
			System.out.println(e.getMessage());
			pw.println("Arbol prueba "+(++n)+" despues de addNode(null):\n"+t);
			System.out.println("Arbol prueba "+(n)+" despues de addNode(null):\n"+t);
		}
	}

	private void Sesion8Remove(PrintWriter pw) {
		EvalBSTree<Integer> t = new EvalBSTree<Integer>();
		int n=0;
		t = new EvalBSTree<Integer>(new Integer[] {100,50,150,30,70,120,200,null,null,60,90,null,null,170,210});
//		System.err.println(t);
		Integer[] nodos = new Integer[]{120,150,200,100,70,90,60,50,30,170,210};

		pw.println("Arbol prueba REMOVE inicial:\n"+t);
		System.out.println("Arbol prueba REMOVE inicial:\n"+t);

		for (Integer i:nodos) {
			assertEquals(true,t.removeNode(i));
			pw.println("Arbol prueba "+(++n)+" despues de removeNode("+i+"):\n"+t);
			System.out.println("Arbol prueba "+(n)+" despues de removeNode("+i+"):\n"+t);
		}
		
		assertEquals(false,t.removeNode(0));
		pw.println("Arbol prueba "+(++n)+" despues de removeNode(NodoInexistente):\n"+t);
		System.out.println("Arbol prueba "+(n)+" despues de removeNode(NodoInexistente):\n"+t);
	
		try {
			assertFalse(t.removeNode(null));
		}
		catch (NullPointerException e) {
			pw.println(e.getMessage());
			System.out.println(e.getMessage());
			pw.println("Arbol prueba "+(++n)+" despues de removeNode(null):\n"+t);
			System.out.println("Arbol prueba "+(n)+" despues de removeNode(null):\n"+t);
		}

	}

	
}
