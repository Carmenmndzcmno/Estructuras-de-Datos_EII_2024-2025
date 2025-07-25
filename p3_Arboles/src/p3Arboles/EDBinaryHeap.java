package p3Arboles;

/**
 * @author Profesores ED ; Alumna: Carmen Méndez Camino [UO299841]
 * @version 2024-25 distribuible
 */
public class EDBinaryHeap<T extends Comparable<T>> implements EDPriorityQueue<T> {
	protected T[] elementos; // hasta que no meta elementos no tiene elementos
	protected int numElementos;
	
	/**
	 * Constructor
	 * @param numMaxElementos numero maximo de elementos
	 */
	@SuppressWarnings("unchecked")
	public EDBinaryHeap(int numMaxElementos) {
		elementos = (T[]) new Comparable[numMaxElementos];
	}

	/**
	 * Se le pasa el elemento que se quiere insertar en la cola Lanza
	 * NullPointerException si el elemento a insertar es null con mensaje "Element
	 * to insert is null." devuelve true si consigue insertarlo, false en caso
	 * contrario
	 * 
	 * @param info: nodo que se quiere insertar
	 * @return false: si no se puede insertar el nodo; true: si se ha logrado
	 *         insertar
	 */
	@Override
	public boolean add(T info) {
		if (info == null)
			throw new NullPointerException("Element to insert is null.");

		if (info == null || numElementos >= elementos.length) {
			// si info es nulo o nos pasamos del número máximo de elementos devuelve falso
			return false;
		}

		elementos[numElementos] = info;
		filtradoAscendente(numElementos);
		numElementos++;
		return true;
	}

	/**
	 * devuelve y elimina el elemento con mayor prioridad (cima del monticulo), o
	 * null si no hay elementos
	 * @return null: si no hay elementos; minimo: elemento con mayor prioridad
	 */
	@Override
	public T poll() {
		if (numElementos==0) return null;
		
		T minimo = this.elementos[0];
		
		elementos[0]=elementos[numElementos-1];
		numElementos--;
		filtradoDescendente(0);
		
		return minimo;
	}
	
	/**
	 * Borra un elemento de la cola
	 * Lanza NullPointerException si el elemento a eliminar es null con mensaje "Element to remove is null."
	 * Se le pasa el elemento que se quiere eliminar de la cola
	 * devuelve true si estaba y lo elimina, false en caso contrario
	 * @param info: nodo que se quiere borrar de la cola
	 * @return false: si el elemento no existe; true; si se ha logrado borrar
	 */
	@Override
	public boolean remove(T info) { //Método 1
		if (info== null) throw new NullPointerException("Element to remove is null.");
		
		//Conseguir la determinada posicion
		int posicion = getPosicion(info);
		if (posicion==-1) return false; //el elemento no existe
		
		T original =elementos[posicion]; //guardamos el elemento original para luego las comparaciones
		
		
		//Colocar el ultimo elemento del vector en la posicion del elemento a borrar
		elementos[posicion]=elementos[numElementos-1];
		numElementos--;
		
		//SI el valor del ultimo elemento es menor que el original, se realiza un filtrado ascendente
		if(elementos[posicion].compareTo(original)<0) filtradoAscendente(posicion);
		//SI el valor del ultimo elemento es mayor que el original, filtrado descente
		else if (elementos[posicion].compareTo(original)>0) filtradoDescendente(posicion);
		
		return true;
	}
	/**
	 * Se obtiene la posicion de un nodo
	 * @param nodo: nodo del que se quiere obtener la posicion
	 * @return i: siendo la posicion del nodo; -1: si el nodo no existe
	 */
	private int getPosicion(T nodo) {
		for (int i = 0; i < numElementos; i++) {
			if (elementos[i]==null) break; //No hay donde buscar
			if (elementos[i].equals(nodo)) return i;
		}
		return -1; //Indice imposible
	}
	/**
	 * Indica si no hay ningun elemento
	 * @return true; si esta vacio; false; si no esta vacio
	 */
	@Override
	public boolean isEmpty() {
		if (numElementos == 0) return true;
		return false;
	}
	
	/**
	 * Elimina todos los elementos de la cola
	 */
	@Override
	public void clear() {
		for (int i = 0; i < numElementos; i++) {
			elementos[i]=null;
		}
		numElementos = 0;
	}

	/**
	 * Devuelve una cadena con la informacion de los elementos que contiene el
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)
	 */
	public String toString() {
		// Por ejemplo el arbol tumbado...
		StringBuilder cadena = new StringBuilder();
		cadena.append(inOrdenDerechaTabulado(0, 0));
		return cadena.toString();
	}

	// el arbol que empieza en indice p tumbado con esp tabulaciones...
	private String inOrdenDerechaTabulado(int p, int esp) {
		String cadena = "";
		if (p < numElementos) {
			int izq = Math.abs(2 * p + 1);
			int der = Math.abs(2 * p + 2);
			cadena += inOrdenDerechaTabulado(der, esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += elementos[p] + "\n";
			cadena += inOrdenDerechaTabulado(izq, esp + 1);
		}
		return cadena;
	}

	/**
	 * Realiza una filtrado ascendente de minimos en el monticulo
	 * 
	 * Se le pasa el indice del elemento a filtrar
	 * 
	 * @param a : indice del elemento a filtrar
	 */
	protected void filtradoAscendente(int a) { // segun padre
		T actual = elementos[a];
		int posPaso = (a - 1) / 2;
		// boolean fin = true;

		
		while (posPaso >= 0) { // hace un while true
			T dePaso = elementos[posPaso];
			if (actual.compareTo(dePaso) >= 0)
				break; // si el padre es mayor hay intercambio
			elementos[a] = dePaso;
			elementos[posPaso] = actual;

			// actualizamo actual
			a = posPaso;
			actual = elementos[a];

			// actualizamos el nuevo padre
			if ((a - 1) / 2 >= 0)
				posPaso = (a - 1) / 2;

		}
	}

	/**
	 * Realiza una filtrado descendente de minimos en el monticulo
	 * 
	 * Se le pasa el indice del elemento a filtrar
	 * 
	 * @param a: indice del elemento a filtrar
	 */
	protected void filtradoDescendente(int a) { //vamos a trabajar con los indices
		 T actual = elementos[a];
		    int indActual = a;

		    // Mientras el nodo actual tenga al menos un hijo izquierdo se seguirá filtrando
		    while (2 * indActual + 1 < numElementos) {
		        int posHijoIzq = 2 * indActual + 1;
		        int posHijoDer = 2 * indActual + 2;
		        int posMenorHijo;

		        // Determinar cuál de los hijos es menor, si existen ambos
		        if (posHijoDer < numElementos && elementos[posHijoDer].compareTo(elementos[posHijoIzq]) < 0) { //Si existen ambos y el derecho es menor
		            posMenorHijo = posHijoDer;
		        } else { //El hijo menor será entonces el izquierdo
		            posMenorHijo = posHijoIzq;
		        }

		        // Comparar con el menor hijo
		        if (actual.compareTo(elementos[posMenorHijo]) > 0) { //Es el hijo menor, menor que el actual?
		            elementos[indActual] = elementos[posMenorHijo];
		            elementos[posMenorHijo] = actual;
		            indActual = posMenorHijo; // Actualizar el índice actual
		        } else {
		            break; // No se puede filtrar mas
		        }
		    }
	}
	/**
	 ****************************************************************************************
	 ************************** Métodos de Repaso Antes del Examen **************************
	 ****************************************************************************************
	 * encuentraMax
	 */

	//Devolver el máximo
	public T encuentraMax() {
		T max=elementos[numElementos/2];
		for(int i=(numElementos/2)+1;i<numElementos;i++) {
			if(max.compareTo(elementos[i])<0) max = elementos[i];
		}
		
		return max;
	}
	
	//Cambiar la prioridad
	public boolean cambiarPrioridad(T nodoACambiar, T prioridad) {
		int pos = getPosicion(nodoACambiar);
		
		if(pos<0) return false;
		
		elementos[pos]=prioridad;
		
		if(nodoACambiar.compareTo(prioridad)>0) filtradoAscendente(pos);
		else if(nodoACambiar.compareTo(prioridad)<0) filtradoDescendente(pos);
		
		return true;
		
	}
}
