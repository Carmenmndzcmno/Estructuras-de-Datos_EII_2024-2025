package p2Grafos;

/**
 * Clase para crear una expceci�n sobre que un elemento no est� presente
 * @author Oscar; Carmen M�ndez Camino [UO299841] (Alumna)
 * @version 2024-25
 */
public class ElementNotPresentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la expenci�n
	 * @param element: objeto
	 */
	public ElementNotPresentException(Object element) {
		super("Element " + element + " is not present in the current structure.");
	}
	/**
	 * Constructor de la excepci�n
	 * @param message: mensaje de la excepci�n
	 */
	public ElementNotPresentException(String message) {
		super(message);
	}

}
