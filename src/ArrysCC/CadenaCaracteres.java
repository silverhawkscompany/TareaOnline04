/**
 *
 */
package ArrysCC;

import Utilidades.Color;
import Utilidades.IO_ES;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Daniel Díaz González
 */
public class CadenaCaracteres {

    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;
        String contenido = "";
        String palabra = "$Hyperboss";
        int contador = 0;
        //Contenido del texto
        try {
            contenido = new String(Files.readAllBytes(Paths.get("fichero/lectura.txt")));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        do {
            IO_ES.escribirLN(Color.azul() + "--------------------------MENU CADENA DE CARACTERES--------------------------" + Color.reset());
            IO_ES.escribirLN("1. Buscar la palabra '$Hyperboss'");//Indicar cuantas veces aparece en el texto
            IO_ES.escribirLN("2. Sustituir la palabra '$Hyperboss' por 'COÑAZO'");//Además tiene que aparecer en azul
            IO_ES.escribirLN("3. Primera frase en aparecer '$Hyperboss'");
            IO_ES.escribirLN("0. Atrás");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");

            if (opciones > -1 && opciones < 4) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
            }

            switch (opciones) {
                case 1:
                    correcto = false;

                    while (contenido.contains(palabra)) {
                        contenido = contenido.substring(contenido.indexOf(palabra) + palabra.length());
                        contador++;
                    }
                    IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                    IO_ES.escribirLN("La palabra $Hyperboss aparece en el texto: " + contador);
                    break;
                case 2:
                    correcto = false;

                    String nuevaPalabra = "COÑAZO";
                    String nuevoContenido = contenido.replace(palabra, Color.azul() + nuevaPalabra + Color.reset());
                    IO_ES.escribirLN(nuevoContenido);
                    break;
                case 3:
                    correcto = false;
                    //Cada frase del texto es contenida en cada apartado de la matriz, es separado por cada punto "."
                    String[] texto = contenido.split("\\.");
                    boolean encontrado = false;
                    for (int i = 1; i < texto.length && !encontrado; i++) { //Consegimos parar el bucle cuando le ponemos una condición
                        if (texto[i].contains(palabra)) {
                            encontrado = true;
                            IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                            IO_ES.escribirLN("La primera frase en a parecer la palabra $Hyperboss es:");
                            IO_ES.escribirLN(texto[i]);
                        }
                    }
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }
}
