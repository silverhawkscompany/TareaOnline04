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

        do {
            IO_ES.escribirLN(Color.azul() + "--------------------------MENU CADENA DE CARACTERES--------------------------" + Color.reset());
            IO_ES.escribirLN(Color.azul() + "1. Buscar la palabra '$Hyperboss'");//Indicar cuantas veces aparece en el texto
            IO_ES.escribirLN(Color.azul() + "2. Sustituir la palabra '$Hyperboss' por 'COÑAZO'");//Además tiene que aparecer en azul
            IO_ES.escribirLN(Color.azul() + "3. Primera frase en aparecer '$Hyperboss'");
            IO_ES.escribirLN("0. Atrás" + Color.reset());//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            //IF-Else para que solo podamos escribir numeros entre 0 y 3, incluidos estos
            if (opciones > -1 && opciones < 4) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    buscarPalabra();
                    break;
                case 2:
                    correcto = false;
                    remplazarPalabra();
                    break;
                case 3:
                    correcto = false;
                    buscarFrase();
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }

    //Métodos
    //1
    public static void buscarPalabra() {
        String texto = "";
        String palabra = "$Hyperboss";
        int contador = 0;

        //Variable que contiene el texto
        try {
            texto = new String(Files.readAllBytes(Paths.get("fichero/lectura.txt")));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        while (texto.contains(palabra)) {
            texto = texto.substring(texto.indexOf(palabra) + palabra.length());
            contador++;
        }
        IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
        IO_ES.escribirLN("La palabra $Hyperboss aparece en el texto: " + contador);
    }

    //2
    public static void remplazarPalabra() {
        String texto = "";
        String palabra = "$Hyperboss";

        //Variable que contiene el texto
        try {
            texto = new String(Files.readAllBytes(Paths.get("fichero/lectura.txt")));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        String nuevaPalabra = "COÑAZO";
        String nuevoContenido = texto.replace(palabra, Color.azul() + nuevaPalabra + Color.reset());
        IO_ES.escribirLN(nuevoContenido);
    }

    //3
    public static void buscarFrase() {
        String texto = "";
        String palabra = "$Hyperboss";

        //Variable que contiene el texto
        try {
            texto = new String(Files.readAllBytes(Paths.get("fichero/lectura.txt")));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        //Cada frase del texto es contenida en cada apartado de la matriz, es separado por cada punto "."
        String[] arrayTexto = texto.split("\\.");
        boolean encontrado = false;
        //Consegimos parar el bucle cuando le ponemos una condición
        for (int i = 0; i < arrayTexto.length && !encontrado; i++) {
            if (arrayTexto[i].contains(palabra)) {
                encontrado = true;
                IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                IO_ES.escribirLN("La primera frase en a parecer la palabra $Hyperboss es:");
                IO_ES.escribirLN(arrayTexto[i]);
            }
        }
    }
}
