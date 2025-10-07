package desafios;

import java.util.Scanner;

public class Conversion_unid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona la conversion que deseas realizar:");
        System.out.println("1: Euros a dolares");
        System.out.println("2: dolares a Euros");
        System.out.print("Ingresa el numero de la conversion: ");
        int opcion = scanner.nextInt();

        float valor;
        float resultado;

        // inicia conversión segun la opcion que elija
        switch (opcion) {
            case 1:
                System.out.print("Ingresa la cantidad en euros: ");
                valor = scanner.nextFloat();
                resultado = (float) (valor * 1.16); 
                System.out.printf("Cantidad en dolares: %.2f $%n", resultado);
                break;
            case 2:
                System.out.print("Ingresa la cantidad en dolares: ");
                valor = scanner.nextFloat();
                resultado = (float) (valor / 1.16); //
                System.out.printf("Cantidad en euros: %.2f €%n", resultado);
                break;
            default:
                System.out.println("Opcion invalida. Por favor seleccione una opcion valida.");
                break;
        }
    }
}

