package dam2pspt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) {
		String fileRecibido = " ";

		InputStreamReader isr = new InputStreamReader(System.in);//recoge lo que esta escribiendo el metodo 
		BufferedReader br = new BufferedReader(isr);

		try {
			fileRecibido = br.readLine();//guardamos la lectura en la variable que hemos creado anteriormente, tiene que tene un valor para poder añadir el readLine a este 
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (br != null) {
				br.close();//verificamos que no este nullo en buffer, no ayuda a un mejor manejo de este 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("La ruta del archivo es: " + fileRecibido);
		
		System.out.println(fileRecibido);
		
		leerArchivo(fileRecibido);
		sumarCantidad(fileRecibido);
		
	}
	
	public static void leerArchivo(String file) {
		String textoArchivo = file;
		
		try (BufferedReader br1 = new BufferedReader(new FileReader(textoArchivo))){
			String line = " ";
			while((line = br1.readLine()) != null) {
				System.out.println(line);
				line = br1.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void sumarCantidad(String file){
		File rutaFile = new File(file);
		//System.out.println(file);
		int suma = 0;
		//int cont = 1;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String linea;
			while((linea = br.readLine()) != null) {
				//System.out.println(linea);
				String[] numeros = linea.trim().split(" ");//el trim quita los espacios que estorven , por ejermplo " hola "  se convertiria en "hola" asi manejamos de una mejor manera el strim para poder usarlo de una manera mas limpia en el programa
				
				for(String numero : numeros) {
					suma += Integer.parseInt(numero);
					//System.out.println(numero);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		File nuevoArchivo = new File(rutaFile.getParent() + File.separator + "resultadoSuma.txt");//el file separator nos ayuda a asegurar el separadot de arcihvo dependiendo del SO en el que ejecutemos el progrmaa
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoArchivo, true))){//con true nos syuda a opder añadir y o sobreescriir
			//cont += 1;
			bw.write(String.valueOf(suma));//lo convertimos a un valor String para poder escribirlo con el meodo Writer
			bw.newLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}