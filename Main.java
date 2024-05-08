import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        double amount = 0;
        Consulta consulta = new Consulta();
        double resultado = 0;

        while (true) {

            System.out.println("---------------------------------------");
            System.out.print("""
                    Bienvenido/a al conversor de monedas

                    1)peso mexicano -> dolar
                    2)dolar -> peso mexicano
                    3)peso argentino -> real
                    4)real -> peso argentino
                    5)real -> dolar
                    6)dolar -> real

                    7)Salir
                    """);   
            System.out.println("---------------------------------------");
            System.out.print("Digite una opcion: ");

            opcion = input.nextInt();

            if (opcion == 7){
                System.out.println("Gracias por usar nuestro programa:D");
                break;
            }
            if (opcion<1 || opcion>7){
                System.out.println("Opcion invalida");
                continue;
            }

            System.out.print("Digite cantidad: ");
            amount = input.nextDouble();

            if (opcion == 1) {
                resultado = consulta.conversor(amount, "MXN", "USD");
                System.out.printf("Equivalente a $%.2f Dolares %n", resultado);
            }else if (opcion == 2){
                resultado = consulta.conversor(amount, "USD", "MXN");
                System.out.printf("Equivalente a $%.2f Pesos mexicanos %n", resultado);
            }else if (opcion == 3){
                resultado = consulta.conversor(amount, "ARS", "BRL");
                System.out.printf("Equivalente a $%.2f Reales brasileños %n", resultado);
            }else if (opcion == 4){
                resultado = consulta.conversor(amount, "BRL", "ARS");
                System.out.printf("Equivalente a $%.2f Pesos Argentinos %n", resultado);
            }else if (opcion == 5){
                resultado = consulta.conversor(amount, "BRL", "USD");
                System.out.printf("Equivalente a $%.2f Dolares %n", resultado);
            }else if (opcion == 6){
                resultado = consulta.conversor(amount, "USD", "BRL");
                System.out.printf("Equivalente a $%.2f Reales Brasileños %n", resultado);
            }
        }
    }
}
