import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        double amount = 0;
        Consulta consulta = new Consulta();
        double resultado = 0;
        String currency = "";
        String base = "";
        while (true) {

            System.out.print("""
                    ---------------------------------------
                    Bienvenido/a al conversor de monedas

                    1)peso mexicano -> dolar
                    2)dolar -> peso mexicano
                    3)peso argentino -> real
                    4)real -> peso argentino
                    5)real -> dolar
                    6)dolar -> real

                    7)Salir
                    ---------------------------------------
                    Digite una opcion:""");  
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

            switch (opcion) {
                case 1:
                    currency = "USD";
                    base = "MXN";
                    break;
                case 2:
                    currency = "MXN";
                    base = "USD";
                    break;
                case 3:
                    currency = "BRL";
                    base = "ARS";
                    break;
                case 4:
                    currency = "ARS";
                    base = "BRL";
                    break;
                case 5:
                    currency = "USD";
                    base = "BRL";
                    break;
                case 6:
                    currency = "BRL";
                    base = "USD";
                    break;
                default:
                    // por definir
                    break;
            }
            
            resultado = consulta.conversor(amount, base, currency);
            System.out.printf("Equivalente a $%.2f %s %n", resultado, currency);
        }
        input.close();
    }
}
