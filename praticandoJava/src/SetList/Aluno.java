package SetList;

import java.util.Objects;

public class Aluno {

    private String nome;
    private int numeroMatricula;


    public Aluno(String nome, int numeroMatricula) {
        if (nome.isEmpty()){
            throw new NullPointerException("O nome do aluno não deve ser nulo!");
        }

        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", numeroMatricula=" + numeroMatricula +
                '}';
    }
}
