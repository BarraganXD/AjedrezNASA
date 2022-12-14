public class Caballo {
    public static String[] main(String arg) {
        char letra = Character.toUpperCase(arg.charAt(0));
        int valorLetra = (letra - '@') - 1;
        int numero = 8 - (arg.charAt(1) - '0');

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

        String[] result = new String[8];

        int cont = 0;
        for (int i = -2; i < 3; i++) {
            if (i != 0) {
                if (i % 2 == 0) {
                    for (int o = -1; o < 2; o += 2) {
                        try {
                            result[cont] = matriz[numero + i][valorLetra + o];
                            cont++;
                        } catch (IndexOutOfBoundsException e) {
                            result[cont] = "X";
                            cont++;
                        }
                    }
                } else {
                    for (int o = -2; o < 3; o += 4) {
                        try {
                            result[cont] = matriz[numero + i][valorLetra + o];
                            cont++;
                        } catch (IndexOutOfBoundsException e){
                            result[cont] = "X";
                            cont++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
