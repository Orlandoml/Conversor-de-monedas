import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        double amount = 0;
        Consulta consulta = new Consulta();
        Historial historial = new Historial();
        double resultado = 0;
        String currency = "";
        String base = "";

        while (true) {

            try {
                System.out.print("""
                        ---------------------------------------
                        Bienvenido/a al conversor de monedas
    
                        1)dólar -> peso argentino
                        2)peso argentino -> dólar
                        3)dólar -> real brasileño
                        4)real brasileño -> dólar
                        5)dólar -> peso colombiano
                        6)peso colambiano -> dólar
                        7)dólar -> peso mexicano
                        8)peso mexicano -> dólar

                        9)Salir
                        ---------------------------------------
                        Digite una opcion:""");  
                opcion = input.nextInt();
                
                if (opcion == 9){
                    System.out.println("Gracias por usar nuestro programa:D");
                    break;
                }
                if (opcion<1 || opcion>9){
                    System.out.println("Opcion invalida");
                    continue;
                }
    
                System.out.print("Digite cantidad: ");
                amount = input.nextDouble();
                
                switch (opcion) {
                    case 1:
                        base = "USD";
                        currency = "ARS";
                        break;
                    case 2:
                        base = "ARS";
                        currency = "USD";
                        break;
                    case 3:
                        base = "USD";
                        currency = "BRL";
                        break;
                    case 4:
                        base = "BRL";
                        currency = "USD";
                        break;
                    case 5:
                        base = "USD";
                        currency = "COP";
                        break;
                    case 6:
                        base = "COP";
                        currency = "USD";
                        break;
                    case 7:
                        base = "USD";
                        currency = "MXN";
                        break;
                    case 8:
                        base = "MXN";
                        currency = "USD";
                        break;
                }

                resultado = consulta.conversor(amount, base, currency);
                String message = String.format("$%.2f %s es equivalente a $%.2f %s", amount, base, resultado, currency);

                System.out.println(message);
                historial.saveHistory(message);

            } catch (InputMismatchException e) {
                System.out.println("No es numero entero");
                input.nextLine();
                continue;
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        input.close();
    }
}
