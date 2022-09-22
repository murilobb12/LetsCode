package LinkedList;

import Lists.Aulas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App2 {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Curso Spring", "Julia");


        javaColecoes.adiciona(new Aulas("Usando JPA", 3));
        javaColecoes.adiciona(new Aulas("Usando Named Methods", 3));
        javaColecoes.adiciona(new Aulas("Usando JPQL", 3));

        List<Aulas> aulasImutaveis = javaColecoes.getAulas();
        List<Aulas> aulasMutaveis = new ArrayList<>(aulasImutaveis);


        System.out.println(javaColecoes.getTempoTotal());

        //Não é possível alterar a lista aulasImutaveis pois ela é imutável
        //Collections.sort(aulasImutaveis);
        Collections.sort(aulasMutaveis);


        System.out.println(aulasMutaveis);
         System.out.println(aulasImutaveis);


    }



}
