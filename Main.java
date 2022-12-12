import java.util.Scanner;

public class Main {
    public static void main (String[] arg){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("1 - Peón\n2 - Torre\n3 - Caballo\n4 - Alfil\n5 - Reina\n6 - Rey\nElige una ficha: ");
        String ficha = sc1.nextLine();
        System.out.print("Coordenada de inicio en formato Letra + Número (C3): ");
        String command = sc1.nextLine();

        switch (ficha) {
            case "1":
                //Llamar al método del peón
                break;
            case "2":
                //Llamar al método de la torre
                break;
            case "3":
                System.out.println(Caballo.main(command));
                break;
            case "4":
                //Llamar al método del alfil
                break;
            case "5":
                //Llamar al método de la reina
                break;
            case "6":
                //Llamar al método del rey
                break;
        }
    }
}
