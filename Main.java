import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        boolean exit;
        String ficha = "";
        Scanner sc1 = new Scanner(System.in);
        do {
            try {
                System.out.print("Piezas del ajedrez ->\n1 - Peón\n2 - Torre\n3 - Caballo\n4 - Alfil\n5 - Reina\n6 - Rey\n\nExtras ->\n7 - Kanye West\n\nElige una ficha: ");
                ficha = sc1.nextLine();
                if (ficha.matches("[1-7]")) {
                    exit = true;
                } else {
                    throw new Exception("Ficha incorrecta");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exit = false;
            }
        } while (!exit);

        String command = "";
        do {
            try {
                System.out.print("\nCoordenada de inicio en formato Letra + Número (C3): ");
                command = sc1.nextLine();
                if (command.matches("[a-hA-H][1-8]")) {
                    exit = true;
                } else {
                    throw new Exception("Coordenada incorrecta");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exit = false;
            }
        } while (!exit);

        switch (ficha) {
            case "1":
                String color;
                do {
                    System.out.print("Color del peón (B/N): ");
                    color = sc1.nextLine();
                    if (color.matches("[BbNn]")) {
                        exit = true;
                    } else {
                        System.out.println("Opción incorrecta");
                        exit = false;
                    }
                } while (!exit);
                if (color.matches("[Bb]")) {
                    pintarMapa(command, PeonB.main(command));
                } else if (color.matches("[Nn]")) {
                    pintarMapa(command, PeonN.main(command));
                }
                break;
            case "2":
                pintarMapa(command, Torre.main(command));
                break;
            case "3":
                pintarMapa(command, Caballo.main(command));
                break;
            case "4":
                pintarMapa(command, Alfil.alfil(command));
                break;
            case "5":
                String[] suma = new String[44];
                for (int i = 0; i < Torre.main(command).length; i++) {
                    suma[i] = Torre.main(command)[i];
                }
                for (int i = 0; i < Alfil.alfil(command).length; i++) {
                    suma[i + 16] = Alfil.alfil(command)[i];
                }
                pintarMapa(command, suma);
                break;
            case "6":
                pintarMapa(command, Rey.main(command));
                break;
            case "7":
                pintarMapa(command, Extras.KanyeWest.main(command));
                break;
        }
    }

    public static void pintarMapa(String inicio, String[] posiciones) {
        String[][] bordes = {
                {" 8 "},
                {" 7 "},
                {" 6 "},
                {" 5 "},
                {" 4 "},
                {" 3 "},
                {" 2 "},
                {" 1 "},
                {"   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H "},
        };

        String[][] tablero = {
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        };

        char letra = Character.toUpperCase(inicio.charAt(0));
        int valorLetra = (letra - '@') - 1;
        int numero = 8 - (inicio.charAt(1) - '0');
        tablero[numero][valorLetra] = "[" + GREEN + "0" + RESET + "]";

        for (String S : posiciones) {
            if (!Objects.equals(S, "X")) {
                char letraP = Character.toUpperCase(S.charAt(0));
                int valorLetraP = (letraP - '@') - 1;
                int numeroP = 8 - (S.charAt(1) - '0');
                tablero[numeroP][valorLetraP] = "[" + YELLOW + "X" + RESET + "]";
            }
        }


        for (int i = 0; i < tablero.length; i++) {
            for (int X = 0; X < bordes[i].length; X++) {
                System.out.print(bordes[i][X]);
            }
            for (int C = 0; C < tablero[i].length; C++) {
                System.out.print(tablero[i][C]);
            }
            System.out.print("\n");
        }
        for (int L = 0; L < bordes[8].length; L++) {
            System.out.print(bordes[8][L]);
        }
    }

    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

}
