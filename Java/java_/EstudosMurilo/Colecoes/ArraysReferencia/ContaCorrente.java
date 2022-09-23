package java_.EstudosMurilo.Colecoes.ArraysReferencia;

public class ContaCorrente {

    public Integer numero;

    public int agencia;


    public ContaCorrente(Integer numero, int agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                '}';
    }
}
