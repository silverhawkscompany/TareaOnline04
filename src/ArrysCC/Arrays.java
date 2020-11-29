/**
 *
 */
package ArrysCC;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dgdan
 */
public class Arrays {

    public static void opcionesMenu() {
        Scanner entrada = new Scanner(System.in);
        byte opciones = 0;
        boolean correcto = false;

        do {
            System.out.println("--------------------------MENU DE ARRAYS---------------------------");
            System.out.println("1. Mostrar un Array de 10 con 10 primeros números pares");
            System.out.println("2. Acierte un número de un Array de 10 con números aleatorios");
            System.out.println("3. Elije el tamaño de un Array aleatorio, para ver la media, el mayor y el menor valor");
            System.out.println("4. Elije el tamaño de un Array aleatorio para visualizarlo y ver los número mayores y menores de 50");
            System.out.println("0. Salir");//Solo se debe salir al pulsar 0
            System.out.print("Escribe una opción: ");
            try {
                opciones = entrada.nextByte();
                correcto = true;
            } catch (Exception e) {
                System.out.println("Elije una opción posible");
            }
            entrada.nextLine();

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
                    int numero = 0;
                    int aleatorio[] = new int[10];
                    //Creamos una matriz aleatoriade hasta el numero 20
                    for (int i = 0; i < 10; i++) {
                        aleatorio[i] = (int) Math.round(Math.random() * 20);
                    }
                    //Repetimos que recorra el arrays hasta que encontremos un numero acertado
                    do {
                        System.out.print("Elije un número: ");
                        //capturamos exception
                        try {
                            numero = entrada.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Escribe un número entero");
                        }
                        entrada.nextLine();//limpiamos buffer
                        for (int i = 0; i < 10; i++) {
                            if (aleatorio[i] == numero) {
                                System.out.println("Has acertado!!");
                                //Aqui falla si le incorporo el numero que hemos puesto
                                System.out.println("El número se encuentra en la posición: " + i);
                                encontrado = true;
                            }
                        }
                    } while (encontrado == false);//Cuidado he fallado puse "=" y no "=="
                    break;
                case 3:
                    correcto = false;

                    int tamaño = 0;

                    do {
                        try {
                            System.out.print("Elije el tamaño de un Array: ");
                            tamaño = entrada.nextInt();
                            correcto = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Solo puedes indicar un número entero");
                        }
                        entrada.nextLine();
                    } while (correcto == false);
                    double[] aleatorio2 = new double[tamaño];
                    for (int i = 0; i < tamaño; i++) {
                        aleatorio2[i] = Math.random() * 100;
                    }
                    //Mostramos el array
                    for (double i : aleatorio2) {
                        System.out.println(i);
                    }
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
                    System.out.println("El número menor es: " + aleatorio2[0]);
                    //Mayor
                    System.out.println("El número mayor es: " + aleatorio2[tamaño - 1]);
                    //Media
                    double suma = 0;
                    double media = 0;
                    for (int i = 0; i < tamaño; i++) {
                        suma += aleatorio2[i];
                        media = suma / 2;
                    }
                    System.out.println("La media de la matriz es: " + media);
                    //Lo volvemos a poner en false para que no nos saque del menu de array
                    correcto = false;
                    break;
                case 4:
                    correcto = false;

                    int tamaño2 = 0;

                    do {
                        try {
                            System.out.print("Elije el tamaño de un Array: ");
                            tamaño2 = entrada.nextInt();
                            correcto = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Solo puedes indicar un número entero");
                        }
                        entrada.nextLine();
                    } while (correcto == false);

                    double[] aleatorio3 = new double[tamaño2];
                    for (int i = 0; i < tamaño2; i++) {
                        aleatorio3[i] = Math.random() * 100;
                    }
                    //Mostramos el array con un bucle for each
                    for (double i : aleatorio3) {
                        System.out.println(i);
                    }
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
                    System.out.println("Los números mayoes a 50 son:");
                    //Recorremos el array con un bucle de nuevo y mostramos que valores de la matriz son mayores a 50
                    for (int i = 0; i < tamaño2; i++) {
                        if (aleatorio3[i] > 50) {
                            System.out.println(aleatorio3[i]);
                        }
                    }
                    correcto = false;
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }
}
