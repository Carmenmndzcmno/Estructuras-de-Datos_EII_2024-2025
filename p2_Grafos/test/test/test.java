package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import p2Grafos.ElementNotPresentException;
import p2Grafos.Graph;

class test {

	@Test
	void testGraph() {
		Graph<Integer> graph = new Graph<Integer>(5);

		// Add Node
		assertEquals(graph.addNode(1), true);
		assertEquals(graph.addNode(2), true);
		assertEquals(graph.addNode(3), true);
		assertEquals(graph.addNode(4), true);

		System.out.println(graph.toString());

		// Get Node
		assertEquals(graph.getNode(1), 0);
		assertEquals(graph.getNode(2), 1);
		assertEquals(graph.getNode(3), 2);
		assertEquals(graph.getNode(4), 3);

		// Exists Node
		assertEquals(graph.existsNode(1), true);
		assertEquals(graph.existsNode(2), true);
		assertEquals(graph.existsNode(3), true);
		assertEquals(graph.existsNode(8), false);

		// Add Edge
		assertEquals(graph.addEdge(1, 2, 5), true);
		assertEquals(graph.addEdge(4, 4, 3), true);

		System.out.println(graph.toString());

		// Exists Edge
		assertEquals(graph.existsEdge(1, 2), true);
		assertEquals(graph.existsEdge(2, 3), false);
		assertEquals(graph.existsEdge(4, 3), false);
		assertEquals(graph.existsEdge(4, 4), true);

		// Remove Edge
		assertEquals(graph.removeEdge(1, 2), true);

		System.out.println(graph.toString());

		// Remove Node
		assertEquals(graph.removeNode(2), true);

		System.out.println(graph.toString());

		assertEquals(graph.removeNode(3), true);
		assertEquals(graph.removeNode(4), true);
		assertEquals(graph.removeNode(1), true);

		System.out.println(graph.toString());
	}

	@Test
	public void testInicializarD() {
		Graph<Integer> graph = new Graph<Integer>(7);
		// Add Node
		assertEquals(graph.addNode(1), true);
		assertEquals(graph.addNode(2), true);
		assertEquals(graph.addNode(3), true);
		assertEquals(graph.addNode(4), true);
		assertEquals(graph.addNode(5), true);
		assertEquals(graph.addNode(6), true);

		// Add Edge
		assertEquals(graph.addEdge(1, 2, 4), true);
		assertEquals(graph.addEdge(1, 3, 2), true);
		assertEquals(graph.addEdge(2, 4, 5), true);
		assertEquals(graph.addEdge(3, 2, 5), true);
		assertEquals(graph.addEdge(3, 4, 8), true);
		assertEquals(graph.addEdge(3, 5, 10), true);
		assertEquals(graph.addEdge(4, 6, 6), true);
		assertEquals(graph.addEdge(4, 5, 2), true);
		assertEquals(graph.addEdge(5, 6, 2), true);

		System.out.println(graph.toString());

		// Inicializar Vector de Coste D
		double[] coste = { 0, 4, 2, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };
		
		assertArrayEquals(graph.inicializarVectorCoste(graph.size, 1), coste, 0.5);

		System.out.println(graph.toString());
	}

	@Test
	public void testFloyd() {
		Graph<Integer> graph = new Graph<Integer>(5);
		// Add Node
		assertEquals(graph.addNode(1), true);
		assertEquals(graph.addNode(2), true);
		assertEquals(graph.addNode(3), true);
		assertEquals(graph.addNode(4), true);
		assertEquals(graph.addNode(5), true);

		// Add Edge
		assertEquals(graph.addEdge(1, 2, 5), true);
		assertEquals(graph.addEdge(1, 3, 1), true);
		assertEquals(graph.addEdge(2, 4, 3), true);
		assertEquals(graph.addEdge(3, 5, 2), true);
		assertEquals(graph.addEdge(4, 1, 6), true);
		assertEquals(graph.addEdge(4, 5, 4), true);

		System.out.println(graph.toString());

		graph.floyd();

		double[][] a = { { 0, 5, 1, 8, 3 }, { 9, 0, 10, 3, 7 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 2 },
				{ 6, 11, 7, 0, 4 }, { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
						Double.POSITIVE_INFINITY, 0 } };
		int[][] p = { { -1, -1, -1, 1, 2 }, { 3, -1, 3, -1, 3 }, { -1, -1, -1, -1, -1 }, { -1, 0, 0, -1, -1 },
				{ -1, -1, -1, -1, -1 } };
		assertArrayEquals(graph.getFloydP(), p);

		assertArrayEquals(graph.getFloydA(), a);

		assertEquals(graph.path(5, 1), "5\t(Infinity)\t1");
		assertEquals(graph.path(2, 2), "2\t");
		assertEquals(graph.path(8, 1), "");

	}

	@Test
	public void testFloydBucles() {
		Graph<Integer> graph = new Graph<Integer>(3);
		// Add Node
		assertEquals(graph.addNode(1), true);
		assertEquals(graph.addNode(2), true);
		assertEquals(graph.addNode(3), true);

		// Add Edge
		assertEquals(graph.addEdge(1, 2, 1), true);
		assertEquals(graph.addEdge(1, 1, 7), true);

		assertEquals(graph.addEdge(2, 1, 9), true);
		assertEquals(graph.addEdge(2, 3, 3), true);

		assertEquals(graph.addEdge(3, 1, 2), true);
		
		System.out.println(graph.toString());

		graph.floyd();

		double[][] a = { { 0, 1, 4 }, { 5, 0, 3 }, { 2, 3, 0 } };
		int[][] p = { { -1, -1, 1 }, { 2, -1, -1 }, { -1, 0, -1 } };
		assertArrayEquals(graph.getFloydP(), p);

		assertArrayEquals(graph.getFloydA(), a);
	}

	@Test
	public void testFloydPathRecursivo() {
		Graph<Integer> graph = new Graph<Integer>(5);
		// Add Node
		assertEquals(graph.addNode(1), true);
		assertEquals(graph.addNode(2), true);
		assertEquals(graph.addNode(3), true);
		assertEquals(graph.addNode(4), true);
		assertEquals(graph.addNode(5), true);

		// Add Edge
		assertEquals(graph.addEdge(1, 2, 5), true);
		assertEquals(graph.addEdge(1, 3, 1), true);
		assertEquals(graph.addEdge(2, 4, 3), true);
		assertEquals(graph.addEdge(3, 5, 2), true);
		assertEquals(graph.addEdge(4, 1, 6), true);
		assertEquals(graph.addEdge(4, 5, 4), true);

		System.out.println(graph.toString());

		graph.floyd();

		assertEquals(graph.path(2, 3), "2	(3.0)	4	(6.0)	1	(1.0)	3");
		
		System.out.println(graph.path(2, 3));
	}

	@Test
	public void testAddNodeException() {
		// Creamos un vector de nodos con tama�o 2
		Graph<Integer> graph = new Graph<Integer>(2);

		// Caso 1 - A�adimos el nodo al vector
		Assert.assertTrue(graph.addNode(1));
		Assert.assertEquals(0, graph.getNode(1));
		Assert.assertTrue(graph.existsNode(1));

		// Caso 2 - A�adimos null al vector
		try {
			graph.addNode(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testRemoveNode() {

		Graph<Integer> graph2 = new Graph<Integer>(4);
		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);

		graph2.addEdge(1, 2, 2);
		graph2.addEdge(1, 3, 1);
		graph2.addEdge(3, 2, 4);
		System.out.print("BORRAR NODO\n  Grafo2 completo Inicial-->" + graph2.toString());

		// Caso 2: Borro el �ltimo nodo
		Assert.assertEquals(true, graph2.removeNode(4));

		System.out.print("Tras BORRAR 4 \n Grafo2 completo Final-->" + graph2.toString());

		// Caso 2: Borro todos los nodos
		Assert.assertEquals(true, graph2.removeNode(1));
		System.out.print("BORRAR NODO 1\n Grafo2 completo Final-->" + graph2.toString());

		Assert.assertEquals(true, graph2.removeNode(2));
		System.out.print("BORRAR NODO 2\n Grafo2 completo Final-->" + graph2.toString());

		// Caso 4: El 3 es el unico nodo
		Assert.assertEquals(true, graph2.removeNode(3));
		System.out.print("BORRAR NODO 3\n Grafo2 completo Final-->" + graph2.toString());

		// Caso 5:Caso que nodo nulo

		try {
			graph2.removeNode(null);
			fail();
		} catch (NullPointerException e) {
		}

	}

	@Test
	public void testExistEdge() {
		Graph<Integer> graph = new Graph<Integer>(5);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 5, 10);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 3, 2);

		// Los caminos existen
		Assert.assertTrue(graph.existsEdge(1, 2));
		Assert.assertTrue(graph.existsEdge(1, 5));
		Assert.assertTrue(graph.existsEdge(2, 3));
		Assert.assertTrue(graph.existsEdge(3, 5));
		Assert.assertTrue(graph.existsEdge(4, 3));
		// Los caminos no existen
		Assert.assertFalse(graph.existsEdge(1, 1));
		Assert.assertFalse(graph.existsEdge(1, 3));
		// Alguno de los nodos no existe

		Assert.assertFalse(graph.existsEdge(5, 6));
		Assert.assertFalse(graph.existsEdge(6, 5));
	}

	@Test
	public void testGetNode() {
		// Creamos un vector de nodos con tama�o 2
		Graph<Integer> graph = new Graph<Integer>(2);
		Assert.assertEquals(graph.addNode(1), true);
		Assert.assertEquals(graph.addNode(2), true);

		// Caso 1 - El nodo existe
		Assert.assertEquals(graph.getNode(2), 1);

		// Caso 2 - El nodo no existe
		Assert.assertEquals(graph.getNode(3), -1);

	}

	@Test
	public void testGetEdge() {
		// Creamos un vector de nodos con tama�o 2
		Graph<Integer> graph = new Graph<Integer>(2);
		graph.addNode(1);
		graph.addNode(2);

		// Caso 1 - No existe la arista
		Assert.assertEquals(graph.getEdge(1, 2), -1, 0.0);

		// Caso existe la arista
		graph.addEdge(1, 2, 3);
		Assert.assertEquals(graph.getEdge(1, 2), 3, 0.0);

		// Caso 2 - No existe ninguno de los dos nodos

		try {
			graph.getEdge(0, 3);
			fail();
		} catch (ElementNotPresentException e) {
		}

	}

	@Test
	public void testExistNode() {
		// Creamos un vector de nodos con tama�o 2
		Graph<Integer> graph = new Graph<Integer>(2);
		graph.addNode(1);
		graph.addNode(2);

		// Caso 1 - El nodo existe
		Assert.assertTrue(graph.existsNode(2));

		// Caso 2 - El nodo no existe
		Assert.assertFalse(graph.existsNode(5));

	}

	@Test
	public void testAddEdge() {
		Graph<Integer> graph = new Graph<Integer>(5);

		// No hay nodos
		// try { graph.addEdge(1, 2, 1); fail();}
		// catch (ElementNotPresentException e) { }

		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		Assert.assertTrue(graph.addEdge(1, 2, 1));
		;
		Assert.assertTrue(graph.addEdge(1, 5, 10));
		Assert.assertTrue(graph.addEdge(1, 4, 3));
		Assert.assertTrue(graph.addEdge(2, 3, 5));
		Assert.assertTrue(graph.addEdge(2, 2, 4));
		Assert.assertTrue(graph.addEdge(3, 5, 1));
		Assert.assertTrue(graph.addEdge(4, 3, 2));

		// Peso negativo
		try {
			graph.addEdge(4, 3, -6);
			fail();
		} catch (IllegalArgumentException e) {
		}

		System.out.print("A�ADIR ARISTA \n Grafo completo-->" + graph.toString());

		// Los nodos y el camino existe
		Assert.assertEquals(1.0, graph.getEdge(1, 2), 0.0);
		Assert.assertTrue(graph.existsEdge(1, 2));
		Assert.assertEquals(10.0, graph.getEdge(1, 5), 0.0);
		Assert.assertTrue(graph.existsEdge(1, 5));
		Assert.assertEquals(3.0, graph.getEdge(1, 4), 0.0);
		Assert.assertTrue(graph.existsEdge(1, 4));
		Assert.assertEquals(5.0, graph.getEdge(2, 3), 0.0);
		Assert.assertTrue(graph.existsEdge(2, 3));
		Assert.assertEquals(4.0, graph.getEdge(2, 2), 0.0);
		Assert.assertTrue(graph.existsEdge(2, 2));
		Assert.assertEquals(1.0, graph.getEdge(3, 5), 0.0);
		Assert.assertTrue(graph.existsEdge(3, 5));
		Assert.assertEquals(2.0, graph.getEdge(4, 3), 0.0);
		Assert.assertTrue(graph.existsEdge(4, 3));

		// Caso de a�adir una arista que ya existe
		Assert.assertFalse(graph.addEdge(4, 3, 2));
	}

	@Test
	public void testRemoveEdge() {
		Graph<Integer> graph = new Graph<Integer>(5);
		Assert.assertEquals(graph.addNode(1), true);
		Assert.assertEquals(graph.addNode(2), true);
		Assert.assertEquals(graph.addNode(3), true);
		Assert.assertEquals(graph.addNode(4), true);
		Assert.assertEquals(graph.addNode(5), true);
		Assert.assertEquals(graph.addEdge(1, 2, 1), true);
		Assert.assertEquals(graph.addEdge(1, 5, 10), true);
		Assert.assertEquals(graph.addEdge(2, 3, 5), true);
		Assert.assertEquals(graph.addEdge(3, 5, 1), true);
		Assert.assertEquals(graph.addEdge(4, 3, 2), true);

		System.out.print("BORRAR ARISTA \n Grafo completo inicial-->" + graph.toString());

		// Caso 2 - la arista no existe pero si los nodos
		Assert.assertEquals(false, graph.removeEdge(1, 1));
		Assert.assertEquals(false, graph.removeEdge(1, 3));

		// Caso 3 - Los nodos no existen
		try {
			graph.removeEdge(null, 2);
			fail();
		} catch (ElementNotPresentException e) {
		}
	}

}
