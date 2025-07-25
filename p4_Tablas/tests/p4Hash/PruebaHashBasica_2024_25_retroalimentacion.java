package p4Hash;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.junit.Test;

import evalNestor.Alumno;

public class PruebaHashBasica_2024_25_retroalimentacion {
	LocalDateTime localTime = LocalDateTime.now();
	int hora  = localTime.getHour();

	@Test
	public void sesion12Test() {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;

		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-Hash-Basica.txt",true);
			pw = new PrintWriter(file);
			pw.println("Fecha y hora: "+localTime.toString());
			
			pruebaBasica(pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}


	private void pruebaBasica(PrintWriter pw) {
		ClosedHashTable<Integer> h = new ClosedHashTable<>(5, ClosedHashTable.LINEAL);
		int operacion=0;
		pw.println("Empieza la prueba basica de Hash: ");
		System.out.println("Empieza la prueba basica de Hash: ");
		pw.println("h=new ClosedHashTable<Integer>(5,ClosedHashTable.LINEAL): ");
		System.out.println("h=new ClosedHashTable<Integer>(5,ClosedHashTable.LINEAL): ");
		Integer valores[]=new Integer[] {0,5,0,10,0,15
				,0,10,0,10,0,5,0,15};
		boolean res;
		
		for (int i=1; i<=valores.length; i++) {
			if (operacion<6) { // adds
				res=h.add(valores[i-1]);
				pw.println("Operacion "+i+" h.add("+valores[i-1]+"): "+res);
				System.out.println("Operacion "+i+" h.add("+valores[i-1]+"): "+res);
			}
			else { // removes
				res=h.remove(valores[i-1]);
				pw.println("Operacion "+i+" h.remove("+valores[i-1]+"): "+res);
				System.out.println("Operacion "+i+" h.remove("+valores[i-1]+"): "+res);
			}
			operacion++;
			pw.println("Estado "+(i)+"-> "+h.toString());
			System.out.println("Estado "+(i)+"-> "+h.toString());
		}

		pw.println("Termina la prueba basica de Hash.\n");
		System.out.println("Termina la prueba basica de Hash.\n");

		pw.println("Empieza la prueba de excepciones de Hash: ");		
		System.out.println("Empieza la prueba de excepciones de Hash: ");	
		
		try {
			res=h.add(null);
			pw.println("Operacion "+(++operacion)+" h.add(null): "+res);
			System.out.println("Operacion "+operacion+" h.add(null): "+res);
		} catch (NullPointerException e) {
			pw.println("Operacion "+(++operacion)+" h.add(null): "+"ha generado una NullPointerException ("+e.getMessage()+")");
			System.out.println("Operacion "+operacion+" h.add(null): "+"ha generado una NullPointerException ("+e.getMessage()+")");
		}

		pw.println("Estado "+operacion+"-> "+h.toString());
		System.out.println("Estado "+operacion+"-> "+h.toString());

		try {
			res=h.remove(null);
			pw.println("Operacion "+(++operacion)+" h.remove(null): "+res);
			System.out.println("Operacion "+operacion+" h.remove(null): "+res);
		} catch (NullPointerException e) {
			pw.println("Operacion "+(++operacion)+" h.remove(null): "+"ha generado una NullPointerException ("+e.getMessage()+")");
			System.out.println("Operacion "+operacion+" h.remove(null): "+"ha generado una NullPointerException ("+e.getMessage()+")");
		}

		pw.println("Estado "+operacion+"-> "+h.toString());
		System.out.println("Estado "+operacion+"-> "+h.toString());

		pw.println("Termina la prueba de excepciones de Hash.\n");
		System.out.println("Termina la prueba de excepciones de Hash.\n");

	}

}
