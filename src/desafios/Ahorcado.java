package desafios;
import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Lista de palabras posibles
        String[] palabras = {"java", "computadora", "programacion", "teclado", "ahorcado"};
        
        // Selecciona una palabra al azar
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
        char[] palabraAdivinada = new char[palabraSecreta.length()];

        // Inicializa con guiones bajos
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        int intentosRestantes = 6;
        boolean palabraAdivinadaCompleta = false;

        System.out.println("Bienvenido al juego del Ahorcado.");
        System.out.println("Tienes " + intentosRestantes + " intentos para adivinar la palabra.");

        while (intentosRestantes > 0 && !palabraAdivinadaCompleta) {
            System.out.print("\nPalabra: ");
            mostrarProgreso(palabraAdivinada);
            System.out.print("\nIngresa una letra: ");
            char letra = Character.toLowerCase(sc.next().charAt(0));

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && palabraAdivinada[i] == '_') {
                    palabraAdivinada[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentosRestantes--;
                System.out.println("Letra incorrecta. Te quedan " + intentosRestantes + " intentos.");
            }

            // Verifica si la palabra fue completada
            palabraAdivinadaCompleta = true;
            for (char c : palabraAdivinada) {
                if (c == '_') {
                    palabraAdivinadaCompleta = false;
                    break;
                }
            }
        }

        if (palabraAdivinadaCompleta) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\nTe has quedado sin intentos. La palabra era: " + palabraSecreta);
        }

        sc.close();
    }

    // Muestra el progreso actual de la palabra
    public static void mostrarProgreso(char[] palabra) {
        for (char c : palabra) {
            System.out.print(c + " ");
        }
    }
}
