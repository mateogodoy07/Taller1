//Nombre: Mateo Arturo Godoy Carrasco
//Rut: 21.924.663-3
//Carrera: Ingenieria Civil Industrial
//Link repositorio:

package Package;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Taller1 {

	public static void main(String[] args) {
		Scanner lector1 = null;
		Scanner lector2 = null;
		
		String[] Usuarios = leerArchivos1("Usuario.txt",lector1);
		String[] Registros = leerArchivos2("Registros.txt",lector2);
		
		for(int i = 0; i < Usuarios.length; i++) {
			if(Usuarios[i] != null) {
				System.out.println(Usuarios[i]);
			}
		}
		for(int j = 0; j < Registros.length; j++ ) {
			if(Registros[j] != null) {
				System.out.println(Registros[j]);
			}
		}

		// aqui empieza el menu
		Scanner scanner = new Scanner(System.in);
		boolean inicio = false;

		do {
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			
			int comando = Integer.valueOf(scanner.nextLine());
			
			if(comando == 1) {
				System.out.println("Usuario:");
				String User = String.valueOf(scanner.nextLine());
				
				for(int i = 0; i < Usuarios.length; i++) {
					if(Usuarios[i] != null) {
						String[] partes1 = Usuarios[i].split(";");
						String ID1 = partes1[0];
						String Contraseña = partes1[1];
						
						if(ID1.equals(User)) {
							System.out.println("Contraseña:");
							String Password = String.valueOf(scanner.nextLine());
							
							if(Contraseña.equals(Password)) {
								for(int j = 0; i < Registros.length; j++) {
									if(Registros[j] !=null) {
										String[] partes2 = Registros[j].split(";");
										String ID2 = partes2[0];         
										String Fecha = partes2[1];
										String Horas = partes2[2];
										String Actividad = partes2[3];
										
									}
									
								}
								
									
								
								Scanner scanner2 = new Scanner(System.in);
								System.out.println("Acceso correcto!");
								System.out.println("");
								System.out.println("Bienvenido" + User+"!");
								System.out.println("");
								System.out.println("Que deseas realizar?");
								System.out.println("");
								System.out.println("1) Registrar actividad.");
								System.out.println("2) Modificar actividad.");
								System.out.println("3) Eliminar actividad.");
								System.out.println("4) Cambiar contraseña");
								System.out.println("5) Salir.");
								
								String opcion = String.valueOf(scanner.nextLine());
								
							}
							
						}
					}
				}
			}

			if(comando == 3) {
				inicio = true; 
			}
			
		} while(!inicio);
	}

	//lectura de archivos y sus partes establecidas
	public static String[] leerArchivos1(String nombreArchivo1,Scanner lector1) {
		String [] archivo1 = new String[300];
		try {
			File arch = new File(nombreArchivo1);
			lector1 = new Scanner(arch);
			int i = 0;
			while(lector1.hasNextLine()) {
				archivo1[i] = lector1.nextLine();
				String[] partes1 = archivo1[i].split(";");
				String ID1 = partes1[0];         
				String Contraseña = partes1[1];  
				i++;
			}
		}catch(IOException e) {}
		return archivo1;
	}

	public static String[] leerArchivos2(String nombreArchivo2,Scanner lector2) {
		String [] archivo2 = new String[300];
		try {
			File arch = new File(nombreArchivo2);
			lector2 = new Scanner(arch);
			int k = 0;
			while(lector2.hasNextLine()) {
				archivo2[k] = lector2.nextLine();
				String[] partes2 = archivo2[k].split(";");
				String ID2 = partes2[0];         
				String Fecha = partes2[1];
				String Horas = partes2[2];
				String Actividad = partes2[3];
				k++;
			}
		}catch(IOException e) {}
		return archivo2;
	}
}

