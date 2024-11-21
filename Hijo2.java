package dam2pspt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Hijo2 {

	public static void main(String[] args) {
		String fileRecibido = " ";

		InputStreamReader isr = new InputStreamReader(System.in);//recoge lo que esta escribiendo el metodo 
		BufferedReader br = new BufferedReader(isr);

		try {
			fileRecibido = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (br != null) {
				br.close();
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
				String[] numeros = linea.trim().split(" ");
				
				for(String numero : numeros) {
					suma += Integer.parseInt(numero);
					//System.out.println(numero);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		File nuevoArchivo = new File(rutaFile.getParent() + File.separator + "resultadoSuma.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoArchivo, true))){
			//cont += 1;
			bw.write(String.valueOf(suma));
			bw.newLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}