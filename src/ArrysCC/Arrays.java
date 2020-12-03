/**
 *
 */
package ArrysCC;

import Utilidades.IO_ES;
import java.util.Scanner;

/**
 *
 * @author dgdan
 */
public class Arrays {

    public static void opcionesMenu() {
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String cyan = "\033[36m";
        String reset = "\u001B[0m";

        Scanner entrada = new Scanner(System.in);
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(azul + "-------------------------------MENU DE ARRAYS--------------------------------" + azul);
            IO_ES.escribirLN("1. Mostrar un Array de 10 con 10 primeros números pares");
            IO_ES.escribirLN("2. Acierte un número de un Array de 10 con números aleatorios");
            IO_ES.escribirLN("3. Elije el tamaño de un Array aleatorio, para ver la media, el mayor y el menor valor");
            IO_ES.escribirLN("4. Elije el tamaño de un Array aleatorio para visualizarlo y ver los número mayores y menores de 50");
            IO_ES.escribirLN("0. Atrás");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones < 5 && opciones > -1) {
                correcto = true;
            } else {
                IO_ES.escribirLN(rojo + "Escribe una opción posible" + reset);
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    int pares[] = new int[10];//Declaración de la matriz
                    for (int i = 0; i < 10; i++) {//Cuidado i siempre es menor al tamaño de la matriz
                        pares[i] = 2 * i;
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Valor del indice: " + i + " = " + pares[i]);
                    }

                    break;
                case 2:
                    correcto = false;
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
                                System.out.println(verde + "Has acertado!!" + reset);
                                //Aqui falla si le incorporo el numero que hemos puesto
                                System.out.println("El número se encuentra en la posición: " + i);
                                //Mostramos el array para que veas la posicion del número acertado
                                for (int j = 0; j < 10; j++) {
                                    System.out.print(aleatorio[j] + " ");
                                }
                                encontrado = true;
                            }
                        }
                    } while (encontrado == false);//Cuidado he fallado puse "=" y no "=="
                    IO_ES.escribirLN("");
                    break;
                case 3:
                    correcto = false;

                    int tamaño;
                    tamaño = IO_ES.leerInteger("Elije el tamaño de un Array: ");

                    double[] aleatorio2 = new double[tamaño];
                    for (int i = 0; i < tamaño; i++) {
                        aleatorio2[i] = Math.random() * 100;
                    }
                    //Mostramos el array
                    for (double i : aleatorio2) {
                        System.out.printf("%1.2f", i);
                        IO_ES.escribir("  ");
                    }
                    IO_ES.escribirLN("");
                    //Oredenamos el array de menor a mayor
                    for (int i = 0; i < tamaño - 1; i++) {
                        for (int j = 1; j < (tamaño - i); j++) {
                            if (aleatorio2[j - 1] > aleatorio2[j]) {   // si el elemento anterior es mayor, hacemos el cambio
                                double aux_elem = aleatorio2[j];
                                aleatorio2[j] = aleatorio2[j - 1];
                                aleatorio2[j - 1] = aux_elem;
                            }
                        }
                    }
                    //Menor
                    IO_ES.escribir("El número menor es: ");
                    System.out.printf("%1.2f", aleatorio2[0]);
                    IO_ES.escribirLN("");
                    //Mayor
                    IO_ES.escribir("El número mayor es: ");
                    System.out.printf("%1.2f", aleatorio2[tamaño - 1]);
                    IO_ES.escribirLN("");
                    //Media
                    double suma = 0;
                    double media = 0;
                    for (int i = 0; i < tamaño; i++) {
                        suma += aleatorio2[i];
                        media = suma / 2;
                    }
                    IO_ES.escribir("La media de la matriz es: ");
                    System.out.printf("%1.2f", media);
                    IO_ES.escribirLN("");
                    break;
                case 4:
                    correcto = false;

                    int tamaño2;

                    tamaño2 = IO_ES.leerInteger("Elije el tamaño de un Array: ");

                    double[] aleatorio3 = new double[tamaño2];
                    //Lo llenamos aleatoriamente
                    for (int i = 0; i < tamaño2; i++) {
                        aleatorio3[i] = Math.random() * 100;
                    }
                    //Mostramos el array con un bucle for each
                    for (double i : aleatorio3) {
                        System.out.printf("%1.2f", i);
                        IO_ES.escribir("  ");
                    }
                    IO_ES.escribirLN("");
                    //Oredenamos el array de menor a mayor
                    for (int i = 0; i < tamaño2 - 1; i++) {
                        for (int j = 1; j < (tamaño2 - i); j++) {
                            if (aleatorio3[j - 1] > aleatorio3[j]) {   // si el elemento anterior es mayor, hacemos el cambio
                                double aux_elem = aleatorio3[j];
                                aleatorio3[j] = aleatorio3[j - 1];
                                aleatorio3[j - 1] = aux_elem;
                            }
                        }
                    }
                    IO_ES.escribirLN("Los números mayores a 50 son:");
                    //Recorremos el array con un bucle de nuevo y mostramos que valores de la matriz son mayores a 50
                    for (int i = 0; i < tamaño2; i++) {
                        if (aleatorio3[i] > 50) {
                            System.out.printf("%1.2f", aleatorio3[i]);
                            IO_ES.escribirLN("");
                        }
                    }
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }
}
