package dam2pspt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Padre {
	public static Scanner scan = new Scanner(System.in);
	public static String[] comando1 = { "java", "Hijo.java" };
	public static String[] comando2 = {"java", "Hijo1.java"};
	public static String[] comando3 = {"java", "Hijo2.java"};
	public static List<String> archivosTxt = new ArrayList<>();//acá es donde se guardaran todos los archivos que tengan la extension .txt

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Escribe el nombre de la ruta:   ");
		String ruta = scan.nextLine();
		if (ruta.isEmpty()) {
			System.out.println("La ruta del directorio no puede estar vacia");
		} else {

			File file = new File(ruta);
			if (!file.exists()) {								//de la linea 33 hasta la 44 verificamos si es un directorio si existe y tambien haciendo un for en los files listados para luego ver si temrina el archivo con .txt
				System.out.println("El directorio no existe");
			} else if (!file.isDirectory()) {
				System.out.println("No es un directorio");
			} else {
				try {
					File[] archivos = file.listFiles(); 
					
					for(File archivo : archivos) {
						if(archivo.getName().endsWith(".txt")) {
							archivosTxt.add(archivo.getAbsolutePath());
						}
					}
					
					//estamos haciendo un proceso para cada archivo txt que se encuentro con los difrentes nombre, de y colocamos que el hilo se duerma con 1000 milisegundos para un mejor control de los rocesos
					for(String comandoArchivoTxt : archivosTxt) {
						Thread.sleep(1000);
						if(comandoArchivoTxt.endsWith("Gestion.txt")) {				
							ProcessBuilder pb = new ProcessBuilder(comando1);
							pb.directory(new File("C:\\Users\\Hari\\eclipse-workspace\\ExamenPadreHijo\\src\\dam2pspt1"));
							Process proceso = pb.start();
							retornoFichero(proceso, comandoArchivoTxt);// lo enviara lo que retorne el metodo retornoFichero, al proceso hijo
							lecturaProcesoHijo(proceso);
							leerSumaTotal();
						}else if(comandoArchivoTxt.endsWith("Logistica.txt")) {
							ProcessBuilder pb2 = new ProcessBuilder(comando2);
							pb2.directory(new File("C:\\Users\\Hari\\eclipse-workspace\\ExamenPadreHijo\\src\\dam2pspt1"));
							Process proceso = pb2.start();
							retornoFichero(proceso, comandoArchivoTxt);// lo enviara lo que retorne el metodo retornoFichero, al proceso hijo
							lecturaProcesoHijo(proceso);
							leerSumaTotal();
						}else if(comandoArchivoTxt.endsWith("Marketing.txt")) {
							ProcessBuilder pb3 = new ProcessBuilder(comando2);
							pb3.directory(new File("C:\\Users\\Hari\\eclipse-workspace\\ExamenPadreHijo\\src\\dam2pspt1"));
							Process proceso = pb3.start();
							retornoFichero(proceso, comandoArchivoTxt);// lo enviara lo que retorne el metodo retornoFichero, al proceso hijo
							lecturaProcesoHijo(proceso);
							leerSumaTotal();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void retornoFichero(Process proceso, String ruta) {
		OutputStream os = proceso.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		try {
			bw.write(ruta);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void lecturaProcesoHijo(Process respuesta) {
		InputStream is = respuesta.getInputStream();//obtiene es input del hijo para luego hacer un metodo para poder leer sysout que nos esta retornando
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String linea = " ";
			linea = br.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void leerSumaTotal() throws FileNotFoundException, IOException {
		String ruta = "C:\\Users\\Hari\\dir6\\resultadoSuma.txt";
		File file = new File(ruta);

		int suma = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String linea;
			while( (linea = br.readLine()) != null) {
				suma += Integer.parseInt(linea);
			}
			System.out.println("El resultado de suma es: " + suma);
		}
		
		String resultadoFinal = String.valueOf(suma);
		System.out.println(resultadoFinal);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Hari\\dir4\\resultadoSuma.txt"))){
			bw.write("La suma toal de total las sumas de los archivos es: " + String.valueOf(resultadoFinal));
		}
	}
}