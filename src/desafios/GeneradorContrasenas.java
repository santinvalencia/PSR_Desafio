package desafios;

import java.util.Random;
import java.util.Scanner;

public class GeneradorContrasenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Generador de Contraseñas Seguras ===");
        System.out.print("Ingrese la longitud deseada de la contraseña: ");
        int longitud = scanner.nextInt();

        String contrasena = generarContrasena(longitud);
        System.out.println("Tu contraseña generada es: " + contrasena);

        scanner.close();
    }

    public static String generarContrasena(int longitud) {
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&*()-_=+[]{};:,.<>?/";

        // Unir todos los tipos de caracteres
        String todos = mayusculas + minusculas + numeros + simbolos;

        Random random = new Random();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(todos.length());
            contrasena.append(todos.charAt(index));
        }

        return contrasena.toString();
    }
}
