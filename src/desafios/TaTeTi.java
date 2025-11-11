package desafios;
import java.util.Scanner;

public class TaTeTi {
    static char[][] tablero = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char jugadorActual = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        System.out.println("=== Juego de Ta-Te-Ti ===");

        while (!juegoTerminado) {
            mostrarTablero();
            System.out.println("Turno del jugador " + jugadorActual);
            System.out.print("Ingrese fila (0, 1 o 2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese columna (0, 1 o 2): ");
            int columna = scanner.nextInt();

            if (movimientoValido(fila, columna)) {
                tablero[fila][columna] = jugadorActual;
                if (hayGanador()) {
                    mostrarTablero();
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                } else if (tableroLleno()) {
                    mostrarTablero();
                    System.out.println("¡Empate!");
                    juegoTerminado = true;
                } else {
                    cambiarJugador();
                }
            } else {
                System.out.println("Movimiento inválido. Intenta nuevamente.");
            }
        }

        scanner.close();
    }

    public static void mostrarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean movimientoValido(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            return tablero[fila][columna] == ' ';
        }
        return false;
    }

    public static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public static boolean hayGanador() {
        // Detección de filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;
            }
        }
        // Deteccion de columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugadorActual && tablero[1][j] == jugadorActual && tablero[2][j] == jugadorActual) {
                return true;
            }
        }
        // Deteccion de diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;
        }
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;
        }
        return false;
    }

    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
