public class Torre {
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
        //16 = 8 en la vertical y 8 en la horizontal, en ambas contando la posición de inicio
        String[] result = new String[16];

        //En este bucle se varía el número mientras que la letra se deja estática
        for (int i = 0; i < 8; i++) {
            if (i != numero) {
                result[i] = matriz[i][valorLetra];
            } else {
                result[i] = "X";
            }
        }

        //En ambos bucles se comprueba que la posición escogida no sea la de la propia ficha
        //Si lo es, escribiremos una "X" en dicho resultado para que el main no lo pinte

        //En este bucle se varía la letra mientras que el número se deja estático
        for (int i = 0; i < 8; i++) {
            if (i != valorLetra) {
                result[8 + i] = matriz[numero][i];
            } else {
                result[8 + i] = "X";
            }
        }

        //Ambos bucles buscan desde la posición 0 hasta la 7 de su fila/columna, así nunca se saldrán del tablero

        //Al final devolvemos la ristra de resultados
        return result;
    }
}