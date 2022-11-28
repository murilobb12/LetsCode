package org.example;

import java.security.InvalidParameterException;

public class RomeuJulieta {

    public String romeu_julieta(int valor){

        if (valor <= 0){
            throw new NumberFormatException("Valor menor ou igual a zero");
        }

        System.out.println("Teste");
        String resposta = String.valueOf(valor);


//        try{
//              = Integer.parseInt(resposta);
//        }catch (NumberFormatException ex){
//            System.out.println("Entrada inválida");
//        }

        if ((Integer.parseInt(resposta) % 3 == 0) && !(Integer.parseInt(resposta) % 5 == 0)){
            return "QUEIJO";

        } else if ((Integer.parseInt(resposta) % 5 == 0) && !(Integer.parseInt(resposta) % 3 == 0)) {
            return "GOIABADA";
        } else if ((Integer.parseInt(resposta) % 5 == 0) && (Integer.parseInt(resposta) % 3 == 0)){
            return "ROMEU E JULIETA";
        }
        return resposta;
    }


}
