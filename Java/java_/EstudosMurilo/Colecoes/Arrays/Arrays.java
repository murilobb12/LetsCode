package java_.EstudosMurilo.Colecoes.Arrays;

import java.util.stream.Stream;
import java.util.Arrays.*;

import static java.util.Arrays.stream;

public class Arrays {

    public static void main(String[] args) {


        int[] idades = new int[5];

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i*3;
        }


        stream(idades).forEach(System.out::println);

    }

}
