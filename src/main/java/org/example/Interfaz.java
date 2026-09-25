package org.example;
import java.util.Scanner;

public class Interfaz {
    public static void main(String args[]) {
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

            switch (input) {

                case "1":
                    System.out.println("Se ha seleccionado el nivel 1, calcular factor");
                    Lanzador.nivel1();
                    break;

                case "2":
                    System.out.println("Se ha seleccionado el nivel 2");
                    Lanzador.nivel2();
                    break;

                case "3":
                    System.out.println("Se ha seleccionado el nivel 3");
                    break;

                case "4":
                    System.out.println("Se ha seleccionado el nivel 4");
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
