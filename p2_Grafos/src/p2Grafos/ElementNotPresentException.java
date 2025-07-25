package p2Grafos;

/**
 * Clase para crear una expceción sobre que un elemento no está presente
 * @author Oscar; Carmen Méndez Camino [UO299841] (Alumna)
 * @version 2024-25
 */
public class ElementNotPresentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la expención
	 * @param element: objeto
	 */
	public ElementNotPresentException(Object element) {
		super("Element " + element + " is not present in the current structure.");
	}
	/**
	 * Constructor de la excepción
	 * @param message: mensaje de la excepción
	 */
	public ElementNotPresentException(String message) {
		super(message);
	}

}
