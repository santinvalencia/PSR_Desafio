package desafios;

import java.util.Scanner;

public class TarjetaCredito{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir número de tarjeta
        System.out.print("Ingresa el número de la tarjeta de crédito: ");
        String numeroTarjeta = scanner.nextLine();

        // Validar el número utilizando el algoritmo de Luhn
        boolean esValido = validarTarjeta(numeroTarjeta);

        // Mostrar el resultado
        if (esValido) {
            System.out.println("El número de la tarjeta de crédito es válido.");
        } else {
            System.out.println("El número de la tarjeta de crédito NO es válido.");
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método para validar el número de la tarjeta de crédito usando el algoritmo de Luhn
    private static boolean validarTarjeta(String numeroTarjeta) {
        int suma = 0;
        boolean esPar = false;

        // Recorrer los números de la tarjeta de derecha a izquierda
        for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
            char digitoChar = numeroTarjeta.charAt(i);
            int digito = Character.getNumericValue(digitoChar);

            // Duplicar cada segundo dígito
            if (esPar) {
                digito *= 2;
                // Si el resultado es mayor a 9, restar 9
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
            esPar = !esPar; // Cambiar el estado de par/impar
        }

        // La tarjeta es válida si la suma es múltiplo de 10
        return (suma % 10 == 0);
    }
}

