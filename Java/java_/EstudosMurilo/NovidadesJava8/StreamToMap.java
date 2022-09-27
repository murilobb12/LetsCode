package java_.EstudosMurilo.NovidadesJava8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamToMap {

    public static void main(String[] args) {


        List<Curso> cursos = Arrays.asList(new Curso("Java", 100), new Curso("Python", 50), new Curso("SQL", 20));


        cursos.stream().filter(curso -> curso.getAlunos() > 20).collect(Collectors.toMap(curso -> curso.getNome(), o -> o.getAlunos())).forEach((s, alunos) -> System.out.println(s + " tem " + alunos));
        Map<String, Integer> teste = cursos.stream().filter(curso -> curso.getAlunos() > 20).collect(Collectors.toMap(curso -> curso.getNome(), o -> o.getAlunos()));



    }

}
