package ArrysCC;

import Utilidades.Color;
import Utilidades.IO_ES;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Arrays {

    /**
     * Menu para los Arrays
     */
    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "-------------------------------MENU DE ARRAYS--------------------------------" + Color.reset());
            IO_ES.escribirLN(Color.azul() + "1. Mostrar un Array de 10 con los 10 primeros números pares");
            IO_ES.escribirLN(Color.azul() + "2. Acierte un número de un Array de 10 con números aleatorios");
            IO_ES.escribirLN(Color.azul() + "3. Elije el tamaño de un Array aleatorio, para ver la media, el mayor y el menor valor");
            IO_ES.escribirLN(Color.azul() + "4. Elije el tamaño de un Array aleatorio para visualizarlo y ver los número mayores y menores de 50");
            IO_ES.escribirLN("0. Atrás" + Color.reset());//Solo se debe salir al pulsar 0

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

    /**
     * Método para mostrar un Array de tamaño 10 con los 10 primeros números
     * pares
     */
    public static void array10pares() {
        int pares[] = new int[10];//Declaración de la matriz
        for (int i = 0; i < 10; i++) {//Cuidado i siempre es menor al tamaño de la matriz
            pares[i] = 2 * i;
        }
        for (int i = 0; i < 10; i++) {
            IO_ES.escribirLN("Valor del indice: " + i + " = " + pares[i]);
        }
    }

    /**
     * Método para poder acertar un número dentro de un Array de tamaño 10 con
     * números aleatorios
     */
    public static void array10aleatorio() {
        boolean encontrado = false;
        int numero;
        int aleatorio[] = new int[10];
        //Creamos una matriz aleatoriade hasta el número 20
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
                    IO_ES.escribirLN("El número se encuentra en la posición: " + (i + 1));
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                IO_ES.escribirLN(Color.rojo() + "No has acertado!!" + Color.reset());
            }
        } while (encontrado == false);//Cuidado he fallado puse "=" y no "=="
        //Mostramos el array para que veas la posicion del número acertado
        IO_ES.escribirLN("Array aleatorio: ");
        IO_ES.mostrarArrayEntero(aleatorio);
    }

    /**
     * Método para elegir el tamaño de un Array aleatorio, y mostrarnos la
     * media, el mayor y el menor valor
     */
    public static void elijeArrayMedia() {
        int tamaño;

        tamaño = IO_ES.leerInteger("Elije el tamaño de un Array: ");
        double[] aleatorio = new double[tamaño];
        //Llenamos el Array con números aleatorios
        for (int i = 0; i < tamaño; i++) {
            aleatorio[i] = Math.random() * 100;
        }
        //Mostramos el array
        IO_ES.mostrarArrayDecimal(aleatorio);
        //Oredenamos el array de menor a mayor
        IO_ES.ordenarArray(aleatorio, tamaño);
        //Menor
        IO_ES.escribir("El número menor es: ");
        IO_ES.escribirFormato("%1.2f", aleatorio[0]);
        IO_ES.escribirLN("");
        //Mayor
        IO_ES.escribir("El número mayor es: ");
        IO_ES.escribirFormato("%1.2f", aleatorio[tamaño - 1]);
        IO_ES.escribirLN("");
        //Media
        double suma = 0;
        double media = 0;
        for (int i = 0; i < tamaño; i++) {
            suma += aleatorio[i];
            media = suma / 2;
        }
        IO_ES.escribir("La media de la matriz es: ");
        IO_ES.escribirFormato("%1.2f", media);
        IO_ES.escribirLN("");
    }

    /**
     * Método que nos permite elejir el tamaño de un Array aleatorio para
     * visualizarlo y ver cuantos números son mayores y menores de 50
     */
    public static void elijeArray50() {
        int tamaño;
        int contador1 = 0, contador2 = 0;
        tamaño = IO_ES.leerInteger("Elije el tamaño de un Array: ");
        double[] aleatorio = new double[tamaño];

        //Lo llenamos aleatoriamente con números hasta 100
        for (int i = 0; i < tamaño; i++) {
            aleatorio[i] = Math.random() * 100;
        }
        //Mostramos el array con un bucle for each
        IO_ES.mostrarArrayDecimal(aleatorio);
        //Oredenamos el array de menor a mayor
        IO_ES.ordenarArray(aleatorio, tamaño);
        //Recorremos el array con un bucle de nuevo y mostramos cuantos números son mayores a 50
        for (int i = 0; i < tamaño; i++) {
            if (aleatorio[i] > 50) {
                contador1++;
            }
        }
        IO_ES.escribirLN("Los números mayores a 50 son: " + contador1);
        //Recorremos el array con un bucle de nuevo y mostramos cuantos números son menores a 50
        for (int i = 0; i < tamaño; i++) {
            if (aleatorio[i] < 50) {
                contador2++;
            }
        }
        IO_ES.escribirLN("Los números menores a 50 son: " + contador2);
    }
}
