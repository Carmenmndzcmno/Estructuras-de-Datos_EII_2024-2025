package p3Arboles;

/**
 * Implementa un nodo de un arbol binario con un objeto "Comparable" como informacion
 * @author Nestor
 * @version 2024-25 distribuible
 * 
*/
public abstract class AbstractTreeNode <T>{
	protected T info;
	private AbstractTreeNode<T> left;
	private AbstractTreeNode<T> right;

	/**
	 * @param nodeInfo Un objeto 
	 */
	public AbstractTreeNode (T nodeInfo)
	{
		info=nodeInfo;
		left=null;
		right=null;
	}
	
	/**
	 * @param nodeInfo La informacion que se quiere meter en el nodo
	 * Se utiliza solo en algun caso de borrado
	 */
	protected void setInfo(T nodeInfo) {
		this.info = nodeInfo;
	}


	/**
	 * @return La informacion que almacena el nodo
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * @param x El nodo que se quiere enlazar en el subarbol izquierdo
	 */
	public void setLeft(AbstractTreeNode<T> x){
		left=x;
	}

	/**
	 * @param x El nodo que se quiere enlazar en el subarbol derecho
	 */
	public void setRight(AbstractTreeNode<T> x){
		right=x;
	}
	
	/**
	 * @return El subarbol izquierdo
	 */
	public AbstractTreeNode<T> getLeft () {
		return left;
	}

	/**
	 * @return El subarbol derecho
	 */
	public AbstractTreeNode<T> getRight () {
		return right;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return info.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals (Object t) {
		if (t==null)
			return false;
		if (t instanceof AbstractTreeNode<?>)
			return this.getInfo().equals(((AbstractTreeNode<?>) t).getInfo());
		return false;
	}

	
}
