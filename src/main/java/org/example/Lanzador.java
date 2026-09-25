package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Lanzador {
    public static void nivel1() throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equalsIgnoreCase("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equals("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            // Con esto conseguimos que utilice la consola para mostrar la salida y errores en caso de que se den
            pb.inheritIO();

            Process proceso = pb.start();

            // Se pone el waitFor para esperar a que el "proceso se ejecute"
            int codigoSalida = proceso.waitFor();

            // Ahora si que sacamos el código de salida una vez esperado a el proceso
            System.out.println("Operación completada. Código de salida: " + codigoSalida);
        }
    }

    public static void funcion2(){

    }

    public static void funcion3(){

    }

    public static void funcion4(){

    }

    // Función auxiliar para funcion1, para comprobar si numero es en verdad un numero
    public static boolean esNumero(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            // Si el número se para a Int dentro de la función es correcto
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // Si numero no puede pararse a int es que será un texto, dará false
            return false;
        }
    }
}
