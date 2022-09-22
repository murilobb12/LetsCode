package SetList;

import LinkedList.Curso;
import Lists.Aulas;

import java.util.Set;

public class AppAluno {

    public static void main(String[] args) {


        Curso javaColletions = new Curso("Curso Git", "Murilo");

        Aluno murilo = new Aluno("Murilo", 1242602);
        Aluno marcela = new Aluno("Marcela", 041202);

        Aulas aula1 = new Aulas("Versionamento", 200);
        Aulas aula2 = new Aulas("Git restore", 50);

        javaColletions.adiciona(aula1);
        javaColletions.adiciona(aula2);

        javaColletions.matricularAluno(murilo);
        javaColletions.matricularAluno(marcela);

        Set<Aluno> alunos = javaColletions.getAlunos();

        alunos.add(new Aluno("Teste", 123));


        System.out.println(javaColletions);


    }


}
