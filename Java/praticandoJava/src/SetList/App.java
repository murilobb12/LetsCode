package SetList;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class App{

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();

        alunos.add("Murilo");
        alunos.add("Patrícia");
        alunos.add("Patrícia");
        alunos.add("Paulo");
        alunos.add("João");

        alunos.stream().map(s -> Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")).forEach(System.out::println);


        boolean temString = alunos.contains("Teste");
        System.out.println(temString);
        boolean adicionou = alunos.add("Teste");

        System.out.println(adicionou);


        for (String a:alunos
             ) {
            System.out.println(alunos.size());
            System.out.println(a);
        }




    }


}
