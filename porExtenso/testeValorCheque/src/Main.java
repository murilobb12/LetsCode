import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TratarCheque cheque = new TratarCheque();

        System.out.println("Digite o valor do cheque: ");
        double valor = sc.nextDouble();

        System.out.println(cheque.extenso(valor));




    }
}