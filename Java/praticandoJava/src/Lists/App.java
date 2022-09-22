package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Aulas a1 = new Aulas("Murilo", 27);
        Aulas a2 = new Aulas("Marcela", 24);
        Aulas a3 = new Aulas("Anaryel", 17);
        Aulas a5 = new Aulas("Anaryel", 99);
        Aulas a6 = new Aulas("Anaryel", 5);
        Aulas a4 = new Aulas("Rosana", 56);

        ArrayList<Aulas> aulasArrayList = new ArrayList<>();

        aulasArrayList.add(a1);
        aulasArrayList.add(a2);
        aulasArrayList.add(a3);
        aulasArrayList.add(a4);
        aulasArrayList.add(a5);
        aulasArrayList.add(a6);
        aulasArrayList.add(new Aulas("Gilson", 59));

        //Collections.sort(nomesArrayList);
        Collections.sort(aulasArrayList, Comparator.comparing(Aulas::getAulas).thenComparing(Aulas::getTempo));




        Stream.of(aulasArrayList).forEach(System.out::println);





    }


}
