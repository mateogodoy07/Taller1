//Nombre: Mateo Arturo Godoy Carrasco
//Rut: 21.924.663-3
//Carrera: Ingenieria Civil Industrial
//Link repositorio: https://github.com/mateogodoy07/Taller1.git

package Package;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Taller1 {

	public static void main(String[] args) {
		Scanner lector1 = null;
		Scanner lector2 = null;
		
		String[] Usuarios = leerArchivos1("Usuario.txt",lector1);
		String[] Registros = leerArchivos2("Registros.txt",lector2);
		
		

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
								for(int j = 0; j < Registros.length; j++) {
									if(Registros[j] !=null) {
										String[] partes2 = Registros[j].split(";");
										String ID2 = partes2[0];         
										String Fecha = partes2[1];
										String Horas = partes2[2];
										String Actividad = partes2[3];
										
									}
									
								}
								
									
								int opcion; 
								do {
									System.out.println("Acceso correcto!");
									System.out.println("");
									System.out.println("Bienvenido" +" "+ User+"!");
									System.out.println("");
									System.out.println("Que deseas realizar?");
									System.out.println("");
									System.out.println("1) Registrar actividad.");
									System.out.println("2) Modificar actividad.");
									System.out.println("3) Eliminar actividad.");
									System.out.println("4) Cambiar contraseña.");
									System.out.println("5) Salir.");
									
									 opcion = Integer.valueOf(scanner.nextLine());
									if(opcion == 1) {
										try {
											BufferedWriter RA = new BufferedWriter(new FileWriter("Registros.txt",true)); // RA = registro de actividad
											System.out.println("Ingrese fecha (dia/mes/año)");
											String Fecha = String.valueOf(scanner.nextLine());
											System.out.println("Ingrese las horas de esta actividad");
											String Horas = String.valueOf(scanner.nextLine());
											System.out.println("Ingrese la actividad realizada");
											String Actividad = String.valueOf(scanner.nextLine());
											
											String RA2 = ID1 + ";" +Fecha +";"+ Horas + ";" + Actividad;
											for(int y = 0; y < Registros.length;y++) {
												if(Registros[y] == null) {
													Registros[y] = RA2;
													System.out.println(Registros[y]);
													break;
												}
												
											}
											
											RA.newLine();
											RA.write(RA2);
											RA.close();
											
											
											
											
										}catch(IOException e) {
											
										}
									}
									if(opcion == 2) {
										int c = 0; // un contador
										int[] lista = new int[300];
										System.out.println("0) Regresar.");
										for(int k = 0; k < Registros.length; k++) {
											if(Registros[k]!=null) {
												String[] partes2 = Registros[k].split(";");
												String ID2 = partes2[0];         
												String Fecha = partes2[1];
												String Horas = partes2[2];
												String Actividad = partes2[3];
												
												if(ID2.equals(User)) {
													lista[c] = k;
													c++;
													
													
													System.out.println(c+")"+ " " + Registros[k]);
													
													
													
												}
												
											}
										}
										
										int actividad = Integer.valueOf(scanner.nextLine());
										int PRO = lista[actividad-1]; // posicion real original = PRO pdd: XD
										System.out.println(Registros[PRO]);
										String[] partes3 = Registros[PRO].split(";");
										String ID3 = partes3[0];         
										String Recuerdo = partes3[1];
										String Tiempo = partes3[2];
										String Situacion = partes3[3];
										
								
										System.out.println("Que deseas modificar?");
										System.out.println("");
										System.out.println("0) Regesar.");
										System.out.println("1) Fecha");
										System.out.println("2) Duracion");
										System.out.println("3) Tipo de actividad");
										
										
										
										
										
										
										int selector = Integer.valueOf(scanner.nextLine());
										
										if(selector == 1) {
											
											
											try {
												BufferedWriter fecha = new BufferedWriter(new FileWriter("Registros.txt",false));
												System.out.println("0) Regresar.");
												System.out.println("Ingrese nueva fecha(dia/mes/año): ");
												String linea = String.valueOf(scanner.nextLine());
												if(!linea.equals("0")) {
													String [] partes4 = linea.split("/");
													String dia = partes4[0];
													String mes = partes4[1];
													String año = partes4[2];
													
													String Respuesta = dia + "/" + mes + "/" + año;
													
													Registros[PRO] = ID3 + ";" + Respuesta + ";" + Tiempo + ";" + Situacion;
													
													
													
													
												}
												else {
													fecha.close();
													return;
												}
												for(int r = 0; r < Registros.length; r++) {
													if(Registros[r] != null) {
														fecha.write(Registros[r]);
														fecha.newLine();
														
													}
												}
												System.out.println("");
												System.out.println("Fecha cambiada con exito!");
												System.out.println("");
												fecha.close();
											} catch (IOException e) {
												
												e.printStackTrace();
											}
											
											
										}
									    if(selector == 2) {
									    	try {
												BufferedWriter duracion = new BufferedWriter(new FileWriter("Registros.txt",false));
												System.out.println("0) Regresar.");
												System.out.println("Ingrese nueva duracion: ");
												int linea = Integer.valueOf(scanner.nextLine());
												if(linea != 0) {
													String Respuesta = ID3 + ";" + Recuerdo + ";" + linea + ";" + Situacion;
													
													Registros[PRO] = Respuesta;
											
												}
												else {
													duracion.close();
													return;
												}
												for(int r = 0; r < Registros.length; r++) {
													if(Registros[r] != null) {
														duracion.write(Registros[r]);
														duracion.newLine();
														
													}
												}
												System.out.println("");
												System.out.println("Duracion cambiada con exito!");
												System.out.println("");
												duracion.close();
											} catch (IOException e) {
												
												e.printStackTrace();
											}
									    	
									    	
									    }
									    if(selector == 3) {
									    	try {
												BufferedWriter TP = new BufferedWriter(new FileWriter("Registros.txt",false)); // TP = tipo de actividad 
												System.out.println("0) Regresar.");
												System.out.println("Ingrese nuevo tipo de actividad: ");
												String linea = String.valueOf(scanner.nextLine());
												if(!linea.equals("0")) {
													String Respuesta = ID3 + ";" + Recuerdo + ";" + Tiempo + ";" + linea;
													
													Registros[PRO] = Respuesta;
											
												}
												else {
													TP.close();
													return;
												}
												for(int r = 0; r < Registros.length; r++) {
													if(Registros[r] != null) {
														TP.write(Registros[r]);
														TP.newLine();
														
													}
												}
												System.out.println("");
												System.out.println("Actvididad cambiada con exito!");
												System.out.println("");
												TP.close();
											} catch (IOException e) {
												
												e.printStackTrace();
											}
									    	
									    	
									    }
									    
									}
									if(opcion == 3) {
										int c = 0; // un contador
										int[] lista = new int[300];
										System.out.println("0) Regresar.");
										for(int k = 0; k < Registros.length; k++) {
											if(Registros[k]!=null) {
												String[] partes2 = Registros[k].split(";");
												String ID2 = partes2[0];         
												String Fecha = partes2[1];
												String Horas = partes2[2];
												String Actividad = partes2[3];
												
												if(ID2.equals(User)) {
													lista[c] = k;
													c++;
													
													
													System.out.println(c+")"+ " " + Registros[k]);
													
													
													
												}
												
											}
										}
										System.out.println("Que linea desea eliminar?");
										int actividad = Integer.valueOf(scanner.nextLine());
										int PRO = lista[actividad-1]; // posicion real original = PRO pdd: de nuevo XD
										System.out.println(Registros[PRO]);
										String[] partes3 = Registros[PRO].split(";");
										String ID3 = partes3[0];         
										String Recuerdo = partes3[1];
										String Tiempo = partes3[2];
										String Situacion = partes3[3];
										
										try {
											BufferedWriter TP = new BufferedWriter(new FileWriter("Registros.txt",false)); // TP = tipo de actividad 
											String linea = "disponible";
											if(!linea.equals("0")) {
												String Respuesta = ID3 + ";" + Recuerdo + ";" + Tiempo + ";" + linea;
												
												Registros[PRO] = Respuesta;
										
											}
											else {
												TP.close();
												return;
											}
											for(int r = 0; r < Registros.length; r++) {
												if(Registros[r] != null) {
													TP.write(Registros[r]);
													TP.newLine();
													
												}
											}
											System.out.println("");
											System.out.println("Actvididad eliminada con exito!");
											System.out.println("");
											TP.close();
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
										
										
										
										
									}
									if(opcion == 4) {
										System.out.println("0) Regresar.");
										System.out.println("Ingrese su nueva contraseña");
										for(int b = 0; b < Usuarios.length;b++) {
											if(Usuarios[b] != null) {
												String[] partes4 = Usuarios[b].split(";");
												String ID4 = partes4[0];
												String password = partes4[1];
												
												try {
													BufferedWriter CC = new BufferedWriter(new FileWriter("Usuario.txt",false)); // CC = cambio contraseña
													if(ID4.equals(User)) {
														String NP = String.valueOf(scanner.nextLine()); // NP = new password (nueva contraseña pa los gringos)
														if(!NP.equals("0")) {
															String Respuesta = ID4 +";"+ NP;
															
															Usuarios[b] = Respuesta;
														}
														else {
															CC.close();
															return;
														}
														for(int r = 0; r < Usuarios.length; r++) {
															if(Usuarios[r] != null) {
																System.out.println(Usuarios[r]);
																CC.write(Usuarios[r]);
																CC.newLine();	
														}
														
													}
													CC.close();
													break;
													}
													
													
													
												} catch (IOException e) {
													
													e.printStackTrace();
												}
												
											}
												
											
										}
										

										
									}
									
									
								}while(opcion !=5);
								
								
							}
							
						}
					}
				}
			}
			if(comando == 2) {
				int opcion;
				do {
					System.out.println("Bienvenido al menu de analisis!");
					System.out.println("");
					System.out.println("Que deseas realizar?");
					System.out.println("");
					System.out.println("1) Actividad mas realizada");
					System.out.println("2) Actividad mas realizada por cada usuario");
					System.out.println("3) Usuario con mayor procastinacion");
					System.out.println("4) Ver todas las actividades");
					System.out.println("5) Salir");
					
						opcion = Integer.valueOf(scanner.nextLine());
					
					
				}while(opcion !=5);
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

