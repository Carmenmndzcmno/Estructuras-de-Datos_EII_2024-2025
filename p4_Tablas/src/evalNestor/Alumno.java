//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;

/**
 * clase alumno
 * @author Nestor
 *
 */
public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Carmen", // Primera en mayuscula y si es compuesto, sin espacios
			apellido1="Méndez", // Primera en mayuscula y si es compuesto, sin espacios
			apellido2="Camino", // Primera en mayuscula y si es compuesto, sin espacios
			uo="UO299841"; // El UO en mayusculas
	/**
	 * devuelve el nombre del fichero del alumno
	 * @return  apellido1+apellido2+nombre+"-"+uo: nombre del fichero del alumno
	 */
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo;
	}
	/**
	 * devuelve el email
	 * @return uo+"@uniovi.es": email
	 */
	public String email() {
		return uo+"@uniovi.es";
	}
	
}
