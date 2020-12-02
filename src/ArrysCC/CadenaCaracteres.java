/**
 *
 */
package ArrysCC;

import Utilidades.IO_ES;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author dgdan
 */
public class CadenaCaracteres {

    public static void opcionesMenu() {
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String cyan = "\033[36m";
        String reset = "\u001B[0m";

        int opciones;
        boolean correcto = false;
        String contenido = "";
        String palabra = "$Hyperboss";
        try {
            contenido = new String(Files.readAllBytes(Paths.get("fichero/lectura.txt")));
            //System.out.println(contenido); // para visualizar el contenido del fichero por pantalla
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        int contador = 0;

        do {
            IO_ES.escribirLN(morado + "---------------------MENU CADENA DE CARACTERES---------------------" + reset);
            IO_ES.escribirLN("1. Buscar la palabra '$Hyperboss'");//Indicar cuantas veces aparece en el texto
            IO_ES.escribirLN("2. Sustituir la palabra '$Hyperboss' por 'COÑAZO'");//Además tiene que aparecer en azul
            IO_ES.escribirLN("3. Primera frase en aparecer '$Hyperboss'");
            IO_ES.escribirLN("0. Atrás");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");

            if (opciones > -1 && opciones < 4) {
                correcto = true;
            } else {
                IO_ES.escribirLN(rojo + "Escribe una opción posible" + reset);
            }

            switch (opciones) {
                case 1:
                    correcto = false;

                    while (contenido.contains(palabra)) {
                        contenido = contenido.substring(contenido.indexOf(palabra) + palabra.length());
                        contador++;
                    }

                    IO_ES.escribirLN("La palabra $Hyperboss aparece en el texto: " + contador);
                    break;
                case 2:
                    correcto = false;

                    String nuevaPalabra = "COÑAZO";
                    String nuevoContenido = contenido.replace(palabra, azul + nuevaPalabra + reset);
                    IO_ES.escribirLN(nuevoContenido);
                    break;
                case 3:
                    correcto = false;

                    String[] texto = contenido.split("\\.");

                    boolean encontrado = false;
                    for (int i = 0; i < texto.length && !encontrado; i++) { //Consegimos parar el bucle cuando le ponemos una condición
                        if (texto[i].contains(palabra)) {
                            encontrado = true;
                            IO_ES.escribirLN("La primera frase en a parecer la palabra $Hyperboss es:\n" + texto[i]);
                        }
                    }
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }
}
