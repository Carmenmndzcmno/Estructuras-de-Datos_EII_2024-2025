//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;
/**
 * Clase Alumno
 * @author Carmen M�ndez Camino [UO299841]
 *
 */
public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Carmen", // Primera en mayuscula y si es compuesto, sin espacios
			apellido1="M�ndez", // Primera en mayuscula y si es compuesto, sin espacios
			apellido2="Camino", // Primera en mayuscula y si es compuesto, sin espacios
			uo="UO299841"; // El UO en mayusculas
	/**
	 * 
	 * @return nombre del alumno y uo
	 */
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo;
	}
	
	/**
	 * 
	 * @return email
	 */
	public String email() {
		return uo+"@uniovi.es";
	}
	
}
