package desafios;

import java.util.Random;
import java.util.Scanner;

public class JuegoDeAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean x = false;
        int numeroAleatorio = random.nextInt(100) + 1;
        int intento = 0;
        
        System.out.println("Bienvenido al Juego de Adivinanza!");
        System.out.println("He generado un número entre 1 y 100. ¡Intenta adivinarlo!");

        while (x = false) { // bucle para adivinar repetidas veces
            System.out.print("Ingrese su adivinanza: ");
            intento = scanner.nextInt();

            // Comprobar la adivnianza
            if (intento < numeroAleatorio) {
                System.out.println("Demasiado bajo. Intenta de nuevo.");
            } else if (intento > numeroAleatorio) {
                System.out.println("Demasiado alto. Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número correcto: " + numeroAleatorio);
                x = true; // gano: fin de bloque
            }
        }
    }
}
