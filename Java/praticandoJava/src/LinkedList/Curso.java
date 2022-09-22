package LinkedList;

import Lists.Aulas;
import SetList.Aluno;

import java.util.*;

public class Curso {


    private String nome;
    private String instrutor;
    private List<Aulas> aulasList = new LinkedList<>();
    private Set<Aluno> alunos = new HashSet<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }


    public List<Aulas> getAulas() {
        return Collections.unmodifiableList(aulasList);
    }

    public void adiciona(Aulas aulas){
        this.aulasList.add(aulas);
    }
    
    public int getTempoTotal(){

        return aulasList.stream().mapToInt(Aulas::getTempo).sum();

    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public void matricularAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public boolean estaMatriculado(Aluno aluno){
        return this.alunos.contains(aluno);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", instrutor='" + instrutor + '\'' +
                ", aulasList=" + aulasList +
                ", alunosMatriculados=" + alunos +
                '}';
    }
}
