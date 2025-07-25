package p3Arboles;

/**
 * @author Prodesores ED (EspaÃ±ol) ; Alumna: Carmen Méndez Camino [UO299841]
 * @version 2024-25 distribuible
 */
public class BSTree<T extends Comparable<T>> extends AbstractTree<T> {

	/**
	 * getter del nodo raiz del arbol
	 */
	protected BSTNode<T> getRoot() {
		return (BSTNode<T>) super.getRoot();
	}

	/**
	 * Se le pasa el objeto comparable que hay que insertar devuelve true si lo
	 * inserta Si ya existe, no lo inserta y devuelve false (implementado mas
	 * tarde). Si recibe un nodo nulo, no lo inserta y lanza una
	 * NullPointerException
	 * 
	 * @param nodo: nodo que se quiere insertar
	 * @return false: si ya existe; true: si se ha logrado insertar
	 */
	public boolean addNode(T nodo) {
		if (nodo == null)
			throw new NullPointerException("Element to insert is null.");
		if (searchNode(nodo) != null)
			return false;

		setRoot(recursiveAddNode(getRoot(), nodo));

		return true;
	}

	/**
	 * Se le pasa el objeto comparable que hay que insertar y un BSTNode que será
	 * por donde va el algoritmo recursivamente
	 * 
	 * @param actual: BSTNode en el que se encuentra el algoritmo
	 * @param nuevo:  nodo que se quiere añadir
	 * @return BSTNode<T>(nuevo): nodo nuevo; actual: raiz del arbol
	 */
	private BSTNode<T> recursiveAddNode(BSTNode<T> actual, T nuevo) {

		if (actual == null) { // ->Caso Base
			return new BSTNode<T>(nuevo);
		} else if (nuevo.compareTo(actual.getInfo()) > 0) {
			actual.setRight(recursiveAddNode(actual.getRight(), nuevo));
		} else if (nuevo.compareTo(actual.getInfo()) < 0) {
			actual.setLeft(recursiveAddNode(actual.getLeft(), nuevo));
		}

		return actual; // porque asi devuelve la raíz balanceada
	}

	/**
	 * Se le pasa un objeto comparable que se busca Devuelve el objeto encontrado
	 * que cumple que es "equals" con el buscado, null si no lo encuentra por
	 * cualquier motivo
	 * 
	 * @param nodo: nodo que se quiere buscar
	 * @return null: si el nodo es null; recursiveSearchNode(getRoot(), nodo):
	 *         metodo que busca el nodo recursivamente
	 */
	public T searchNode(T nodo) {
		if (nodo == null)
			return null;

		return recursiveSearchNode(getRoot(), nodo);
	}

	/**
	 * Se le pasa un objeto comparable que se busca. Devuelve el objeto encontrado
	 * que cumple que es "equals" con el buscado, null si no lo encuentra por
	 * cualquier motivo
	 * 
	 * @param actual: nodo en el que se encuentra el algoritmo
	 * @param nodo: nodo que se esta buscando
	 * @return null: si actual no existe o si no se ha logrado buscar el nodo;actual.getInfo(): informacion del objeto que se busca; recursiveSearchNode(actual.getLeft(), nodo): busqueda del nodo recursivamente;
	 */
	private T recursiveSearchNode(BSTNode<T> actual, T nodo) {
		// Caso base
				if (actual == null)
					return null;
				if (actual.getInfo().equals(nodo))
					return actual.getInfo();

				// Caso general
				if (nodo.compareTo(actual.getInfo()) < 0)
					return recursiveSearchNode(actual.getLeft(), nodo);
				if (nodo.compareTo(actual.getInfo()) > 0)
					return recursiveSearchNode(actual.getRight(), nodo);
				return null;
	}

	/**
	 * Genera un String con el recorrido en pre-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @return preOrderR(getRoot()): metodo recursivo para conseguir el preOrder
	 */
	public String preOrder() { // raiz izq der
		return preOrderR(getRoot());
	}
	/**
	 * Genera un String con el recorrido en pre-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @param node: nodo que se va a colocar en el string
	 * @return nodo.toString() +"\t"+ preOrderR(nodo.getLeft()) + preOrderR(nodo.getRight()): recursividad;"": si el nodo es null
	 */
	private String preOrderR(BSTNode<T> nodo) {
		if (nodo == null)
			return "";
		return nodo.toString() +"\t"+ preOrderR(nodo.getLeft()) + preOrderR(nodo.getRight());
	}

	/**
	 * Genera un String con el recorrido en post-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @return postOrderR(getRoot()): metodo recursivo para conseguir el postOrder
	 */
	public String postOrder() { // subarbolizquierdo, + subarbol derecho + raiz
		return postOrderR(getRoot());
	}
	
	/**
	 * Genera un String con el recorrido en post-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @param node
	 * @return
	 */
	private String postOrderR(BSTNode<T> node) {
		if (node == null)
			return "";
		return postOrderR(node.getLeft()) + postOrderR(node.getRight()) + "\t" + node.toString();
	}

	/**
	 * Genera un String con el recorrido en in-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @return inOrderR(getRoot()); metodo recursivo para conseguir un string del arbol en inOrder
	 */
	public String inOrder() {
		return inOrderR(getRoot());
	}
	/**
	 * Genera un String con el recorrido en in-orden (izquierda-derecha) (toString
	 * de los nodos con un tabulador detras de cada nodo)
	 * @param node: nodo en el que se encuentra el algoritmo
	 * @return "": caso base;inOrderR(node.getLeft()) + "\t" + node.toString() + inOrderR(node.getRight()): recursividad del algoritmo
	 */
	private String inOrderR(BSTNode<T> node) { // subarbol izquierdo raiz subarbol der
		if (node == null)
			return "";
		return inOrderR(node.getLeft()) + "\t" + node.toString() + inOrderR(node.getRight());
	}

	/**
	 * Se le pasa el objeto que se quiere borrar que coincida con equals Si recibe
	 * un nodo nulo, lanza una NullPointerException Devuelve true si lo ha borrado,
	 * false caso contrario
	 * @param node: nodo que se quiere borrar
	 * @return false: si el nodo no existe; true: si se ha logrado borar el nodo
	 */
	public boolean removeNode(T node) {
		// lanzar excepción si no hay root
		if (node == null)
			throw new NullPointerException("Element to remove is null.");
		if (searchNode(node) == null)
			return false;
		setRoot(removeNodeRecursivo(node, getRoot()));
		return true;
	}
	
	/**
	 * Se le pasa el objeto que se quiere borrar de forma recursiva y un nodo con el que se harán comparaciones
	 * @param nodo: nodo que se quiere borrar
	 * @param actual: nodo en el que se encuentra el algoritmo
	 * @return null: caso base; actual/actual.getLeft()/actual.getRight(): aplicando recursividad
	 */
	private BSTNode<T> removeNodeRecursivo(T nodo, BSTNode<T> actual) { //FALLO

		// Caso base
				if (actual == null)
					return null;

				// Caso general
				else if (nodo.compareTo(actual.getInfo()) < 0)
					actual.setLeft(removeNodeRecursivo(nodo, actual.getLeft()));
				else if (nodo.compareTo(actual.getInfo()) > 0)
					actual.setRight(removeNodeRecursivo(nodo, actual.getRight()));
				else {
					if (actual.getLeft() != null && actual.getRight() != null) {
						BSTNode<T> aux = getNodoMayor(actual.getLeft());
						removeNode(aux.getInfo());
						actual.setInfo(aux.getInfo());
						return actual;
					} else if (actual.getLeft() == null && actual.getRight() == null)
						return null;
					else if (actual.getRight() == null)
						return actual.getLeft();
					else
						return actual.getRight();
					
				}
				
				return actual;
	}
	
	/**
	 * Obtiene el nodo mayor de forma recursiva dentro de un arbol.
	 * 
	 * @param nodo: nodo en el que se encuentra el algoritmo
	 * @return nodo: caso base;getNodoMayor(nodo.getRight()): se aplica recursividad
	 *         para seguir buscando.
	 */
	private BSTNode<T> getNodoMayor(BSTNode<T> nodo) {
		if (nodo.getRight() == null)
			return nodo;
		return getNodoMayor(nodo.getRight());
	}
	
	/**
	 ****************************************************************************************
	 ************************** Métodos de Repaso Antes del Examen **************************
	 ****************************************************************************************
	 * getLCI	getAltura	getNumNodosNivel	getAlturaRecursivo	getNumNodosNivelRecursivo
	 * getLCE	getNodosEspeciales	getNodosEspecialesRecursivo	getNodosEspecialesPorNivel	nodosMaxApoyo
	 * estaLleno getNumNodos getNumNodosRecursivo
	 */
	
	/**
	 * Obten el LCI (Longitud del Camino Interno) : es el sumatorio desde i=1 hasta la altura del árbol del número de nodos del nivel
	 * multiplicado por el nivel
	 */
	
	public int getLCI() {
		int h = getAltura();
		int sumatorio=0;
		int numNodosNivel;
		
		for (int i=1;i<=h;i++) {
			numNodosNivel=getNumNodosNivel(i);
			sumatorio= sumatorio + numNodosNivel*i;
		}
		
		return sumatorio;
	}

	public int getNumNodosNivel(int nivel) {
		return getNumNodosNivelRecursivo(getRoot(), nivel);
	}

	private int getNumNodosNivelRecursivo(BSTNode<T> nodo, int nivel) {
		if (nodo==null) return 0;
		else if (nivel==1) return 1;
		else return getNumNodosNivelRecursivo(nodo.getLeft(), nivel-1)+getNumNodosNivelRecursivo(nodo.getRight(), nivel-1);
	}

	public int getAltura() {
		return getAlturaRecursivo(getRoot());
	}

	private int getAlturaRecursivo(BSTNode<T> bstNode) {
		if (bstNode==null) {
			return 0; //no hay altura porque no hay arbol
		}
		
		int hIzq = getAlturaRecursivo(bstNode.getLeft());
		int hDer = getAlturaRecursivo(bstNode.getRight());
		
		if(hIzq>=hDer) return hIzq+1;
		else return hDer+1;
	}
	
	/**
	 * Obten el LCE (Longitud del Camino Externo): es el sumatorio desde i=2 hasta la altura + 1 del número de nodos
	 * especiales del nivel por el nivel del árbol Los nodos especiales tienen como objetivo remplazar las ramas vacías
	 * o nulas que pueden tener descendientes Cada nodo puede tener 2 hijos, salvo que sea un árbol binario, lógicamente
	 * LCE se marca como algo importante en la teoría ya que permite saber el número de decisiones que se pueden tomar
	 */
	
	public int getLCE() {
		int h = getAltura()+1;
		int sumatorio=0;
		int nodosEspeciales;
		
		for (int i=2;i<=h;i++) {
			nodosEspeciales = getNodosEspecialesPorNivel(i);
			sumatorio= sumatorio + nodosEspeciales*i;
		}
		
		return sumatorio;
	}
	
	//devuelve el numero de nodos especiales total
	public int getNodosEspeciales() {
		return getNodosEspecialesRecursivo(getRoot());
	}

	private int getNodosEspecialesRecursivo(BSTNode<T> nodo) {
		int especiales = 0;
		if (nodo==null) return especiales;
		
		//si el nodo podría tener un hijo, lo sumamos
		if(nodo.getLeft()==null) especiales++;
		else especiales = especiales+getNodosEspecialesRecursivo(nodo.getLeft());
		if(nodo.getRight()==null) especiales++;
		else especiales = especiales+getNodosEspecialesRecursivo(nodo.getRight());
		
		return especiales;
	}
	//devuelve el numero de nodos especiales por nivel
	public int getNodosEspecialesPorNivel(int nivel) {
		//Num max de nodos de ese nivel
		int nodosMax=nodosMaxApoyo(nivel);
		
		//nodos actuales
		int nodosActuales=getNumNodosNivel(nivel);
		int nodoEspeciales = 0;
		
		if(nivel==1) nodosMax=1;
		if(nivel==2) nodosMax=2;
		
		if(nodosActuales>=0) nodoEspeciales =nodosMax-nodosActuales;
		
		return nodoEspeciales;
	}
	
	private int nodosMaxApoyo(int nivel) {
		int x = getNumNodosNivel(nivel-1);
		int hijosPosibles = 0;
		for(int i=0;i<x;i++) hijosPosibles = hijosPosibles + 2;
		return hijosPosibles;
	}
	
	/**
	 * Comprueba si el árbol está lleno: se cumplirá que el número de nodos equivaldrá a elevar dos a la altura y
	 * restarle uno. También se cumplirá que la altura equivaldrá al logaritmo en base dos de el número de nodos +1
	 */
	public boolean estaLleno() {
		int numNodos = getNumNodos();
		int h = getAltura();
		
		if(numNodos==Math.pow(2, h)-1) return true;
		else return false;
	}

	public int getNumNodos() {
		return getNumNodosRecursivo(getRoot());
	}

	private int getNumNodosRecursivo(BSTNode<T> bstNode) {
		if (bstNode == null) return 0;
		return 1 + getNumNodosRecursivo(bstNode.getLeft())+ getNumNodosRecursivo(bstNode.getRight());
	}

}
