package p3Arboles;

/**
 * @author Profesores ED
 * @version 2024-25 distribuible
 */
public interface EDPriorityQueue<T extends Comparable<T>> {

	/**
	 * Se le pasa el elemento que se quiere insertar en la cola
	 * Lanza NullPointerException si el elemento a insertar es null con mensaje "Element to insert is null."
	 * devuelve true si consigue insertarlo, false en caso contrario
	 * @param info: elemento que se quiere insertar
	 * @return boolean segun si inserta
	 */
	public boolean add(T info);

	/** 
	 * devuelve y elimina el elemento con mayor prioridad (cima del monticulo), o null si no hay elementos
	 * @return el elemento con mayor prioridad o null
	 */
	public T poll();
	
	/**
	 * Borra un elemento de la cola
	 * Lanza NullPointerException si el elemento a eliminar es null con mensaje "Element to remove is null."
	 * Se le pasa el elemento que se quiere eliminar de la cola
	 * devuelve true si estaba y lo elimina, false en caso contrario
	 * @param info: elemento que se quiere borrar
	 * @return boolean segun si se borra o no
	 */
	public boolean remove (T info);

	/**
	 * Indica si no hay ningun elemento
	 * @return boolean segun si está vacio o no
	 */
	public boolean isEmpty();
	
	/**
	 * Elimina todos los elementos de la cola
	 */
	public void clear();
	
	/**
	 * Devuelve un string con la cola de alguna forma visible
	 */
	public String toString();
}

