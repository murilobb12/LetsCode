package Listas;

public class Nomes /*implements Comparable<Nomes>*/{

    private String nome;
    private int idade;

    public Nomes(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setTitulo(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return
                "{nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }


}
