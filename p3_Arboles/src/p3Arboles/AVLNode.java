package p3Arboles;

/**
 * Clase derivada de BSTNode a√±adiendo funcionalidad de AVL
 * 
 * @author Profesores ED (Espa√±ol) ; Alumna: Carmen MÈndez Camino [UO299841]
 * @version 2024-25 distribuible
 *
 */
public class AVLNode<T extends Comparable<T>> extends BSTNode<T> {

	/**
	 * Para almacenar la altura del nodo
	 */
	protected int height;

	/**
	 * Para almacenar al Factor de balance. Puede no existir y calcularse cada vez a
	 * partir de la altura de los hijos.
	 */
	protected int balanceFactor;

	/**
	 * Llama al padre y a√±ade la informacion propia se le pasa la informacion que
	 * se mete en el nuevo nodo
	 * @param node nodo
	 */
	public AVLNode(T node) {
		super((T)node);
	}

	/**
	 * devuelve la altura del arbol del cual es raiz el nodo en cuestion
	 * @return height: altura del ·rbol
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Devuelve el factor de balance segun equilibrio del arbol del cual es raiz
	 * @return balanceFactor: factor de balance
	 */
	public int getBF() {
		return balanceFactor;
	}

	/**
	 * Actualiza la altura del nodo en el arbol utilizando la altura de los hijos y
	 * si es preciso actualiza el FB
	 */
	protected void updateHeight() {
		//Miramos la altura del hijo izquierdo, la del derecho, se coge el mayor y se le suma 1
		
		int leftH;
		int rightH;
		
		if(getLeft()==null)  leftH=-1;
		else leftH=getLeft().getHeight();
		
		if(getRight()==null) rightH=-1;
		else rightH=getRight().getHeight();
		
		if (leftH >= rightH) {
			this.height = leftH + 1;
		} else { 
			this.height = rightH + 1;
		}
		
		this.balanceFactor = rightH - leftH; //Si ambos valen -1, dar· 0
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#getLeft()
	 */
	public AVLNode<T> getLeft() {
		return (AVLNode<T>) super.getLeft();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#getRight()
	 */
	public AVLNode<T> getRight() {
		return (AVLNode<T>) super.getRight();
	}

// No se necesitan los setters, valen los heredados

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#toString() A√±ade factor de balance
	 */
	public String toString() {
		return super.toString() + ":BF=" + getBF();
	}
}
