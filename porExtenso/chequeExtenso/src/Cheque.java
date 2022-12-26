import java.util.HashMap;

public class Cheque {

    private Double valor;
    private HashMap<Integer, String> palavras = new HashMap<>() {
        {
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
            put(600, "seicentos");
            put(700, "setecentos");
            put(800, "oitocentos");
            put(900, "novecentos");
        }
    };

    public Cheque(Integer valor) {
        this.valor = valor.doubleValue();
    }

    private String dezena(Integer valor) {
        return dezena((valor.doubleValue()));
    }

    private String dezena(Double valor) {
        if ((valor <= 20) || (valor % 10 == 0)) {
            return palavras.get(valor.intValue());
        }

        Double parteUni = valor % 10;
        double parteDez = valor - parteUni;

        String dezena = palavras.get((int) parteDez);
        String unidade = palavras.get(parteUni.intValue());

        return dezena + " e " + unidade;


    }

    private String centena(Double valor) {
        Double parteDez = valor % 100;
        Double parteCen = valor - parteDez;

        if (valor == 100 && parteDez == 0){
            return "cem";
        }




    }

}
