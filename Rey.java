public class Rey {
    public static String[] main(String arg) {
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
        String[] result = new String[9];

        //El contador se inicializa a 0 y cada vez que se escribe en la variable se aumenta en 1
        int cont = 0;

        //Un bucle anidado que recorre desde -1,-1 hasta 1,1
        for (int i = -1; i < 2; i++) {
            for (int e = -1; e < 2; e++) {
                try {
                    //Si la posición es 0,0 significa que es donde se sitúa el Rey
                    //en los casos en los que no hay que pintar devolvemos una "X" para que el main lo interprete
                    if (i == 0 && e == 0) {
                        result[cont] = "X";
                        cont++;
                    } else {
                        result[cont] = matriz[numero + i][valorLetra + e];
                        cont++;
                    }
                } catch (IndexOutOfBoundsException p){
                    result[cont] = "X";
                    cont++;
                }
                //Siempre que no sea 0,0 o que la posición se salga del tablero, pintaremos la posición
            }
        }

        //Al final devolvemos la ristra de resultados, que la forman las posiciones y las "X".
        return result;
    }
}