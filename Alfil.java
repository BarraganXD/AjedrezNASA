public class Alfil {
    public static String[] alfil(String coordenada) {
        String[][] tablero = {//Se declara un array con las posiciones del tablero
                {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8"},
                {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7"},
                {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6"},
                {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5"},
                {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4"},
                {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"},
                {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2"},
                {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"}
        };
        char letra = Character.toUpperCase(coordenada.charAt(0));//Se coge la letra de la coordenada y se pone en mayúscula
        int columna = (letra - '@') - 1;//la letra, en el código ASCII, se le resta la @ en código ASCII, para que las letras vayan de 0 a 7
        int fila = 8 - (coordenada.charAt(1) - '0');//Se coge el número de la coordenada en ASCII y se le resta el 0 en ASCII para que los números vayan 0 a 7
        String[] result = new String[28];// el afil puede ir en una dirección y como máximo tiene 7 posiciones. Al haber 4 posiciones hay como máximo 28 posiciones posibles

        int cont = 0;
        for (int i = 1; i < 8; i++) {// i equivale al eje vertical del tablero, valores de 1 a 7, siendo el 0,0 la pieza
            for (int e = i; e >= (i * -1); e -= (2 * i)) {//e equivale al eje horizontal, valores de 1 a 7 y de -1 a -7
                try {
                    result[cont] = tablero[fila - i][columna + e];//resta i para disminuir filas en el array, aumentar filas en el tablero
                    cont++;
                } catch (IndexOutOfBoundsException er) {
                    result[cont] = "X";
                    cont++;
                }
                try {
                    result[cont] = tablero[fila + i][columna + e];//suma i para aumentar filas en el array, disminuir filas en el tablero
                    cont++;
                } catch (IndexOutOfBoundsException er) {
                    result[cont] = "X";
                    cont++;
                }
            }
        }
        return result;
    }
}
