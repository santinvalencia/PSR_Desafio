package desafios;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class ConversionHoraria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Conversión de Fecha y Hora entre Zonas Horarias");

        ZonedDateTime fechaArgentina = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
        System.out.println("Hora actual en Argentina: " + fechaArgentina);

        System.out.println("\nSeleccione zona horaria destino:");
        System.out.println("1. America");
        System.out.println("2. Europe");
        System.out.println("3. Asia");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        ZoneId zonaDestino;
        if (opcion == 1) {
            zonaDestino = ZoneId.of("America");
        } else if (opcion == 2) {
            zonaDestino = ZoneId.of("Europe");
        } else {
            zonaDestino = ZoneId.of("Asia");
        }

        ZonedDateTime fechaConvertida = fechaArgentina.withZoneSameInstant(zonaDestino);

        System.out.println("\nHora en zona destino: " + fechaConvertida);

        sc.close();
    }
}