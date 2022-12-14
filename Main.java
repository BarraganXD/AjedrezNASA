import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        boolean exit;
        Scanner sc1 = new Scanner(System.in);
        do {
            //Este booleano se utiliza como recurso para salir de los bucles en los que se pide input
            String ficha = "";
            do {
                //Se muestra el menú y se comprueba que el usuario escoja una opción válida
                try {
                    System.out.print("\nPiezas del ajedrez ->\n1 - Peón\n2 - Torre\n3 - Caballo\n4 - Alfil\n5 - Reina\n6 - Rey\n\nElige una ficha: ");
                    ficha = sc1.nextLine();
                    if (ficha.matches("[1-6]")) {
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
            //Se pide la coordenada de inicio y se comprueba que sea válida (A1-H8)
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

            //Según la ficha escogida se llama a un método u otro
            switch (ficha) {
                case "1":
                    //El case del peón es más elaborado por que pregunta el color previamente
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
                        if (command.matches("[a-hA-H]1")) {
                            System.out.println("\nPosición ilegal: Ningun movimiento posible");
                        } else {
                            pintarMapa(command, PeonB.main(command));
                        }
                    } else if (color.matches("[Nn]")) {
                        if (command.matches("[a-hA-H]8")) {
                            System.out.println("\nPosición ilegal: Ningun movimiento posible");
                        } else {
                            pintarMapa(command, PeonN.main(command));
                        }
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
                    //El case de la reina es especial por que no hay un método propio
                    //sino que sumo los resultados de la torre y el alfil
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
            }

            String repeat;
            do {
                System.out.print("\n\nRepetir el programa (S/N): ");
                repeat = sc1.nextLine();
                if (repeat.equals("S")) {
                    exit = false;
                } else if (repeat.equals("N")){
                    exit = true;
                }
            } while (!repeat.matches("[SN]"));
        } while(!exit);
        System.out.println("\n¡Hasta la próxima!");
        //Se cierra el Scanner por educación
        sc1.close();
    }

    public static void pintarMapa(String inicio, String[] posiciones) {
        //El array del borde y del mapa se declaran por separado y luego se juntan
        //De esta manera es más fácil calcular las posiciones del mapa para pintarlas
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

        //Se separa la letra y el número de la coordenada para poder tratarlas luego
        char letra = Character.toUpperCase(inicio.charAt(0));
        int valorLetra = (letra - '@') - 1;
        int numero = 8 - (inicio.charAt(1) - '0');
        tablero[numero][valorLetra] = "[" + GREEN + "0" + RESET + "]";

        //Se recorren todas las posiciones posibles que el método en cuestión haya devuelto
        //por cada posición dada se comprueba si es una "X"
        //si es una "X" se ignora, si es una coordenada se separa la letra del número y se ubica para pintarlo
        for (String S : posiciones) {
            if (!Objects.equals(S, "X")) {
                char letraP = Character.toUpperCase(S.charAt(0));
                int valorLetraP = (letraP - '@') - 1;
                int numeroP = 8 - (S.charAt(1) - '0');
                tablero[numeroP][valorLetraP] = "[" + YELLOW + "X" + RESET + "]";
            }
        }


        //El bucle general va contando fila a fila
        //Por cada iteración se pinta una fila de los bordes seduigo de una fila del tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int X = 0; X < bordes[i].length; X++) {
                System.out.print(bordes[i][X]);
            }
            for (int C = 0; C < tablero[i].length; C++) {
                System.out.print(tablero[i][C]);
            }
            System.out.print("\n");
        }

        //Cuando se termina de pintar el mapa con los números a la derecha, se pintan las letras
        for (int L = 0; L < bordes[8].length; L++) {
            System.out.print(bordes[8][L]);
        }
    }

    //Estos métodos se usan para pintar la ficha y las posiciones de colores
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

}
