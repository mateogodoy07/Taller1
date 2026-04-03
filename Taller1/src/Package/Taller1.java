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
								System.out.println("Acceso correcto!");
								System.out.println("");
								System.out.println("Bienvenido" +" "+ User+"!");
								do {
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
													System.out.println("Actividad registrada con exito!");
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
										
										System.out.println("");
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
												
												System.out.println("0) Regresar.");
												System.out.println("Ingrese nueva duracion: ");
												int linea = Integer.valueOf(scanner.nextLine());
												if(linea != 0) {
													BufferedWriter duracion = new BufferedWriter(new FileWriter("Registros.txt",false));
													String Respuesta = ID3 + ";" + Recuerdo + ";" + linea + ";" + Situacion;
													
													Registros[PRO] = Respuesta;
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
											
												}


												
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
													System.out.println("");
													System.out.println("Contraseña cambiada con exito!");
													System.out.println("");
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
				System.out.println("Bienvenido al menu de analisis!");
				do {
					System.out.println("");
					System.out.println("Que deseas realizar?");
					System.out.println("");
					System.out.println("1) Actividad mas realizada");
					System.out.println("2) Actividad mas realizada por cada usuario");
					System.out.println("3) Usuario con mayor procastinacion");
					System.out.println("4) Ver todas las actividades");
					System.out.println("5) Salir");
					
						opcion = Integer.valueOf(scanner.nextLine());
						
						if(opcion == 1) {
							String [] lista3 = new String [300];
							String [] lista4 = new String [300];
							
							
							
							boolean estado = false;
							for(int t = 0; t < Registros.length;t++) {
								if(Registros[t] != null) {
									String[] partes2 = Registros[t].split(";");
									String ID2 = partes2[0];         
									String Fecha = partes2[1];
									int Horas = Integer.valueOf(partes2[2]);
									String Actividad = partes2[3];
									
									lista3[t] = Actividad;
									
									
									
									
									
								}
								
							}
							int maximo2 = 0;
							String maximo ="";
							
							for(int z = 0; z < lista3.length;z++) {
								int contador = 0;
								if(lista3[z]!= null) {
									for(int j = 0; j < lista3.length; j++) {
										if(lista3[z].equals(lista3[j])) {
											contador++;
										}
									}
									if(contador > maximo2) {
										maximo2 = contador;
										maximo = lista3[z];
									}
									
								}

							}
							
							System.out.println("");
							System.out.println("La actividad mas realizada por los usuarios fue:"+" "+ maximo +" "+ "y se repite un total del"+" "+maximo2+" "+ "veces");
							
							
							
							
						}
						if(opcion == 2) {
							String [] lista1 = new String [300];
							
							for(int i = 0; i < Registros.length;i++) {
								if(Registros[i]!=null) {
									String [] partes = Registros[i].split(";");
									String Actividad = partes[3];
									
									int posicion = 0;
									boolean hola = false;
									
									for(int j = 0; j < lista1.length;j++) {
										if(lista1[j]!=null) {
											if(lista1[j].equals(Actividad)) {
												hola = true;
												
											}else {
												posicion++;
											}
										}
									}
									if(!hola) {
										
										for(int k = 0; k < lista1.length;k++) {
											
											if(lista1[k] == null) {
												lista1[k] = Actividad;
												break;
											}
										}


									}
								}
							}
							for(int z = 0; z < Usuarios.length;z++) {
								if(Usuarios[z]!=null) {
									String [] partes = Usuarios[z].split(";");
									String ID = partes[0];
									
									int Maximo = 0;
									String ElMaximo ="";
									
									for(int y = 0; y < lista1.length;y++) {
										if(lista1[y]!=null) {
											
											String Actividad = lista1[y];
											
											int contador = 0;
											String MaximoActual ="";
											
											for(int u = 0; u < Registros.length; u++) {
												if(Registros[u]!=null) {
													String[] partes2 = Registros[u].split(";");
													String ID2 = partes2[0];
													int Horas = Integer.valueOf(partes2[2]);
													String ActividadActual = partes2[3];
													
													
													if(ID.equals(ID2)&& ActividadActual.equals(Actividad)) {
														contador = contador + Horas;
													}
													
												}
											}
											if(contador > Maximo) {
												Maximo = contador;
												ElMaximo = Actividad;
											}
											
										}
										
									}
									System.out.println(ID +" -> "+ElMaximo+" -> "+"con "+ Maximo + " horas registradas");
								}
								
							}
							
							
						}
						if(opcion == 3) { 
							int Maximo = 0; //un maximo que ocuparemos para hallar 
							String maximo = "";
							for(int U = 0; U < Usuarios.length; U++) {
								int HP = 0; // HP = horas de procastinacion
								if(Usuarios[U]!= null) {
									String[] partes1 = Usuarios[U].split(";");
									String ID1 = partes1[0];
									String Contraseña = partes1[1];
									for(int R = 0; R < Registros.length; R++) {
										if(Registros[R]!= null) {
											String[] partes2 = Registros[R].split(";");
											String ID2 = partes2[0];         
											String Fecha = partes2[1];
											int Horas = Integer.valueOf(partes2[2]);
											String Actividad = partes2[3];
											
											if(ID2.equals(ID1)) {
												HP += Horas;
											}
										}
										
									}
									System.out.println(ID1 + "," + HP +" "+ "horas");
									if(HP > Maximo) {
										Maximo = HP;
										maximo = ID1;
									}
								}
								
								
								
							}
							System.out.println(" ");
							System.out.println(maximo + " "+ "fue las persona que mas procastino con un total de:"+" "+ Maximo+ " "+ "horas");
						}
						if(opcion == 4) {
							int c = 0; // un contador
							int[] lista = new int[300];
							for(int k = 0; k < Registros.length; k++) {
								if(Registros[k]!=null) {
									String[] partes2 = Registros[k].split(";");
									String ID2 = partes2[0];         
									String Fecha = partes2[1];
									String Horas = partes2[2];
									String Actividad = partes2[3];
									
									lista[c] = k;
									c++;
									
									
									System.out.println(c+")"+ " " + Registros[k]);
									
									
									
								}
							}
							
						}
					
					
				}while(opcion !=5);
			}

			if(comando == 3) {
				System.out.println("Hasta la proxima!");
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

