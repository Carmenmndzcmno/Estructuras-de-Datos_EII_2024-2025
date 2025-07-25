package p4Hash;

/**
 * @author Profesores ED
 * @version 2024-25 distribuible
 *
 * @param <T> : elemento
 */
public class HashNode<T> {
	private T info;
	private int status;

	
	public static final int BORRADO = -1;
	public static final int VACIO = 0;
	public static final int LLENO = 1;

	/**
	 * Constructor
	 */
	public HashNode () {
		info = null;
		status=VACIO;
	}
	
	/**
	 * devuelva la info
	 * @return info : informacion
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * remove
	 */
	public void remove (){
		status=BORRADO;
	}
	
	/**
	 * setInfo
	 * @param elem: elemento al que se le añade info
	 */
	public void setInfo(T elem){
		info=elem;
		status=LLENO;
	}
	
	/**
	 * getStatus
	 * @return status: estado
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * toString
	 * @return String: string
	 */
	public String toString (){
		StringBuilder cadena=new StringBuilder("{");
		switch (getStatus()){
		case LLENO:
			cadena.append(info);
			break;
		case VACIO:
			cadena.append("_E_");
			break;
		case BORRADO:
			cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}

}
