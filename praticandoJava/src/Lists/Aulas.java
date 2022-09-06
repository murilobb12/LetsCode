package Lists;

public class Aulas implements Comparable<Aulas>{

    private String aulas;
    private int tempo;

    public Aulas(String aulas, int tempo) {
        this.aulas = aulas;
        this.tempo = tempo;
    }


    public String getAulas() {
        return aulas;
    }

    public void setTitulo(String nome) {
        this.aulas = nome;
    }

    public int getTempo() {
        return tempo;
    }

    public void setIdade(int tempo) {
        this.tempo = Aulas.this.tempo;
    }

    @Override
    public String toString() {
        return
                "{aula='" + aulas + '\'' +
                ", tempo=" + tempo +
                '}';
    }


    @Override
    public int compareTo(Aulas o) {
        return this.aulas.compareTo(o.aulas);
    }
}
