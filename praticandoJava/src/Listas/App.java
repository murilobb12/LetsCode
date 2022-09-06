package Listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Nomes a1 = new Nomes("Murilo", 27);
        Nomes a2 = new Nomes("Marcela", 24);
        Nomes a3 = new Nomes("Anaryel", 17);
        Nomes a5 = new Nomes("Anaryel", 99);
        Nomes a6 = new Nomes("Anaryel", 5);
        Nomes a4 = new Nomes("Rosana", 56);

        ArrayList<Nomes> nomesArrayList = new ArrayList<>();

        nomesArrayList.add(a1);
        nomesArrayList.add(a2);
        nomesArrayList.add(a3);
        nomesArrayList.add(a4);
        nomesArrayList.add(a5);
        nomesArrayList.add(a6);
        nomesArrayList.add(new Nomes("Gilson", 59));

        //Collections.sort(nomesArrayList);
        Collections.sort(nomesArrayList, Comparator.comparing(Nomes::getNome).thenComparing(Nomes::getIdade));




        Stream.of(nomesArrayList).forEach(System.out::println);





    }


}
