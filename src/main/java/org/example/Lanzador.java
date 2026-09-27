package org.example;

import java.io.*;
import java.util.Scanner;

public class Lanzador {

    // El nivel 1 trata de realizar factor a un número, devolviendo la respuesta de terminal directamente por consola
    public static void nivel1() throws IOException, InterruptedException {

        // Establecemos el teclado para que el usuario o cliente pueda escribir
        Scanner teclado = new Scanner(System.in);

        //Esatblecemos numero como String, esto debido a que en ProcessBuilder solo se acepta Strnig,
        // y para no complicarse pasando de integer a string me pareció mejor idea String directamente
        String numero = "";

        // Este ucle es el cual nos preguntará de que número queremos que salga el factor hasta que escribamos salir
        while (!numero.equalsIgnoreCase("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            // Ahora pediremos al usuario que escriba un número
            numero = teclado.nextLine();

            // Mientras ese numero no sea salir no forzaremos que salga del bucle
            if (numero.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            // Establecemos el ProcessBuilder como pb, esto para establecer la opreación que haremos en terminal
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            // Como queremos que se devuelva el mensaje de error en caso de que se dé,
            // pondremos el redirectErrorStream de pb en true
            pb.redirectErrorStream(true);

            // Iniciaremos la operación por terminal
            Process proceso = pb.start();

            // Gracias a estas línes de código podremos recibir la respuesta de terminal del pb
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            // Estableceremos la respuesta de terminal como un String, el cual contendrá la operación deseada,
            // que en este caso sería el factor y el error
            String linea = lector.readLine();

            // Imprimiremos la respuesta del factor
            System.out.println(linea);

            // Gracias a esta línea de código recibiremos el código de salida, que en palabras sencillas es que 0 significa completada sin errores, y 1 es que hubo errores,
            int codigoSalida = proceso.waitFor();

            // Después de imprimir el factor ahora escribiremos el código de salida con esta línea.
            System.out.println("Operación completada. Código de salida: " + codigoSalida);

        }
    }

    // Ahora a aorte de calcular el factor, dependiendo del código que recibamos indicaremos
    // [OK] si el código de salida es 0 o [ERROR] si el código de salida es 1
    public static void nivel2() throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equalsIgnoreCase("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equalsIgnoreCase("salir")) {
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

            int codigoSalida = proceso.waitFor();

            String resultado;

            if (codigoSalida == 0) {
                resultado = "[OK]";
            } else {
                resultado = "[ERROR]";
            }

            System.out.println(resultado + " " + linea);
        }
    }

    // Ahora en caso de ERROR o OK guardaremos el código de operación + la línea de respuesta en un fichero u otro
    // ERROR en factor_error.log y OK en factor_output.log
    public static void nivel3()  throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equalsIgnoreCase("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equalsIgnoreCase("salir")) {
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

            int codigoSalida = proceso.waitFor();

            String resultado;

            if (codigoSalida == 0) {
                resultado = "[OK]";
                FileWriter fichero = new FileWriter("factor_output.log", true);
                fichero.write(resultado + " " + linea + "\n");
                fichero.close();


            } else {
                resultado = "[ERROR]";
                FileWriter fichero = new FileWriter("factor_error.log", true);
                fichero.write(resultado + " " + linea + "\n");
                fichero.close();
            }

            System.out.println(resultado + " " + linea);
        }
    }

    // Este último nivel, a parte de calcular el factor, y escribir OK o ERROR dependiendo el código de salida
    // Comprobaremos si el número recibido en factor es primo o no
    // Esto lo hacemos comprobando si la respuesta es numero : numero, ya que si un número solo es divisible por si mismo (y uno, aunque en factor no se muestra así que no hace fata)
    // es que es primo (la verdad que en principio estaba haciendo un bucle for para calcularlo pero al pedirle el for a chatgpt me dijo que numero : numero era una posibilidad)
    public static void nivel4()  throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String numero = "";

        while (!numero.equalsIgnoreCase("salir")) {

            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            numero = teclado.nextLine();

            if (numero.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            int codigoSalida = proceso.waitFor();

            String resultado;

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea = lector.readLine();

            if (codigoSalida == 0) {
                resultado = "[OK]";
                System.out.println(resultado + " " + linea);
                if (linea.equals(numero + ": " + numero)) {
                    System.out.println("¡" + numero + " es primo!");
                } else {
                    System.out.println(numero + " no es primo");
                }
            } else {
                resultado = "[ERROR]";
            }

            System.out.println(resultado + " " + linea);
        }
    }
}
