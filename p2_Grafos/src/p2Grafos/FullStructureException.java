package p2Grafos;

/**
 * Clase que genera una excepción que indica que una estructura se encuentra llena
 * @author Oscar; Carmen Méndez Camino [UO299841] (Alumna)
 * @version 2024-25
 */
public class FullStructureException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param element: objeto
	 */
	public FullStructureException(Object element) {
		super("Element " + element.toString() + " could not be inserted since the data structure is full.");
	}
	/**
	 * Constructor
	 * @param element: objeto
	 * @param dataStructure: estructura de datos en la que ha surgido el error
	 */
	public FullStructureException(Object element, Object dataStructure) {
		super("Element " + element.toString() + " could not be inserted. Data structure full:\n "
				+ dataStructure.toString());
	}
	/**
	 * Constructor
	 * @param message: mensaje de la excepción
	 */
	public FullStructureException(String message) {
		super(message);
	}
}
