/**
 *
 */
package ArrysCC;

import Utilidades.Color;
import Utilidades.IO_ES;

/**
 *
 * @author Daniel Díaz González
 */
public class Arrays {

    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "-------------------------------MENU DE ARRAYS--------------------------------" + Color.reset());
            IO_ES.escribirLN("1. Mostrar un Array de 10 con 10 primeros números pares");
            IO_ES.escribirLN("2. Acierte un número de un Array de 10 con números aleatorios");
            IO_ES.escribirLN("3. Elije el tamaño de un Array aleatorio, para ver la media, el mayor y el menor valor");
            IO_ES.escribirLN("4. Elije el tamaño de un Array aleatorio para visualizarlo y ver los número mayores y menores de 50");
            IO_ES.escribirLN("0. Atrás");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones < 5 && opciones > -1) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                    array10pares();
                    break;
                case 2:
                    correcto = false;
                    IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                    array10aleatorio();
                    break;
                case 3:
                    correcto = false;
                    IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                    elijeArrayMedia();
                    break;
                case 4:
                    correcto = false;
                    IO_ES.escribirLN(Color.azul() + "-----------------------------------------------------------------------------" + Color.reset());
                    elijeArray50();
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }

    public static void array10pares() {
        int pares[] = new int[10];//Declaración de la matriz
        for (int i = 0; i < 10; i++) {//Cuidado i siempre es menor al tamaño de la matriz
            pares[i] = 2 * i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Valor del indice: " + i + " = " + pares[i]);
        }
    }

    public static void array10aleatorio() {
        boolean encontrado = false;
        int numero;
        int aleatorio[] = new int[10];
        //Creamos una matriz aleatoriade hasta el numero 20
        for (int i = 0; i < 10; i++) {
            aleatorio[i] = (int) Math.round(Math.random() * 20);
        }
        //Repetimos que recorra el arrays hasta que encontremos un numero acertado
        do {
            numero = IO_ES.leerInteger("Elije un número: ");

            for (int i = 0; i < 10; i++) {
                if (aleatorio[i] == numero) {
                    IO_ES.escribirLN(Color.verde() + "Has acertado!!" + Color.reset());
                    //Aqui falla si le incorporo el numero que hemos puesto
                    IO_ES.escribirLN("El número se encuentra en la posición: " + i);
                    //Mostramos el array para que veas la posicion del número acertado
                    for (int j = 0; j < 10; j++) {
                        IO_ES.escribir(aleatorio[j] + " ");
                    }
                    IO_ES.escribirLN("");
                    encontrado = true;
                }
            }
        } while (encontrado == false);//Cuidado he fallado puse "=" y no "=="
        IO_ES.escribirLN("");
    }

    public static void elijeArrayMedia() {
        int tamaño;

        tamaño = IO_ES.leerInteger("Elije el tamaño de un Array: ");
        double[] aleatorio = new double[tamaño];
        //Lenamos el Array con números aleatorios
        for (int i = 0; i < tamaño; i++) {
            aleatorio[i] = Math.random() * 100;
        }
        //Mostramos el array
        for (double i : aleatorio) {
            System.out.printf("%1.2f", i);
            IO_ES.escribir("  ");
        }
        IO_ES.escribirLN("");
        //Oredenamos el array de menor a mayor
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 1; j < (tamaño - i); j++) {
                // si el elemento anterior es mayor, hacemos el cambio
                if (aleatorio[j - 1] > aleatorio[j]) {
                    double aux_elem = aleatorio[j];
                    aleatorio[j] = aleatorio[j - 1];
                    aleatorio[j - 1] = aux_elem;
                }
            }
        }
        //Menor
        IO_ES.escribir("El número menor es: ");
        System.out.printf("%1.2f", aleatorio[0]);
        IO_ES.escribirLN("");
        //Mayor
        IO_ES.escribir("El número mayor es: ");
        System.out.printf("%1.2f", aleatorio[tamaño - 1]);
        IO_ES.escribirLN("");
        //Media
        double suma = 0;
        double media = 0;
        for (int i = 0; i < tamaño; i++) {
            suma += aleatorio[i];
            media = suma / 2;
        }
        IO_ES.escribir("La media de la matriz es: ");
        System.out.printf("%1.2f", media);
        IO_ES.escribirLN("");
    }

    public static void elijeArray50() {
        int tamaño;

        tamaño = IO_ES.leerInteger("Elije el tamaño de un Array: ");
        double[] aleatorio = new double[tamaño];

        //Lo llenamos aleatoriamente
        for (int i = 0; i < tamaño; i++) {
            aleatorio[i] = Math.random() * 100;
        }
        //Mostramos el array con un bucle for each
        for (double i : aleatorio) {
            System.out.printf("%1.2f", i);
            IO_ES.escribir("  ");
        }
        IO_ES.escribirLN("");
        //Oredenamos el array de menor a mayor
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 1; j < (tamaño - i); j++) {
                // si el elemento anterior es mayor, hacemos el cambio
                if (aleatorio[j - 1] > aleatorio[j]) {
                    double aux_elem = aleatorio[j];
                    aleatorio[j] = aleatorio[j - 1];
                    aleatorio[j - 1] = aux_elem;
                }
            }
        }
        IO_ES.escribirLN("Los números mayores a 50 son:");
        IO_ES.escribirLN("-----------------------------");
        //Recorremos el array con un bucle de nuevo y mostramos que valores de la matriz que son mayores a 50
        for (int i = 0; i < tamaño; i++) {
            if (aleatorio[i] > 50) {
                System.out.printf("%1.2f", aleatorio[i]);
                IO_ES.escribirLN("");
            }
        }
        IO_ES.escribirLN("Los números menores a 50 son:");
        IO_ES.escribirLN("-----------------------------");
        //Recorremos el array con un bucle de nuevo y mostramos que valores de la matriz que son menores a 50
        for (int i = 0; i < tamaño; i++) {
            if (aleatorio[i] < 50) {
                System.out.printf("%1.2f", aleatorio[i]);
                IO_ES.escribirLN("");
            }
        }
    }
}
