package p2Grafos;

/**
 * Clase Grafo con todos los métodos relacionados con la creación de uno y los algoritmos de Floyd y Dijkstra
 * @author Nestor y Puerto; Carmen Méndez Camino [UO299841] (Alumna)
 * @version 2024-25 distribuible
 */
public class Graph<T> extends GraphAbstract<T> {

	double aFloyd[][];// Vector A de Floyd
	int pFloyd[][]; // Vector P de Floyd
	String recorridoProf;
	int dimension;

	/**
	 * Se le pasa el numero maximo de nodos del grafo
	 * @param dimension: tamaño máximo que puede tomar un grafo
	 */
	public Graph(int dimension) {
		super(dimension);
		this.weights = new double[dimension][dimension];
		this.edges = new boolean[dimension][dimension];
		aFloyd = new double[dimension][dimension]; // Vector A de Floyd
		pFloyd = new int[dimension][dimension]; // Vector P de Floyd (se inicializa a -1)
		this.dimension=dimension;
	}

	/**
	 * Obtiene el indice de un nodo en el vector de nodos Se le pasa el nodo y
	 * devuelve la posicion en el vector de nodos o -1 si no existe
	 * @param node : nodo del que se interesa saber el índice
	 * @return i: siendo i el índice del nodo en caso de que el nodo exista; -1: si el nodo no existe
	 */
	public int getNode(T node) { // HECHO
		for (int i = 0; i < size; i++) {
			if (nodes[i].equals(node))
				return i;
		}
		return -1;
	}

	/**
	 * Inserta un nuevo nodo que se le pasa como parametro. Si ya existe, no lo
	 * inserta y devuelve false (implementado mas tarde). Si recibe un nodo nulo, no
	 * lo inserta y lanza una NullPointerException Si no cabe, no lo inserta y lanza
	 * una FullStructureException.
	 * @param node: nodo a añadir al grafo
	 * @return false: si ya existe el nodo; NullPointerException: si el nodo es nulo;FullStructureException: si el nodo no cabe;true: si se ha añadiro
	 */
	public boolean addNode(T node) {
		if (existsNode(node))
			return false;
		if (node == null)
			throw new NullPointerException("Nodo nulo");
		if(size>=dimension) throw new FullStructureException("El nodo no cabe");
		// Se mete el nodo en el vector de nodos
		nodes[size] = node;
		// Se inicializa la matriz de aristas a False
		// Se inicializa la matriz de pesos a 0S
		for (int i = 0; i <= size; i++) {
			edges[size][i] = false;
			weights[size][i] = 0;
			edges[i][size] = false;
			weights[i][size] = 0;
		}
		size++;
		return true;
	}

	/**
	 * Si existe, borra el nodo deseado del vector de nodos asi como las aristas en
	 * las que forma parte y duvuelve true. Si el nodo no existe devuelve false. Si
	 * recibe un nodo nulo, lanza una NullPointerException
	 * @param node: nodo a borrar
	 * @return NullPointerException: si el nodo es nulo; false: si el nodo no existe; true: si el nodo se ha logrado borrar
	 */
	public boolean removeNode(T node) {

		if (node == null)
			throw new NullPointerException("Nodo nulo");
		if (existsNode(node)) {
			int posBor = getNode(node); // Posición a BORrar
			if (posBor == size) {
				size--;
				return false;
			}
			size--;

			nodes[posBor] = nodes[size];
			for (int i = 0; i < size; i++) {

				weights[i][posBor] = weights[i][size];
				edges[i][posBor] = edges[i][size];

				weights[posBor][i] = weights[size][i];
				edges[posBor][i] = edges[size][i];
			}
			//Codo
			weights[posBor][posBor] = weights[size][size];
			edges[posBor][posBor] = edges[size][size];

			return true;
		}

		return false;
	}

	/**
	 * Si existe devuelve true Si no existe devuelve false
	 * @param node: nodo el cual se va  acomprobar si existe
	 * @return true: si existe; false: si no existe
	 */
	public boolean existsNode(T node) {
		for (int i = 0; i < size; i++) {
			if (nodes[i].equals(node))
				return true;
		}
		return false;
	}

	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como parametro
	 * Devuelve true si existe la arista entre los dos nodos que se le pasan
	 * Devuelve false si no existe la arista o no existen ambos nodos
	 * @param source: primer nodo
	 * @param target: segundo nodo
	 * @return false: si no existe la arista o no existen ambos nodos; true:si existe la arista entre los dos nodos que se le pasan
	 */
	public boolean existsEdge(T source, T target) {
		if (!existsNode(source) || !existsNode(target))
			return false;
		return edges[getNode(source)][getNode(target)];
	}

	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. Devuelve true si la inserta Devuelve falso si ya existe el arco
	 * (arista) Lanza una excepcion ElementNotPresentException si no existe el nodo
	 * origen o destino Lanza una IllegalArgumentException si el peso es invalido.
	 * @param source: Nodo origen
	 * @param target: nodo destino
	 * @param edgeWeight: peso a insertar
	 * @return IllegalArgumentException: si el peso es inválido; false: si ya existe la arista; ElementNotPresentException: si no existe el nodo origen o destino;true: si se ha logrado añadir
	 */
	public boolean addEdge(T source, T target, double edgeWeight) {
		if (edgeWeight <= 0)
			throw new IllegalArgumentException("El peso es invalido");
		if (existsEdge(source, target))
			return false;
		if (!existsNode(source) || !existsNode(target))
			throw new ElementNotPresentException("No existe el nodo origen o destino");

		int posSour = getNode(source); // Posicion Source
		int posTar = getNode(target); // Posicion Target

		weights[posSour][posTar] = edgeWeight;
		edges[posSour][posTar] = true;

		return true;
	}

	/**
	 * Borra la arista del grafo que conecta dos nodos. Si la arista existe, se
	 * borra y devuelve true. Si los nodos source o target no existen, lanza una
	 * excepcion de tipo ElementNotPresentException Si tanto source como target
	 * existen, pero la arista a eliminar no, devuelve false.
	 * @param source: nodo origen
	 * @param target: nodo destino
	 * @return ElementNotPresentException: si los nodos source o target no existen; true: si se ha logrado borrar la arista; false: si no existia la arista
	 */
	public boolean removeEdge(T source, T target) {

		if (!existsNode(source) || !existsNode(target))
			throw new ElementNotPresentException("Los nodos source o target no existen");

		if (existsEdge(source, target)) {
			int posSour = getNode(source); // Posicion Source
			int posTar = getNode(target); // Posicion Target

			weights[posSour][posTar] = 0;
			edges[posSour][posTar] = false;

			return true;
		}

		return false;
	}

	/**
	 * Devuelve el peso de la arista que conecta dos nodos. Si los nodos source o
	 * target no existen, lanza una excepcion de tipo ElementNotPresentException Si
	 * tanto source como target existen, pero la arista a eliminar no, devuelve -1
	 * @param source: nodo origen
	 * @param target: nodo destino
	 * @return ElementNotPresentException: si los nodos source o target no existen; -1: si no existe la arista; weights[posSour][posTar]: si existe la arista, siendo el propio peso entre ellas
	 */
	public double getEdge(T source, T target) {

		if (!existsNode(source) || !existsNode(target))
			throw new ElementNotPresentException("Los nodos source o target no existen");
		if (!existsEdge(source, target))
			return -1;
		int posSour = getNode(source); // Posicion Source
		int posTar = getNode(target); // Posicion Target

		return weights[posSour][posTar];
	}

	/**
	 * Aplica el algoritmo de Floyd al grafo actual Devuelve true si lo aplica y
	 * false en caso contrario (no hay nodos en el grafo)
	 * @return false: si no hay nodos en el grafo; true: si se aplica el algoritmo de Floyd
	 */
	public boolean floyd() {
		if(nodes==null)return false;
		
		pFloyd = inicializarMatrizCamino();
		aFloyd = inicializarMatrizCoste();

		for (int pivote = 0; pivote < size; pivote++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (aFloyd[i][pivote] + aFloyd[pivote][j] < aFloyd[i][j] && i != j) {
						aFloyd[i][j] = aFloyd[i][pivote] + aFloyd[pivote][j];
						pFloyd[i][j] = pivote;
					}
				}
			}
		}
		return true;
	}
	/**
	 * Inicializa la matriz de caminos P para el algoritmo de Floyd
	 * @return matriz: matriz de caminos
	 */
	public int[][] inicializarMatrizCamino() { // Matriz P
		int[][] matriz = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matriz[i][j] = -1;
			}
		}
		return matriz;
	}
	/**
	 * Inicializa la Matriz de Coste A para el algoritmo de Floyd
	 * @return matriz: matriz de coste
	 */
	public double[][] inicializarMatrizCoste() {
		double [][]matriz = new double[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j)
					matriz[i][j] = 0;
				else if (edges[i][j] && i != j)
					matriz[i][j] = weights[i][j];
				else
					matriz[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		
		return matriz;
	}
	/**
	 * Getter de la Matriz de Coste A de Floyd
	 * @return aFloyd: matriz de coste
	 */
	public double[][] getFloydA() {
		return aFloyd;
	}
	/**
	 * Getter de la Matriz de Caminos P de Floyd
	 * @return pFloyd: matriz de caminos
	 */
	public int[][] getFloydP() {
		return pFloyd;
	}

	/**
	 * Lanza el recorrido en profundidad de un grafo desde un nodo determinado, No
	 * necesariamente recorre todos los nodos. Al recorrer cada nodo hace un
	 * tratamiento del mismo que consiste en un concatenar el toString del nodo y un
	 * tabulador detras
	 * @param nodo: nodo desde el que se empieza el recorrido
	 * @return "\t": si el nodo no existe;profundidadRecursivo(getNode(nodo), visitados): para aplicar un método recursivo que devuelve el recorrido en profundidad
	 */
	public String recorridoProfundidad(T nodo) {

		if (!existsNode(nodo))
			return "\t";
		boolean visitados[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			visitados[i] = false;
		}
		return profundidadRecursivo(getNode(nodo), visitados);
	}

	/**
	 *  Lanza el recorrido en profundidad de un grafo desde un nodo determinado de forma recursiva
	 * @param nodo: índice del nodo desde el que se empieza el recorrido
	 * @param visitados: array booleano que indica si un nodo ha sido visitado
	 * @return cadena: string que indica cuál ha sido el recorrido
	 */
	public String profundidadRecursivo(int nodo, boolean visitados[]) {
		visitados[nodo] = true;
		String cadena = nodes[nodo].toString() + "\t";

		for (int i = 0; i < size; i++) {
			if (existsEdge(nodes[nodo], nodes[i]) && !visitados[i]) {
				cadena = cadena + profundidadRecursivo(i, visitados);
			}
		}

		return cadena;
	}

	/**
	 * Indica el camino entre los nodos que se le pasan como parametros de esta
	 * forma: donde cada nodo (Origen, Destino, IntermedioN,...) se refiere al
	 * toString del nodo correspondiente
	 * Origen"tabulador"(coste0)"tabulador"Intermedio1"tabulador"(coste1)"tabulador"IntermedioN"tabulador"(costeN)"tabulador"Destino"tabulador"
	 * Si no hay camino: Origen"tabulador"(Infinity)"tabulador"Destino"tabulador" Si
	 * Origen y Destino coinciden: Origen"tabulador" Si no existen los 2 nodos
	 * devuelve una cadena vacia
	 * @param origen: nodo origen
	 * @param destino: nodo destino
	 * @return path: camino a devolver entre dos nodos
	 */
	public String path(T origen, T destino) {
		String path = "";
		floyd();
		int[][] p = getFloydP();

		if (getNode(origen) == -1 || getNode(destino) == -1)
			path = "";
		else if (getNode(origen) == getNode(destino))
			path = origen.toString() + "\t" + path;
		else if (p[getNode(origen)][getNode(destino)] == Double.POSITIVE_INFINITY)
			path = origen.toString() + "\t(Infinity)\t" + destino.toString() + path;
		else
			path = origen + pathRecursivo(getNode(origen), getNode(destino)) + destino;

		return path;
	}
	/**
	 * Indica el camino entre los nodos que se le pasan como parametros de forma recursiva
	 * @param origen: índice del nodo origen
	 * @param destino: índice del nodo destino
	 * @return pathRecursivo(origen, piv) + nodes[piv].toString() + pathRecursivo(piv, destino): para seguir con la recursividad y finalmente devolver el camino ente los nodos;"\t(" + a[origen][destino] + ")\t": caso base de la recursividad
	 */
	public String pathRecursivo(int origen, int destino) {
		int[][] p = getFloydP();
		double[][] a = getFloydA();

		int piv = p[origen][destino];
		if (piv != -1)
			return pathRecursivo(origen, piv) + nodes[piv].toString() + pathRecursivo(piv, destino);
		else
			return "\t(" + a[origen][destino] + ")\t";
	}

	/**
	 * Algoritmo de Dijkstra para encontrar el camino de coste minimo desde
	 * nodoOrigen hasta el resto de nodos Se le pasa el nodo origen como parametro
	 * Devuelve una DijkstraDataClass con los vectores D y P correspondientes si se
	 * aplica o null si no se puede aplicar
	 * @param nodoOrigen: nodo Origen, es decir, desde el que se parte
	 * @return null: si no se puede aplicar Dijkstra;dijkstra: DijkstraDataClass a devolver
	 */
	public DijkstraDataClass dijkstra(T nodoOrigen) {

		if (getNode(nodoOrigen) == -1||nodes==null)
			return null;

		// Se inicializan los Vectores de Coste y Camino
		boolean[] s = new boolean[size];
		double[] vectorD = inicializarVectorCoste(size, nodoOrigen);
		int[] vectorP = inicializarVectorCaminos(size);
		int indexOrigen = getNode(nodoOrigen);

		int i = indicePivote(vectorD, s);
		while (i != -1) {
			s[i] = true;
			for (int j = 0; j < size; j++) {
				if (existsEdge(nodes[i], nodes[j]) && (vectorD[i] + weights[i][j]) < vectorD[j]) {
					vectorD[j] = (vectorD[i] + weights[i][j]);
					vectorP[j] = i;
				}
			}
			i = indicePivote(vectorD, s);
		}
		DijkstraDataClass dijkstra = new DijkstraDataClass(indexOrigen, size);
		dijkstra.setdDijkstra(vectorD);
		dijkstra.setpDijkstra(vectorP);

		return dijkstra;
	}
	
	/**
	 * Inicialización del Vector de Coste de Dijkstra
	 * @param size: variable size, tamaño
	 * @param nodoOrigen: nodo origen, del que se parte
	 * @return coste: vector de double con los costes del grafo
	 */
	public double[] inicializarVectorCoste(int size, T nodoOrigen) {
		double[] coste = new double[size];
		for (int i = 0; i < size; i++) {
			if (existsEdge(nodoOrigen, nodes[i])) {
				coste[i] = weights[getNode(nodoOrigen)][i];
			} else {
				coste[i] = Double.POSITIVE_INFINITY;
			}
		}
		coste[getNode(nodoOrigen)] = 0;
		return coste;
	}
	
	/**
	 * Método que devuelve el índice del próximo pivote
	 * @param vectorD: vector de pesos/costes
	 * @param s: vector booleano que indica si un nodo ha sido pivote
	 * @return iMin: índice del próximo pivote
	 */
	public int indicePivote(double[] vectorD, boolean[] s) {
		int iMin = -1;
		double dMin = Double.POSITIVE_INFINITY;
		for (int i = 0; i < size; i++) {
			if (!s[i] && vectorD[i] < dMin) {
				dMin = vectorD[i];
				iMin = i;
			}
		}
		return iMin;
	}
	
	/**
	 * Método que inicializa el Vector de caminos
	 * @param size: variable size, tamaño
	 * @return camino: vector de caminos del grafo
	 */
	public int[] inicializarVectorCaminos(int size) {
		int[] camino = new int[size];
		for (int i = 0; i < size; i++) {
			camino[i] = -1;
		}
		return camino;
	}

	/**
	 * Devuelve el coste del camino de coste minimo entre origen y destino segun
	 * Floyd. Si los nodos source o target no existen, lanza una excepcion de tipo
	 * ElementNotPresentException Si no se ha aplicado Floyd, lo aplica. (OJO que
	 * este metodo SI lo invoca)
	 * @param origen: nodo origen
	 * @param destino: nodo destino
	 * @return coste: coste del camino entre origen y destino; ElementNotPresentException: si alguno de los nodos no existen
	 */
	public double minCostPath(T origen, T destino) {
		if (getNode(origen) == -1 || getNode(destino) == -1)
			throw new ElementNotPresentException("Los nodos source o target no existen");
		if (getFloydP() == null || getFloydA() == null)
			floyd();

		double coste = pathCosteRecursivo(getNode(origen), getNode(destino));

		return coste;
	}
	
	/**
	 *  Devuelve el coste del camino de coste minimo entre origen y destino segun
	 * Floyd de forma recursiva
	 * @param origen: índice del nodo origen
	 * @param destino: índice del nodo destino
	 * @return pathCosteRecursivo(origen, piv) + pathCosteRecursivo(piv, destino): para aplicar la recursividad y conseguir el coste del camino; a[origen][destino]: caso general
	 */
	public double pathCosteRecursivo(int origen, int destino) {
		int[][] p = getFloydP();
		double[][] a = getFloydA();

		int piv = p[origen][destino];
		if (piv != -1)
			return pathCosteRecursivo(origen, piv) + pathCosteRecursivo(piv, destino);
		else
			return a[origen][destino];

	}

}
