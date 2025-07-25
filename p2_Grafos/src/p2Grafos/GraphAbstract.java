package p2Grafos;


import java.text.DecimalFormat;

/**
 * @author Profesores ED
 * @version 2024-25 Sesion 3
 */
public abstract class GraphAbstract<T> {
	protected T[] nodes; // Vector de nodos
	/**
	 * Matriz de aristas
	 */
	protected boolean[][] edges; // matriz de aristas
	/**
	 * Matriz de pesos
	 */
	protected double[][] weights; // matriz de pesos

	/**
	 * Numero de elementos en un momento dado
	 */
	public int size; // numero de elementos en un momento dado


	/**
	 * 
	 * @param tam
	 *            Numero maximo de nodos del grafo
	 */
	@SuppressWarnings("unchecked")
	public GraphAbstract(int tam) {
		nodes = (T[]) new Object[tam];
		size = 0;
	}

	/**
	 * @return Devuelve un String con la informacion del grafo (incluyendo matrices de Floyd)
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "NODES\n";
		for (int i = 0; i < size; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nEDGES\n";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (edges[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			}
			cadena += "\n";
		}
		cadena += "\nWEIGHTS\n";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				cadena += (edges[i][j]?df.format(weights[i][j]):"-") + "\t";
			}
			cadena += "\n";
		}

		return cadena;
	}

}
