package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import evalNestor.Alumno;

class AVLTreeTestSesion9_SinglesRotations {
	
	LocalDateTime localTime = LocalDateTime.now();
	int hora  = localTime.getHour();
	
	@Test
	void testSesion9() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;
		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-AVLTree-ADD-SinglesRotations.txt",true);
			pw = new PrintWriter(file);
			
			pw.println("Fecha y hora: "+localTime.toString());
			
			sesion9(pw);
			
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


 
	void sesion9(PrintWriter pw) { 
		Integer[] nodos=new Integer[]{100,200,300,400,500,600,700,800,900,1000}; 
		AVLTree<Integer> t; 

		t = new AVLTree<Integer> (); 
		int k=1;
		
		for (int i=0; i<nodos.length;i++) { 
			assertTrue(t.addNode(nodos[i]),"Falla addNode("+nodos[i]+")"); 
			pw.println("Arbol:"+k+"\n"+t);
			System.out.println("Arbol:"+(k++)+"\n"+t); 
		} 
		
		for (int i=nodos.length-1;i>=0;i--) { 
			assertTrue(t.addNode(nodos[i]/100),"Falla addNode("+(nodos[i]/100)+")"); 
			pw.println("Arbol:"+k+"\n"+t);
			System.out.println("Arbol:"+(k++)+"\n"+t); 
		} 
		
		pw.println("PreOrder del Arbol:\n"+t
				+t.preOrder());
		System.out.println("PreOrder del Arbol:\n"+t
				+t.preOrder()); 
		pw.println("InOrder del Arbol:\n"+t
				+t.inOrder());
		System.out.println("inOrder del Arbol:\n"+t
				+t.inOrder()); 
		pw.println("PostOrder del Arbol:\n"+t
				+t.postOrder());
		System.out.println("PostOrder del Arbol:\n"+t
				+t.postOrder()); 
		
	} 
}
