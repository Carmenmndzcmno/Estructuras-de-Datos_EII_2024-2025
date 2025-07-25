package p4Hash;

/**
 * @author Profesores ED	; Alumna: Carmen Méndez Camino [UO299841]
 * @version 2024-25 distribuible
 * @param <T> T
 */
public class ClosedHashTable<T> extends AbstractHash<T> {
// IMPORTANTE
//	No cambiar el nombre ni visibilidad de los atributos protected

	protected HashNode<T> associativeArray[];

	protected int hashSize; // tamaÃ±o de la tabla, debe ser un numero primo (B de teoria)
	protected int numElems; // numero de elementos en la tabla en cada momento.

	public static final int LINEAL = 0; // Tipo de exploracion en caso de colision, por defecto sera LINEAL
	public static final int CUADRATICA = 1;
	public static final int DOBLEHASH = 2;

	protected int exploracion; // exploracion que se realizara en caso de colision (LINEAL por defecto)

	private static final double MIN_FC = 0.16;
	private static final double MAX_FC = 0.5;

	private double fcUP;
	private double fcDOWN;
	private double fc;

	/**
	 * Constructor para fijar el tamanio al numero primo >= que el parametro y el
	 * tipo de exploraciÃ³n al indicado el tipo de exploracion(LINEAL=0,
	 * CUADRATICA=1, ...), si invalido LINEAL
	 * @param tam = tamaño de la tabla
	 * @param expl = tipo de exploración
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int expl) {
		hashSize = nextPrimeNumber(tam);// Establece un tamanio valido si tam no es primo

		if (expl != 1 && expl != 2)
			exploracion = 0;
		else
			exploracion = expl;

		this.fcDOWN = MIN_FC;
		this.fcUP = MAX_FC;
		this.fc = 0;

		associativeArray = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's

		// inicializamos el array
		for (int i = 0; i < hashSize; i++) {
			HashNode<T> nodo = new HashNode<T>();
			associativeArray[i] = nodo;
		}

	}

	/**
	 * Constructor para fijar el tamanio al numero primo >= que el parametro Se le
	 * pasa el tamaÃ±o de la table Hash, si no es un numero primo lo ajusta al primo
	 * superior el factor de carga limite, por encima del cual hay que redispersar
	 * (directa) el factor de carga limite, por debajo del cual hay que redispersar
	 * (inversa) el tipo de exploracion(LINEAL=0, CUADRATICA=1, ...), si invalido
	 * LINEAL
	 * @param tam: tamaño de la tabla
	 * @param fcUP: factor de balance para aumentarla
	 * @param fcDOWN: factor de balance para reducirla
	 * @param expl: tipo de exploración
	 */
	public ClosedHashTable(int tam, double fcUP, double fcDOWN, int expl) {
		hashSize = nextPrimeNumber(tam);// Establece un tamanio valido si tam no es primo

		this.fcDOWN = fcDOWN;
		this.fcUP = fcUP;
		this.fc = 0;
		
		if(fcDOWN>fcUP) { //si los valores están al revés corregirlos
			this.fcDOWN=fcUP;
			this.fcUP=fcDOWN;
		}else if (fcDOWN==fcUP) { //si los valores no son válidos se corrigen
			this.fcDOWN=MIN_FC;
			this.fcUP=MAX_FC;
		}
			
		if (expl != 1 && expl != 2)
			exploracion = 0;
		else
			exploracion = expl;

		associativeArray = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's

		// inicializamos el array
		for (int i = 0; i < hashSize; i++) {
			HashNode<T> nodo = new HashNode<T>();
			associativeArray[i] = nodo;
		}

	}

	/**
	 * Devuelve el numero de elementos que contiene la tabla Hash en el momento de la invocacion
	 * @return numElems: número de elementos
	 */
	@Override
	public int getNumOfElems() {
		return numElems;
	}
	
	/**
	 * Devuelve el tamanio de la tabla Hash
	 * @return hashSize: tamaño de la tabla hash
	 */
	@Override
	public int getSize() {
		return hashSize;
	}

	/**
	 * Inserta un nuevo elemento en la tabla hash (que se le pasa) y devuelve true
	 * si lo ha insertado o false en caso contrario (si no encuentra sitio). Y
	 * NullPointer si el elemento es null
	 * @param elem: elemento a añadir
	 * @return true: si se consigue añadir el elemento; false: si no se consigue añadir
	 */
	@Override
	public boolean add(T elem) { // Se admiten numeros repetidos

		if (elem == null)
			throw new NullPointerException("Element to insert is null.");

		// encontrar la posicion
		// si no se puede añadir, funcion de exploracion (elemento, iteracion)
		// tras añadir comprobar si la hash se comporta como debe y aumentar numElms

		int posicion = fHash(elem);
		int iteracion = 0;

		HashNode<T> nodo = new HashNode<T>();

		do {
			if (associativeArray[posicion].getStatus() == HashNode.BORRADO
					|| associativeArray[posicion].getStatus() == HashNode.VACIO) { // se puede añadir

				nodo.setInfo(elem);
				associativeArray[posicion] = nodo;
				numElems++;

				if (actualizarFC() > getfcUP())
					reDispersion();

				return true;
			} else { // no se puede añadir por tanto buscamos una nueva iteracion
				posicion = fExploracion(elem, iteracion + 1);
				iteracion++;
			}
		} while (iteracion < hashSize);

		return false;
	}

	/**
	 * Devuelve el factor de balance más alto
	 * @return fcUP: factor de balance más alto
	 */
	private double getfcUP() {
		return fcUP;
	}

	/**
	 * Busca y devuelve el elemento (igual al que se le pasa) encontrado en la tabla
	 * hash o null si no lo encuentra
	 * @param elem: elemento a buscar
	 * @return associativeArray[posicion].getInfo(): elemento a buscar; null= si no lo encuentra
	 */
	@Override
	public T find(T elem) {
		if (elem == null)
			throw new NullPointerException("Element to find is null."); 

		// Busca EL nodo
		// ¿su posicion esta llena? ¿su informacion es la misma?
		// seguir buscando si hace falta

		// si se encuentra una celda vacia es que no esta el elemento

		int posicion = fHash(elem);
		int iteracion = 0;

		do {
			if (associativeArray[posicion].getStatus() == HashNode.LLENO
					&& associativeArray[posicion].getInfo().equals(elem)) { // se ha encontrado
				return associativeArray[posicion].getInfo();
			} else if (associativeArray[posicion].getStatus() == HashNode.VACIO) { // no se puede añadir por tanto
																					// buscamos una nueva iteracion
				break;
			} else {
				posicion = fExploracion(elem, iteracion);
				iteracion++;
			}
		} while (iteracion < hashSize);

		return null;
	}

	/**
	 * Borra un elemento (igual al que se le pasa) que se encuentra en la tabla hash
	 * Devuelve true si lo ha borrado o false en caso contrario (no existe). Y
	 * NUllPointer si el elemento es null
	 * @param elem: elemento a borrar
	 * @return true: si se ha logrado borrar; false: si no se ha logrado borrar
	 */
	@Override
	public boolean remove(T elem) {
		if (elem == null)
			throw new NullPointerException("Element to remove is null.");

		// Busca el nodo
		// ¿su posicion esta llena? ¿su informacion es la misma?
		// seguir buscando si hace falta
		// hasNode borrado si se encuentra
		// numElems--
		// si se encuentra una celda vacia es que no esta el elemento

		int posicion = fHash(elem);
		int iteracion = 0;
		do {
			if (associativeArray[posicion].getStatus() == HashNode.LLENO
					&& associativeArray[posicion].getInfo().equals(elem)) { // se ha encontrado
				associativeArray[posicion].remove(); // borrado perezoso
				numElems--;
				if (actualizarFC() < getFCDOWN())
					inverseReDispersion();
				return true;
			} else if (associativeArray[posicion].getStatus() == HashNode.VACIO) { // no se puede añadir por tanto
																					// buscamos una nueva iteracion
				break;
			} else {
				posicion = fExploracion(elem, iteracion + 1);
				iteracion++;
			}
		} while (iteracion < hashSize);

		return false;
	}
	
	/**
	 * Devuelve el fcDOWN
	 * @return fcDOWN: factor de carga menor
	 */
	private double getFCDOWN() {
		return fcDOWN;
	}

	/**
	 * Devuelve la posicion que le corresponde a la iteracion indicada en el
	 * parametro "iteracion", de la funcion de exploracion definida en la tabla
	 * (atributo exploracion), que le corresponde al elemento del parametro "elem".
	 * Notese que si la iteracion es 0, el resultado seria fHash(elem)
	 * 
	 * @param elem: elemento a devolver su posible futura posición
	 * @param iteracion: número de iteración
	 * @return fHash(elem): si es la primera iteración (número 0);-1: si por algún motivo hay algún error; posicion < 0 ? posicion + getSize() : posicion: posición a devolver
	 */
	protected int fExploracion(T elem, int iteracion) {
		if (iteracion == 0)
			return fHash(elem);
		int posicion = -1;
		switch (exploracion) {
		case LINEAL:
			posicion = (elem.hashCode() + iteracion) % getSize();
			break;
		case CUADRATICA:
			posicion = (elem.hashCode() + iteracion ^ 2) % getSize();
			break;
		case DOBLEHASH:
			posicion = (fHash(elem) + iteracion * h(elem)) % getSize();
			break;
		}
		if (posicion == -1)
			return -1;
		else
			return posicion < 0 ? posicion + getSize() : posicion;
	}

	/**
	 * Realiza una redispersion (aumentando el tamaño) al numero primo mayor que el
	 * doble del tamaño actual, recolocando los elementos, e indicando si lo realiza
	 * correctamente o no
	 * @return true: si se consigue redispersionar
	 */
	@SuppressWarnings("unchecked")
	protected boolean reDispersion() {
		// antigua tabla
		int antiguoSize = hashSize;
		HashNode<T> antiguaTabla[] = associativeArray;

		// nueva tabla
		hashSize = nextPrimeNumber(hashSize * 2); // nuevo hashSize
		HashNode<T> nuevaTabla[] = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's
		this.numElems = 0;
		associativeArray = nuevaTabla;

		// inicializamos el array
		for (int i = 0; i < hashSize; i++) {
			HashNode<T> nodo = new HashNode<T>();
			nuevaTabla[i] = nodo;
		}

		// redispersamos los datos
		for (int i = 0; i < antiguoSize; i++) {
			if (antiguaTabla[i].getStatus() == HashNode.LLENO) {
				add(antiguaTabla[i].getInfo());
			}
		}

		actualizarFC();

		return true;
	}

	/**
	 * Realiza una redispersion inversa (disminuyendo el tamaño) al número primo
	 * menor que la mitad del tamaño actual, recolocando los elementos, e indicando
	 * si lo realiza correctamente o no
	 * @return true: si se consigue dispersioanr
	 */
	@SuppressWarnings("unchecked")
	protected boolean inverseReDispersion() { // FC<0.16
		// antigua tabla
		int antiguoSize = hashSize;
		HashNode<T> antiguaTabla[] = associativeArray;

		hashSize = previousPrimeNumber(hashSize / 2); // nuevo hashSize

		// nueva tabla
		HashNode<T> nuevaTabla[] = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's
		this.numElems = 0;
		associativeArray = nuevaTabla;
		
		// inicializamos el array
		for (int i = 0; i < hashSize; i++) {
			HashNode<T> nodo = new HashNode<T>();
			nuevaTabla[i] = nodo;
		}

		// redispersamos los datos
		for (int i = 0; i < antiguoSize; i++) { // mal
			if (antiguaTabla[i].getStatus() == HashNode.LLENO) {
				add(antiguaTabla[i].getInfo());
			}
		}
		
		actualizarFC();
		
		return true;
	}

	/**
	 * función H
	 * @param x: elemento con el que se trabaja
	 * @return R - positiveValue: h(x)
	 */
	private int h(T x) {
		int R = previousPrimeNumber(getSize() - 1);
		int positiveValue = fHash(x) % R;
		return R - positiveValue;
	}

	/**
	 * Actualiza el factor de carga
	 * @return fc: factor de carga
	 */
	private double actualizarFC() {
		this.fc = (double) numElems / hashSize;
		return fc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			cadena.append(associativeArray[i]);
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}
	
	/**************************************************************
	 **************** PRACTICA PARA EL EXAMEN *********************
	 **************************************************************
	 * obtenerMax
	 */
	
	//Obtener el maximo
	public T obtenerMax() {
		if(numElems==0) return null; //tabla vacia
		
		T max = null;
		
		for(int i=0;i<getSize();i++) {
			
			if(associativeArray[i].getStatus()==HashNode.LLENO) {
				T actual = associativeArray[i].getInfo();
				
				if (max==null) max = actual;
				else if(((Comparable<T>) actual).compareTo(max)>0) max = actual;
			}
		}
		
		return max;
		
	}
}
