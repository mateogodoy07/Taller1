//Nombre: Mateo Arturo Godoy Carrasco
//Rut: 21.924.663-3
//Carrera: Ingenieria Civil Industrial
//Link repositorio:

package Package;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Taller1 {

	public static void main(String[] args) throws IOException {
		File file1 = new File("Usuario.txt");
		Scanner scanner1 = new Scanner(file1);

		while(scanner1.hasNextLine()) {
			String linea1 = scanner1.nextLine();
			String[] partes1 = linea1.split(";");
			String ID1 = partes1[0];
			String Contraseña = partes1[1];
			System.out.println(ID1);
			System.out.println(Contraseña);
			
		}
		File file2 = new File("Registros.txt");
		Scanner scanner2 = new Scanner(file2);
		
		while(scanner2.hasNextLine()) {
			String linea2 = scanner2.nextLine();
			String[] partes2 = linea2.split(";");
			String ID2 = partes2[0];
			String Fecha = partes2[1];
			
		}
	}

}

