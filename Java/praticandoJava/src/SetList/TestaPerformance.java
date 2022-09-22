package SetList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {

        Collection<Integer> numerosList = new ArrayList<>();

        Collection<Integer> numerosSet = new HashSet<>();

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++){
            numerosList.add(i);
            numerosSet.add(i);
        }

//        for (Integer n:numerosList
//             ) {
//            numerosList.contains(n);
//        }

        for (Integer n:numerosSet
             ) {
            numerosSet.contains(n);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto: " + tempoDeExecucao);

    }

}
