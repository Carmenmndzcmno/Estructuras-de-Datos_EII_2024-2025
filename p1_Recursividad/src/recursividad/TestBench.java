package recursividad;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Clase TestBench
 * Define dos métodos: testAlgorithm y test
 * @author Carmen Méndez Camino [UO299841]
 */

public class TestBench {
	
	/**
	 * Prueba un algoritmo
	 * @param className: nombre de la clase donde se encuentra el algoritmo
	 * @param methodName: nombre del propio algoritmo
	 * @param n
	 * @return null
	 */
	public static Object testAlgorithm(String className, String methodName, int n){

				Object obj = null;
				try {
					obj = Class.forName(className).getDeclaredConstructor().newInstance();
					Method method = obj.getClass().getMethod(methodName, int.class);
					return method.invoke(obj, n);
				} catch (InstantiationException e) {
					System.err.println("ERROR: la clase no se puede instanciar");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					System.err.println("ERROR: no se puede acceder");
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					System.err.println("ERROR: el argumento es ilegal");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					System.err.println("ERROR: no se puede invocar al mÃ©todo");
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					System.err.println("ERROR: no existe el mÃ©todo");
					e.printStackTrace();
				} catch (SecurityException e) {
					System.err.println("ERROR: hay una violaciÃ³n en la seguridad");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.err.println("ERROR: la clase no se encuentra");
					e.printStackTrace();
				}
				return null;
	}
	
	/**
	 * Ejecuta un método del cual guardará sus tiempos de "worload" (carga de trabajo) en un fichero .csv
	 * @param output: nombre del fichero .csv
	 * @param times: las veces que se va a repetir el método
	 * @param startN: n inicial
	 * @param endN: n final
	 * @param className: nombre de la clase donde se encuentra el método
	 * @param methodName: nombre del método
	 * @throws IOException
	 */
	public static void test(String output, int times, int startN, int endN, 
			String className, String methodName) throws IOException{
			FileWriter file = null;
			PrintWriter pw;
			try {
				file = new FileWriter(output);
				pw = new PrintWriter(file);
				for(int workLoad = startN ; workLoad <= endN ; workLoad++){
					long startTime = System.currentTimeMillis();	
					for(int time = 0 ; time < times ; time++){					
						testAlgorithm(className,methodName,workLoad);
					}
					long finalTime = System.currentTimeMillis();
					pw.println(workLoad+";"+((finalTime - startTime)/times));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (file!=null) {
					file.close();				
				}
			}
	}
}
