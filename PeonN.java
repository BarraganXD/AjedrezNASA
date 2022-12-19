public class PeonN {
    public static String[] main (String arg) {
        //Se separa la letra y el número de la coordenada para operar
        char letra = Character.toUpperCase(arg.charAt(0));
        int valorLetra = (letra - '@') - 1;
        int numero = 8 - (arg.charAt(1) - '0');

        //Se declara la matriz de la que seleccionaremos las posiciones
        String[][] matriz = {
                {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8"},
                {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7"},
                {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6"},
                {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5"},
                {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4"},
                {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"},
                {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2"},
                {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"},
        };

        //Se declara la variable del return con el tamaño de las posiciones máximas
        //2 = las posiciones máximas de un peón en una determinada posición
        String[] result = new String[2];

        if (numero == 0) { //Si está en la fila 8 no puede moverse por que es una posición imposible para un peón negro
            result[0] = "X";
            result[1] = "X";
        } else if (numero == 1) { //Si está en la fila 7 puede bajar 2 casillas, como al empezar una partida
            result[0] = matriz[numero + 1][valorLetra];
            result[1] = matriz[numero + 2][valorLetra];
        } else if (numero == 7) { //Si está en la fila 1 no puede moverse a ninguna parte
            result[0] = "X";
            result[1] = "X";
        } else { //En el resto de casos podrá moverse una casilla hacia abajo
            result[0] = matriz[numero + 1][valorLetra];
            result[1] = "X";
        }

        //Al final devolvemos la ristra de resultados
        return result;
    }
}
