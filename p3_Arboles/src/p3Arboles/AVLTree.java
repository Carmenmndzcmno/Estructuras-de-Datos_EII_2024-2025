package p3Arboles;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase derivada de BSTree a√±adiendo funcionalidad de AVL
 * 
 * @author Profesores ED (Espa√±ol) ; Alumna: Carmen MÈndez Camino [UO299841]
 * @version 2024-25 distribuible
 */
public class AVLTree<T extends Comparable<T>> extends BSTree<T> { // desequilibrio(2.0) rot sim

	/**
	 * Constructor
	 */
	public AVLTree() {
		super();
	}

	/**
	 * Inserta un T que se le pasa como parametro. Si ya existe, no lo inserta y
	 * devuelve false Si recibe un nodo nulo, no lo inserta y lanza una
	 * NullPointerException
	 * 
	 * @param nodo: nodo que interesa insertar
	 * @return false: si el nodo ya existe; true: si se ha podido insertar
	 */
	public boolean addNode(T nodo) {
		if (nodo == null)
			throw new NullPointerException("Element to insert is null.");
		if (searchNode(nodo) != null)
			return false;

		setRoot(addNodeRecursivo(nodo, getRoot()));

		return true;
	}

	/**
	 * Inserta un T que se le pasa como parametro.
	 * 
	 * @param nodoAInsertar:  nodo que interesa insertar
	 * @param nodoReferencia: nodo en el que se encuentra el algoritmo
	 * @return new AVLNode<T>(nodoAInsertar): en el caso que no haya raiz;
	 *         nodoReferencia:
	 */
	private AVLNode<T> addNodeRecursivo(T nodoAInsertar, AVLNode<T> nodoReferencia) {

		if (nodoReferencia == null)
			return new AVLNode<T>(nodoAInsertar); // caso base

		if (nodoAInsertar.compareTo(nodoReferencia.getInfo()) > 0) {
			nodoReferencia.setRight(addNodeRecursivo(nodoAInsertar, nodoReferencia.getRight()));
			nodoReferencia = updateAndBalanceIfNecesary(nodoReferencia);

		} else if (nodoAInsertar.compareTo(nodoReferencia.getInfo()) < 0) {
			nodoReferencia.setLeft(addNodeRecursivo(nodoAInsertar, nodoReferencia.getLeft()));
			nodoReferencia = updateAndBalanceIfNecesary(nodoReferencia);

		} else if (nodoAInsertar.equals(nodoReferencia.getInfo())) // caso base: que el nodo ya exista
			throw new RuntimeException("El nodo ya existe.");

		return nodoReferencia;
	}

	/**
	 * @return devuelve el nodo raiz del arbol
	 */
	protected AVLNode<T> getRoot() {
		return (AVLNode<T>) super.getRoot();
	}

	/**
	 * se le pasa el arbol que se quiere actualizar Height, BF y balancear si fuese
	 * necesario y devuelve la raiz del arbol por si ha cambiado.
	 * 
	 * @param nodo: nodo en el que se comprueba la necesidad de balanceo
	 * @return nodo: raiz del arbol
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> nodo) {

		nodo.updateHeight();

		if (nodo.getBF() == -2) { // Desbalance hacia la izquierda

			if (nodo.getLeft().getBF() == 1) { // [-2, 1]

				nodo = doubleLeftRotation(nodo);

			} else if (nodo.getLeft().getBF() <= 0) { // Demas casos: -1/0

				nodo = singleLeftRotation(nodo);
			}

		} else if (nodo.getBF() == 2) { // Desbalance hacia la derecha

			if (nodo.getRight().getBF() == -1) { // [2, -1]

				nodo = doubleRightRotation(nodo);

			} else if (nodo.getRight().getBF() >= 0) { // Demas casos: 1/0

				nodo = singleRightRotation(nodo);
			}
		}

		return nodo;
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion simple devuelve la raiz
	 * del nuevo arbol que ha cambiado
	 * 
	 * @param nodo: raiz del arbol
	 * @return auxiliar: nueva raiz del arbol
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		// nodo es la raiz

		// creamos un arbol/nodo auxiliar que sea el subarbol izquierdo del nodo
		AVLNode<T> auxiliar = nodo.getLeft();

		// nodo n por la izq = subarbol izq de aux
		nodo.setLeft(auxiliar.getRight());

		// aux por la der =nodo n
		nodo.updateHeight();
		auxiliar.setRight(nodo);
		auxiliar.updateHeight();

		return auxiliar;
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion doble devuelve la raiz
	 * del nuevo arbol que ha cambiado
	 * 
	 * @param nodo: raiz del arbol
	 * @return singleLeftRotation(nodo): metodo que devolvera la nueva raiz
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion simple devuelve la raiz
	 * del nuevo arbol que ha cambiado
	 * 
	 * @param nodo: raiz del arbol
	 * @return auxiliar: nueva raiz del arbol
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		// creamos un arbol auxiliar que sea el subarbol derecho del nodo
		AVLNode<T> auxiliar = nodo.getRight();

		// nodo n por la derecha = subarbol derecho de aux
		nodo.setRight(auxiliar.getLeft());
		nodo.updateHeight();

		// aux por la izquierda = nodo n
		auxiliar.setLeft(nodo);
		auxiliar.updateHeight();

		return auxiliar;
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion doble Devuelve la raiz
	 * del nuevo arbol que ha cambiado
	 * 
	 * @param nodo: raiz del arbol
	 * @return singleRightRotation(nodo): metodo que devuelva la nueva raiz del
	 *         arbol
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);
	}

	/**
	 * Si existe, borra el nodo deseado y devuelve true Si el nodo no existe
	 * devuelve false. Si recibe un nodo nulo, lanza una NullPointerException
	 * 
	 * @param nodo: nodo a borrar
	 * @return true: si se logra borrar; false: si no existe el nodo
	 */
	public boolean removeNode(T nodo) {
		if (nodo == null)
			throw new NullPointerException("Element to remove is null.");

		AVLNode<T> nuevaRaiz = removeNodeRecursivo(nodo, getRoot());
		if (nuevaRaiz != null) {
			setRoot(nuevaRaiz);
			return true;
		} else
			return false;
	}

	/**
	 * Si existe, borra el nodo deseado.
	 * 
	 * @param nodo:  nodo que se quiere borrar
	 * @param nodoR: nodo en el que se encuentra el algoritmo
	 * @return null: si actual es null; actual: caso general;
	 *         updateAndBalanceIfNecesary(actual): metodo que devolvera la raiz del
	 *         arbol
	 */
	private AVLNode<T> removeNodeRecursivo(T nodo, AVLNode<T> actual) {

		// Caso base
		if (actual == null)
			return null;

		// Caso general
		if (nodo.compareTo((actual).getInfo()) < 0) {
			actual.setLeft(removeNodeRecursivo(nodo, actual.getLeft()));
			actual = updateAndBalanceIfNecesary(actual);
			return actual;
		} else if (nodo.compareTo((actual).getInfo()) > 0) {
			actual.setRight(removeNodeRecursivo(nodo, actual.getRight()));
			actual = updateAndBalanceIfNecesary(actual);
			return actual;

		} else {
			if (actual.getLeft() == null && actual.getRight() == null)
				return null;
			else if (actual.getRight() == null) {
				return actual.getLeft(); // Devuelve directamente el subarbol izquierdo
			} else if (actual.getLeft() == null) {
				return actual.getRight(); // Devuelve directamente el subarbol derecho
			} else if (actual.getLeft() != null && actual.getRight() != null) {
				AVLNode<T> aux = getNodoMayor(actual.getLeft());
				actual.setInfo(aux.getInfo());
				actual.setLeft(removeNodeRecursivo(aux.getInfo(), actual.getLeft()));
			}

		}

		return updateAndBalanceIfNecesary(actual);
	}

	/**
	 * Obtiene el nodo mayor de forma recursiva dentro de un arbol.
	 * 
	 * @param nodo: nodo en el que se encuentra el algoritmo
	 * @return nodo: caso base;getNodoMayor(nodo.getRight()): se aplica recursividad
	 *         para seguir buscando.
	 */
	private AVLNode<T> getNodoMayor(AVLNode<T> nodo) {
		if (nodo.getRight() == null)
			return nodo;
		return getNodoMayor(nodo.getRight());
	}

	/**
	 ****************************************************************************************
	 ************************** MÈtodos de Repaso Antes del Examen **************************
	 ****************************************************************************************
	 * getAncestros	getAncestrosRecursivo
	 * getBFMedio	getBFMedioRecursivo
	 */

	// obtener Ancestros
	public List<T> getAncestros(T elem) {
		List<T> ancestros = new ArrayList<>();
		getAncestrosRecursivo(getRoot(), elem, ancestros);
		return ancestros;

	}

	private boolean getAncestrosRecursivo(AVLNode<T> actual, T nodo, List<T> ancestros) {
		if (actual == null)
			return false; // el nodo no se encuentra

		if (nodo.compareTo(actual.getInfo()) == 0)
			return true; // se ha econtrado el nodo

		// si el nodo es menor de actual el caso base estara a la izq
		if (nodo.compareTo(actual.getInfo()) < 0) {
			if (getAncestrosRecursivo(actual.getLeft(), nodo, ancestros)) {
				ancestros.add(actual.getInfo());
				return true;
			}
		} else if (nodo.compareTo(actual.getInfo()) > 0) {
			if (getAncestrosRecursivo(actual.getRight(), nodo, ancestros)) {
				ancestros.add(actual.getInfo());
				return true;
			}
		}
		
		return false;
	}
	
	//obtener bf medio
	public double getBFMedio() {
		if(getRoot()==null) return 0; //si el arbol esta vacio no hay bf
		
		double sumatorio = 0;
		int numNodos = 0;
		
		getBFMedioRecursivo(getRoot(), sumatorio, numNodos);
		
		double resultado = sumatorio/numNodos;
		
		return resultado;
		
	}

	private void getBFMedioRecursivo(AVLNode<T> nodo, double sumatorio, int numNodos) {
		if (nodo!=null) {
			sumatorio = nodo.getBF();
			numNodos++;
			getBFMedioRecursivo(nodo.getLeft(),sumatorio,numNodos);
			getBFMedioRecursivo(nodo.getRight(),sumatorio,numNodos);
		}
		
	}
}
