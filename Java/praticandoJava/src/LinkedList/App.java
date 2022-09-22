package LinkedList;

import Lists.Aulas;

public class App {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Curso Java", "Paulo Siqueira");

        javaColecoes.adiciona(new Aulas("Murilo", 28));;

        System.out.println(javaColecoes);





    }
}
