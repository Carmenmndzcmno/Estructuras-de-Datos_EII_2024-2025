package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import evalNestor.Alumno;

class AVLTreeTestSesion10 {
//	static final int HORA_INICIAL=15;

	LocalDateTime localTime = LocalDateTime.now();
	int hora  = localTime.getHour();

	@Test
	void testSesion10() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;
		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-AVLTree-ADD.txt",true);
			pw = new PrintWriter(file);
			
			pw.println("Fecha y hora: "+localTime.toString());
			
			sesion10AddLeftYRecorridos(pw);
			sesion10AddRightYRecorridos(pw);
			
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


	private void sesion10AddLeftYRecorridos(PrintWriter pw) {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int n=0;

		Integer[] nodos=new Integer[] {150,100,50,30,130,140,40,46,44,20,48,10};
		
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

		assertEquals(false,t.addNode(nodos[10]));
		pw.println("\nArbol prueba "+(++n)+" despues de addNode("+nodos[10]+") que ya existe:\n"+t);
		System.out.println("\nArbol prueba "+(n)+" despues de addNode("+nodos[10]+") que ya existe:\n"+t);

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

	private void sesion10AddRightYRecorridos(PrintWriter pw) {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int n=0;

		Integer[] nodos=new Integer[] {-150,-100,-50,-30,-130,-140,-40,-46,-44,-20,-48,-10};
		
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

		assertEquals(false,t.addNode(nodos[10]));
		pw.println("\nArbol prueba "+(++n)+" despues de addNode("+nodos[10]+") que ya existe:\n"+t);
		System.out.println("\nArbol prueba "+(n)+" despues de addNode("+nodos[10]+") que ya existe:\n"+t);

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
	
}
