import java.util.HashMap;

public class TratarCheque {

    //Definindo um Map para fazer o De/Para do valor -> por extenso
    HashMap<Integer, String> numeros = new HashMap<>() {
        {
            put(0, "");
            put(1, "um");
            put(2, "dois");
            put(3, "tres");
            put(4, "quatro");
            put(5, "cinco");
            put(6, "seis");
            put(7, "sete");
            put(8, "oito");
            put(9, "nove");
            put(10, "dez");
            put(11, "onze");
            put(12, "doze");
            put(13, "treze");
            put(14, "quatorze");
            put(15, "quinze");
            put(16, "dezesseis");
            put(17, "dezessete");
            put(18, "dezoito");
            put(19, "dezenove");
            put(20, "vinte");
            put(30, "trinta");
            put(40, "quarenta");
            put(50, "cinquenta");
            put(60, "sessenta");
            put(70, "setenta");
            put(80, "oitenta");
            put(90, "noventa");
            put(100, "cento");
            put(200, "duzentos");
            put(300, "trezentos");
            put(400, "quatrocentos");
            put(500, "quinhentos");
            put(600, "seiscentos");
            put(700, "setecentos");
            put(800, "oitocentos");
            put(900, "novecentos");

        }
    };

    //Separar o valor passado até 100
    public String separadorAteCem(double valor) {

        double valorAteCem = valor % 100;

        double parteUni =  (valorAteCem % 10);
        double parteDez = Math.round(valorAteCem - parteUni);



        if (valorAteCem <= 20) {
            return numeros.get((int) valorAteCem);
        } else if (valorAteCem % 10 == 0) {

            return numeros.get((int) valorAteCem);
        } else if (parteDez % 10 == 0 && Math.round(parteUni) == 0) {
            return numeros.get((int) parteDez);
        } else {
            return numeros.get((int) parteDez) + " e " + numeros.get((int) parteUni);


        }

        //Colocar if para tratar parte unidade
    }


    //Separar o valor passado de 100 até 999
    public String separadorCentena(double valor) {
        double parteDezena = valor % 100;
        double parteCentena = valor - parteDezena;

        if (valor >= 100) {

            if (valor == 100) {
                return "cem";
            } else if (valor % 100 == 0) {
                return numeros.get((int) parteCentena);
            }
            return numeros.get((int) parteCentena) + " e ";
        }
        return numeros.get((int) parteCentena);
    }

    //Separar os centavos da parte inteira
    public String separadorCentavos(double valor) {

        int valorInt = (int) valor;

        int centavos = (int) Math.round((valor - valorInt) * 100);

        if (valor != (int) valor) {

            if (centavos == 1) {
                return separadorAteCem(centavos) + " centavo";

            }
            return separadorAteCem(centavos) + " centavos";


        }

        return "";

    }


    //Escrever o número por extenso
    public String extenso(double valor) {
        int valorInt = (int) valor;
        int centavos = (int) Math.round((valor - valorInt) * 100);


        if ((valor < 1)) {
            return separadorCentavos(valor);
        } else if ((int) valor == 1 && centavos == 0) {
            return separadorAteCem(valor) + " real" + separadorCentavos(valor);
        } else if ((int) valor == 1 && centavos >= 1) {
            return separadorAteCem(valor) + " real e " + separadorCentavos(valor);
        } else if (valor != (int) valor) {
            return separadorCentena(valor) + separadorAteCem(valor) + " reais e " + separadorCentavos(valor);
        } else {
            return separadorCentena(valor) + separadorAteCem(valor) + " reais" + separadorCentavos(valor);
        }

    }

}
