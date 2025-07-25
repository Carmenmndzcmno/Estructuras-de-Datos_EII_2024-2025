package p3Arboles;

/**
 * @author Nestor
 * @version 2024-25 distribuible
 * 
*/
public abstract class AbstractTree <T>{
	
	private AbstractTreeNode<T> raiz;
	
	/**
	 * Constructor
	 */
	public AbstractTree() {
		raiz = null;
	}

	
	/**
	 * @param nodo
	 *            Establece el parametro como nodo raiz del arbol
	 */
	protected void setRoot(AbstractTreeNode<T> nodo) {
		raiz = nodo;
	}

	
	/**
	 * @return devuelve el nodo raiz del arbol
	 */
	protected AbstractTreeNode<T> getRoot() {
		return raiz;
	}

	
	/**
	 * Inserta un T que se le pasa como parametro.
	 * Si ya existe, no lo inserta y devuelve false 
	 * Si recibe un nodo nulo, no lo inserta y lanza una NullPointerException
	 *
	 * @param x: nodo a insertar
	 * @return boolean: segun si se inserta o no
	 */
	public abstract boolean addNode(T x);

	
	/**
	 * Devuelve un String con el recorrido en pre-orden
	 * se concatena el toString de cada nodo seguido de un tabulador
	 * @return String segun el preOrder que salga
	 */
	public abstract String preOrder();

	
	/**
	 * Devuelve un String con el recorrido en post-orden
	 * se concatena el toString de cada nodo seguido de un tabulador
	 * @return String segun el postOrder que salga
	 */
	public abstract String postOrder();
	
	
	/**
	 * Devuelve un String con el recorrido en in-orden
	 * se concatena el toString de cada nodo seguido de un tabulador
	 * @return String segun el inOrder que salga
	 */
	public abstract String inOrder();


	/**
	 * Si existe, borra el nodo deseado y devuelve true
	 * Si el nodo no existe devuelve false.
	 * Si recibe un nodo nulo, lanza una NullPointerException
	 * @param x: nodo que se desea borrar
	 * @return boolean segun si se borra o no
	 */
	public abstract boolean removeNode (T x);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() { //recorrido inorde
		return tumbarArbol(raiz, 0);
	}

	/**
	 * Genera un String con el arbol "tumbado" (la raiz a la izquierda y las ramas hacia la derecha)
	 * Es un recorrido InOrden-derecha-izquierda, tabulando para mostrar los distintos niveles
	 * Utiliza el toString de la referencia al nodo que se le pasa
	 *  
	 * @param p	La raiz del arbol a mostrar tumbado
	 * @param esp	El espaciado en numero de tabulaciones para indicar la profundidad
	 * @return	El String generado
	 */
	protected String tumbarArbol(AbstractTreeNode<T> p, int esp) {
		String cadena = "";

		if (p != null) {
			cadena += tumbarArbol(p.getRight(), esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += p + "\n";
			cadena += tumbarArbol(p.getLeft(), esp + 1);
		}
		return cadena;
	}
	

}
