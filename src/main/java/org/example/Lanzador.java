package org.example;

import java.io.*;
import java.util.Scanner;

public class Lanzador {
    public static void nivel1() throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equals("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equals("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea = lector.readLine();

            System.out.println(linea);

            int codigoSalida = proceso.waitFor();

            System.out.println("Operación completada. Código de salida: " + codigoSalida);

        }
    }

    public static void nivel2() throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equals("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equals("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            int codigoSalida = proceso.waitFor();

            String resultado;

            if (codigoSalida == 0) {
                resultado = "[OK]";
            } else {
                resultado = "[ERROR]";
            }

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea = lector.readLine();

            System.out.println(resultado + " " + linea);
        }
    }

    public static void nivel3() {
    }

    public static void nivel4() {
    }
}
