package HundirLaFlota;

import Utilidades.IO_ES;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class HundirFlota {

    public static void opcionesMenu() {
        String[][] tablero = new String[11][11];//Declaracion del array del tablero

        //*** Llenar tablero ***//
        char caracter = (char) 42;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                tablero[i][j] = Character.toString(caracter);//Para poder poner el caracter como String
            }
        }
        //*** Menu tablero ***//
        int letras = 65;
        int num = 49;
        char numeros = (char) 49;
        char letra = (char) 65;
        for (int i = 1; i < 11; i++) {
            tablero[0][i] = Character.toString(numeros);
            num = num + 1;
            numeros = (char) num;
        }
        for (int i = 1; i < 11; i++) {
            tablero[i][0] = Character.toString(letra);
            letras = letras + 1;
            letra = (char) letras;
        }
        tablero[0][10] = "10";
        //*** Ver Tablero ***//
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                IO_ES.escribir(tablero[i][j] + "   ");
            }
            IO_ES.escribirLN("   ");
        }
    }
}
