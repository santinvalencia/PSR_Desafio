package desafios;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LectuEscrituArchivos {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String nombreArchivo = "datos.txt";

	        try {
	            // Escribir datos en el archivo
	            System.out.println("=== Escritura en archivo ===");
	            System.out.print("Ingrese el texto que desea guardar: ");
	            String texto = scanner.nextLine();

	            FileWriter escritor = new FileWriter(nombreArchivo, true); // 'true' = agrega al final
	            escritor.write(texto + "\n");
	            escritor.close();
	            System.out.println("Texto guardado correctamente en " + nombreArchivo);

	            // Leer datos del archivo
	            System.out.println("\n=== Lectura del archivo ===");
	            FileReader lector = new FileReader(nombreArchivo);
	            BufferedReader buffer = new BufferedReader(lector);

	            String linea;
	            while ((linea = buffer.readLine()) != null) {
	                System.out.println(linea);
	            }

	            buffer.close();
	            lector.close();

	        } catch (IOException e) {
	            System.out.println("Ocurrió un error al leer o escribir el archivo: " + e.getMessage());
	        }

	        scanner.close();
	    }
}
