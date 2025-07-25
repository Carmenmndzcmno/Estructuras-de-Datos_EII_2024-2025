package p2Grafos;

/**
 * Clase de datos para Dijkstra
 * @author Nestor; Carmen M�ndez Camino [UO299841] (Alumna)
 * @version 2024-25
 */
public class DijkstraDataClass {
	
	int nodeIndex;
	double dDijkstra[];// Vector D de Dijkstra
	int pDijkstra[]; // Vector P de Dijkstra
	/**
	 * Constructor que tiene como par�metros nNodes e index
	 * @param nNodes: n�mero de nodos
	 * @param index: �ndice
	 */
	public DijkstraDataClass(int nNodes, int index) {
		nodeIndex = index;
		dDijkstra = new double[nNodes]; // Vector D de Dijkstra
		pDijkstra = new int[nNodes]; // Vector P de Dijkstra
	}
	/**
	 * Constructor que tiene como par�metros nNodes,d, p e index
	 * @param nNodes: n�mero de nodos
	 * @param index: �ndice
	 * @param d: vector de pesos
	 * @param p: vector de caminos
	 */
	public DijkstraDataClass(int nNodes, int index, double[] d, int[] p) {
		this(nNodes, index);
		setdDijkstra(d);
		setpDijkstra(p);
	}
	/**
	 * Getter para el �ndice de un nodo
	 * @return nodeIndex: �ndice del nodo
	 */
	public int getNodeIndex() {
		return nodeIndex;
	}
	/**
	 * Setter para el �ndice del nodo
	 * @param nodeIndex: nuevo �ndice
	 */
	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}
	/**
	 * Getter del vector de pesos
	 * @return dDijkstra: vector de pesos
	 */
	public double[] getdDijkstra() {
		return dDijkstra;
	}
	/**
	 * Setter del vector de pesos
	 * @param dDijkstra: nuevo vector de pesos
	 */
	public void setdDijkstra(double[] dDijkstra) {
		this.dDijkstra = dDijkstra;
	}
	/**
	 * Getter del vector de caminos
	 * @return pDijkstra: vector de caminos
	 */
	public int[] getpDijkstra() {
		return pDijkstra;
	}
	/**
	 * Setter de del vector de caminos
	 * @param pDijkstra: nuevo vector de caminos
	 */
	public void setpDijkstra(int[] pDijkstra) {
		this.pDijkstra = pDijkstra;
	}

}
