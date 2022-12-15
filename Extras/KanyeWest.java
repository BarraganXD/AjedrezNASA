package Extras;

public class KanyeWest {
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

        String[] result = new String[14];

        int cont = 0;
        for (int i = -2; i < 3; i++) {
            if (i != 0) {
                try {
                    result[cont] = matriz[numero + i][valorLetra];
                    cont++;
                } catch (IndexOutOfBoundsException e) {
                    result[cont] = "X";
                    cont++;
                }

                if (Math.abs(i) == 2) {
                    try {
                        result[cont] = matriz[numero + i][valorLetra - (i - (i / 2))];
                        //Esto hace que si i es -2 coja la letra -1 y si es 2 coge la letra 1
                        cont++;
                    } catch (IndexOutOfBoundsException e) {
                        result[cont] = "X";
                        cont++;
                    }

                }
            } else {
                result[cont] = "X";
                cont++;
            }
        }

        for (int i = -2; i < 3; i++) {
            if (i != 0) {
                try {
                    result[cont] = matriz[numero][valorLetra + i];
                    cont++;
                } catch (IndexOutOfBoundsException e) {
                    result[cont] = "X";
                    cont++;
                }

                if (Math.abs(i) == 2) {
                    try {
                        result[cont] = matriz[numero + (i - (i / 2))][valorLetra + i];
                        //Esto hace que si i es -2 coja el numero -1 y si es 2 coge el numero 1
                        cont++;
                    } catch (IndexOutOfBoundsException e) {
                        result[cont] = "X";
                        cont++;
                    }
                }
            } else {
                result[cont] = "X";
                cont++;
            }
        }
        return result;
    }
}
