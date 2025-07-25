package recursividad;

/**
 * Clase con todos los algoritmos utilizados en la práctica
 * @author Carmen Méndez Camino [UO299841]
 *
 */
public class Algoritmos {
	
	private static final int SLEEP_TIME = 250;

	/**
	 * Calcula el factorial de n en forma recursiva
	 * @param n: tamaño del workload
	 * @return 1: si n es 0; n*recursiveFactorial(n-1): n multiplicado por la propia función (aplicando así la recursividad) siendo lo que está dentro de la
	 * función (n-1)
	 */
	public static float recursiveFactorial(float n) { 
		if(n==0) return 1;
		return n*recursiveFactorial(n-1);
	}
	
	/**
	 * Calcula el factorial de n en forma iterativa
	 * @param n: tamaño del workload
	 * @return 1: si n es 0; n: siendo ahora n el factorial del n original
	 */
	public static float iterativeFactorial(int n) { 
		if (n==0) return 1;
		float b=n;
		while(b!=1) {
			n=(int) (n*(b-1)); 
			b--;
		}
		return n;
	}
	
	/**
	 * Aplica Fibonacci enésimas veces en forma iterativa
	 * @param n: tamaño del workload
	 * @return actual: siendo actual el número de la serie de Fibonacci enésimo
	 */
	public static int iterativeFibonacci (int n) {
		int actual = 0;
		int anterior = 0;
		for (int i=0;i<=n;i++) {
			if (i==0) actual = 0;
			else if (i==1) {
				actual = 1;
			} else {
				int guardoNum = actual;
				actual = actual + anterior;
				anterior = guardoNum;
			}
		}
		return actual;
	}
	
	/**
	 * Aplica Fibonacci enésimas veces en forma recursiva
	 * @param n: tamaño del workload
	 * @return 0: si n es 0; 1: si n es 1; recursiveFibonacci(n-1)+recursiveFibonacci(n-2): si no se retornó lo anterior
	 */
	public static int recursiveFibonacci (int n) {
		if (n==0) return 0;
		else if (n==1) return 1;
		return recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
	}
	
	/**
	 * Calcula una potencia en forma recursiva
	 * @param base: base
	 * @param exp: exponente
	 * @return 0: si la base es 0; 1: si el exponente es 0; base*recursivePow(base,exp-1): si no se retornó lo anterior
	 */
	public static float recursivePow (int base, int exp) {
		if(base==0) return 0;
		if(exp==0) return 1;
		return base*recursivePow(base,exp-1);
	}
	
	/**
	 * Calcula una potencia en forma iterativa
	 * @param base: base
	 * @param exp: exponente
	 * @return 0: si la base es 0; 1: si el exponente es 0; respuesta: siendo respuesta el restultado de la base elevada al exponente
	 */
	public static float iterativePow(int base, int exp) {
		if(base==0) return 0;
		if(exp==0) return 1;
		float respuesta=base;
		for(int i=1;i<exp;i++) {
			respuesta=base*respuesta;
		}
		return respuesta;
	}
	
	/**
	 * Calcula una potencia en base 2 en forma recursiva
	 * @param exp: exponente
	 * @return 1: si el exponente es 0; base*recursivePow0(exp-1): si no se retornó lo anterior
	 */
	public static int recursivePow0 (int exp) {
		doNothing();
		int base = 2;
		if(exp==0) return 1;
		return base*recursivePow0(exp-1);
	}
	
	/**
	 * Calcula una potencia en base dos y llama a doNothing()
	 * @param exponent: exponente
	 * @return 1: si el exponente es 0; 2 * recursivePow(exponent-1): si no se retornó lo anterior
	 */
	public static long recursivePow(int exponent)	{
		doNothing();	
		if(exponent == 0)
				return 1;		     
			return 2 * recursivePow(exponent-1);	
		}
	
	/**
	 * Calcula una potencia en base dos y llama a doNothing(). Duplica las llamadas recursivas incrementando su complejidad.
	 * @param exponent: exponente
	 * @return 1: si el exponente es 0; recursivePow1(exponent-1) + recursivePow1(exponent-1): si no se retornó lo anterior
	 */
	public static long recursivePow1(int exponent)	{
		doNothing();
			if(exponent == 0)
				return 1;		     
			return recursivePow1(exponent-1) + recursivePow1(exponent-1);	
		}
	
	/**
	 * Calcula una potencia en base dos y llama a doNothing(). Recalcula valores varias veces
	 * @param exponent: exponente
	 * @return 1: si el exponente es 0; (recursivePow2(exponent/2) * recursivePow2(exponent/2)): si el exponente es divisible entre 2;
	 * (recursivePow2(exponent/2) * recursivePow2(exponent/2) * 2): si no se retornó lo anterior
	 */
	public static long recursivePow2(int exponent) {
		doNothing();
		if(exponent == 0) 	return 1;
		if (exponent % 2 == 0)
			return (recursivePow2(exponent/2) * recursivePow2(exponent/2));
		else
			return (recursivePow2(exponent/2) * recursivePow2(exponent/2) * 2);
		}

	/**
	 * Calcula una potencia en base dos y llama a doNothing().
	 * @param exponent: exponente
	 * @return 1: si el exponente es 0; (result * result): si el exponente es divisible entre 2; (result * result * 2): si no se retornó lo
	 * anterior
	 */
	public static long recursivePow3(int exponent) {
		doNothing();
		if(exponent == 0) 	return 1;
		long result = recursivePow3(exponent/2); 
		if (exponent % 2 == 0) 	return (result * result);
		else 	return (result * result * 2);
	}
	
	/**
	 * Algoritmo de complejidad O(n)
	 * @param n: tamaño del workload
	 */
	public static void lineal (int n) {
		for(int i = 0;i<n;i++) {
			doNothing();
		}
	}
	
	/**
	 * Algoritmo de complejidad O(n^2)
	 * @param n: tamaño del workload
	 */
	public static void quadratic (int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				doNothing();
			}
		}
	}
	
	/**
	 * Algoritmo de complejidad O(n^3)
	 * @param n: tamaño del workload
	 */
	public static void cubic (int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int a=0;a<n;a++) {
					doNothing();
				}
			}
		}
	}
	
	/**
	 * Algoritmo de complejidad O(log n)
	 * @param n: tamaño del workload
	 */
	public static void logarithmic(int n){
			for(int i=1; i<= n ;i *=2) {
				doNothing();
				System.out.println(i);
			}
				 
		}
	
	/**
	 * Método que para la ejecucion unos milisegundos (SLEEP_TIME = 250)
	 */
	public static void doNothing(){
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
