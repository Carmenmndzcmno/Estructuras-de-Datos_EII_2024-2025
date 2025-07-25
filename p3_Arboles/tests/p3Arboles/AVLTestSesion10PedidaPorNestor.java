package p3Arboles;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import p3Arboles.AVLNode;
import p3Arboles.AVLTree;
import p3Arboles.AbstractTreeNode;
/**
 * Clase test AVL pedida por Nestor
 * @author Carmen Méndez Camino [UO299841]
 *
 */
public class AVLTestSesion10PedidaPorNestor {
	
	//Desequilibrios posibles del borrado
	@Test
	void testAvlRemove1( ) { //[-2 , -1]
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(4);
		avl.addNode(3);
		avl.addNode(5); //nodo a borrar
		avl.addNode(2);
		
		System.out.println("AVL antes del borrado [-2;-1]");
		System.out.print(avl.toString());
		
		avl.removeNode(5);
		
		//assertEquals(avl.removeNode(5),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [-2;-1]");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove2( ) { //[-2 , 0]
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(8);
		avl.addNode(2);
		avl.addNode(10);
		avl.addNode(1);
		avl.addNode(3);
		
		System.out.println("AVL antes del borrado [-2;0]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(10),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [-2;0]");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove3( ) { //[-2 , 1] si
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(50);
		avl.addNode(25);
		avl.addNode(75);
		avl.addNode(10);
		avl.addNode(30);
		avl.addNode(5);
		
		System.out.println("AVL antes del borrado [-2;1]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(30),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [-2;1]");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove4( ) { //[2 , -1] //check
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(50);
		avl.addNode(25);
		avl.addNode(75);
		avl.addNode(30);
		avl.addNode(24);
		avl.addNode(26);
		
		System.out.println("AVL antes del borrado [2;-1]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(24),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [2;-1]");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove5( ) { //[2 , 0]
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(8);
		avl.addNode(7);
		avl.addNode(10);
		avl.addNode(9);
		avl.addNode(11);
		
		System.out.println("AVL antes del borrado [2;0]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(7),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [2;0]");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove6( ) { //[2 , 1] check
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(50);
		avl.addNode(25);
		avl.addNode(75);
		avl.addNode(10);
		avl.addNode(30);
		avl.addNode(60); //nodo a borrar
		avl.addNode(90);
		avl.addNode(95);
		
		System.out.println("AVL antes del borrado [2;1]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(60),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado [2;1]");
		System.out.print(avl.toString());
	}
	
	//Desequilibrio de los casos de borrado respecto número de hijos
	
	@Test
	void testAvlRemove7( ) { //Sin hijos
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(20);
		avl.addNode(15); //nodo a borrar
		avl.addNode(25);
		avl.addNode(30);
		
		System.out.println("AVL antes del borrado [Se va a borrar un nodo sin hijos]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(15),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove8( ) { //Un hijo a la izquierda
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(9);
		avl.addNode(7); //nodo a borrar
		avl.addNode(13);
		avl.addNode(6); 
		avl.addNode(12);
		avl.addNode(15);
		avl.addNode(14);
		
		System.out.println("AVL antes del borrado [Se va a borrar un nodo con un hijo a la izquierda]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(7),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove9( ) { //Un hijo a la derecha
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(20);
		avl.addNode(17); //nodo a borrar
		avl.addNode(25);
		avl.addNode(18);
		avl.addNode(24);
		avl.addNode(28);
		avl.addNode(27);
		
		System.out.println("AVL antes del borrado [Se va a borrar un nodo con un hijo a la derecha]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(17),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado");
		System.out.print(avl.toString());
	}
	
	@Test
	void testAvlRemove10( ) { //Dos hijos
		AVLTree avl = new AVLTree();
		
		//adds
		avl.addNode(7);
		avl.addNode(3); //nodo a borrar
		avl.addNode(12);
		avl.addNode(2);
		avl.addNode(4);
		avl.addNode(11);
		avl.addNode(15);
		avl.addNode(16);
		
		System.out.println("AVL antes del borrado [Se va a borrar un nodo con dos hijos]");
		System.out.print(avl.toString());
		
		assertEquals(avl.removeNode(3),true);
		
		//avl.toString();
		System.out.println("AVL después del borrado");
		System.out.print(avl.toString());
	}
}
