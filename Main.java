import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {

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

            if (opcion == 1) {
                
            }else if (opcion == 2){

            }else if (opcion == 3){
                
            }else if (opcion == 4){
                
            }else if (opcion == 5){
                
            }else if (opcion == 6){
                
            }else if (opcion == 7){
                
            }else {
                
            }
        }
    }
}
