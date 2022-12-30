import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        //Criando marcador para iniciar a contagem do tempo
        long tempoInicial = System.currentTimeMillis();

        //Definindo o formatador para 2 casas após a vírgula
        DecimalFormat format = new DecimalFormat("0.00");

        TratarCheque cheque = new TratarCheque();

        double valor;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= 100; j++) {
                //efetuando o casto do valor de j para Double, para permitir e armazenar a divisão por 100
                valor = i + (double) j / 100;
                System.out.println("Valor: " + format.format(valor) + ". Extenso: " + cheque.extenso(valor));
            }

        }
        System.out.println("Foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
    }
}