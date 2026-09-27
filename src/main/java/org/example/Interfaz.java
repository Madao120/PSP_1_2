package org.example;
import java.io.IOException;
import java.util.Scanner;

public class Interfaz {
    // Añado el throws exception para que en caso de estos errores no se rompa el código (Inteliji me indicaba que hacían falta, me había olvidado de ponerlos)
    public static void main(String args[]) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String input = "";

        while (!input.equals("0")) {

            System.out.println("Introduce un nivel:");
            System.out.println("1 - Nivel 1");
            System.out.println("2 - Nivel 2");
            System.out.println("3 - Nivel 3");
            System.out.println("4 - Nivel 4");
            System.out.println("Escribe '0' para terminar");

            input = teclado.nextLine();

            //Esatblecemos numero como String, esto debido a que en ProcessBuilder solo se acepta Strnig,
            // y para no complicarse pasando de integer a string me pareció mejor idea String directamente
            String numero;

            switch (input) {

                case "1":
                    System.out.println("Se ha seleccionado el nivel 1, calcular factor");

                    // Con un do while conseguiremos que mientras no se ponga salir no salga
                    do {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        System.out.print("> ");

                        // Haremos que el usuario escriba otro número, esta vez no para el nivel, si no para calcular su factor o lo que indique el nivel
                        numero = teclado.nextLine();

                        // Mientras no sea salir lanzará la función
                        if (!numero.equalsIgnoreCase("salir")) {
                            Lanzador.nivel1(numero);
                        }

                    } while (!numero.equalsIgnoreCase("salir"));

                    break;

                case "2":
                    System.out.println("Se ha seleccionado el nivel 2");

                    do {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        System.out.print("> ");

                        numero = teclado.nextLine();

                        if (!numero.equalsIgnoreCase("salir")) {
                            Lanzador.nivel2(numero);
                        }

                    } while (!numero.equalsIgnoreCase("salir"));
                    break;

                case "3":
                    System.out.println("Se ha seleccionado el nivel 3");

                    do {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        System.out.print("> ");

                        numero = teclado.nextLine();

                        if (!numero.equalsIgnoreCase("salir")) {
                            Lanzador.nivel3(numero);
                        }

                    } while (!numero.equalsIgnoreCase("salir"));
                    break;

                case "4":
                    System.out.println("Se ha seleccionado el nivel 4");

                    do {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        System.out.print("> ");

                        numero = teclado.nextLine();

                        if (!numero.equalsIgnoreCase("salir")) {
                            Lanzador.nivel4(numero);
                        }

                    } while (!numero.equalsIgnoreCase("salir"));
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }

        teclado.close();
    }
}
