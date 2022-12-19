public class Caballo {
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
        //8 = 8 posibles posiciones SIN contarse a sí mismo
        String[] result = new String[8];

        //El contador se inicializa a 0 y cada vez que se escribe en la variable se aumenta en 1
        int cont = 0;

        //El bucle general cuenta desde arriba del caballo hasta abajo
        //Si varía en 2, significa que debe variar en 1 hacia los lados
        //Si varía en 1, significa que debe variar en 2 hacia los lados
        for (int i = -2; i < 3; i++) {
            if (i != 0) { //Evitamos que calcule posiciones sobre su propia fila
                if (i % 2 == 0) { //Si está en una fila par se moverá en 1 para la horizontal
                    for (int o = -1; o < 2; o += 2) {
                        try {
                            result[cont] = matriz[numero + i][valorLetra + o];
                            cont++;
                        } catch (IndexOutOfBoundsException e) { //Si se sale del tablero pinta una "X"
                            result[cont] = "X";
                            cont++;
                        }
                    }
                } else { //Si está en una fila impar se moverá en 2 para la horizontal
                    for (int o = -2; o < 3; o += 4) {
                        try {
                            result[cont] = matriz[numero + i][valorLetra + o];
                            cont++;
                        } catch (IndexOutOfBoundsException e){ //Si se sale del tablero pinta una "X"
                            result[cont] = "X";
                            cont++;
                        }
                    }
                }
            }
        }

        //Al final devolvemos la ristra de resultados
        return result;
    }
}
