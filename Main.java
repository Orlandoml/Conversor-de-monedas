import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Consulta consulta = new Consulta();
        Historial historial = new Historial();
        Map<Integer, String> rates = new HashMap<>(){{
            put(1, "USD");
            put(2, "ARS");
            put(3, "BRL");
            put(4, "COP");
            put(5, "MXN");
        }};
        double amount = 0;
        double result = 0;
        int currency_option = 0;
        int base_option = 0;
        String base = "";
        String currency = "";
        String menu = """
            ---------------------------------------
            1)dólar
            2)peso argentino
            3)real brasileño
            4)peso colombiano
            5)peso mexicano

            6)Salir
            ---------------------------------------
            Digite una opcion:""";

        System.out.println("Bienvenido/a al conversor de monedas");
        while (true) {

            try {
                System.out.print("Elija su moneda de origen \n" + menu);  
                base_option = input.nextInt();
                
                if (isExit(base_option)){
                    break;
                }
                if (!isCorrect(base_option)){
                    continue;
                }
                
                System.out.print("Elija su moneda a convertir \n" + menu);
                currency_option = input.nextInt();

                if (isExit(currency_option)){
                    break;
                }
                if (!isCorrect(currency_option)){
                    continue;
                }

                System.out.print("Digite cantidad: ");
                amount = input.nextDouble();

                base = rates.get(base_option);
                currency = rates.get(currency_option);
                result = consulta.conversor(amount, base, currency);
                String message = String.format("$%.2f %s es equivalente a $%.2f %s", amount, base, result, currency);

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

    public static boolean isExit(int opcion){
        if (opcion == 6){
            System.out.println("Gracias por usar nuestro programa:D");
            return true;
        }
        return false;
    }

    public static boolean isCorrect(int opcion){
        if (opcion<1 || opcion>6){
            System.out.println("Opcion invalida");
            return false;
        }
        return true;
    }
}
