package java_.EstudosMurilo.Colecoes.Contas;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente {

    public Integer numero;

    public int agencia;

    public BigDecimal saldo = BigDecimal.ZERO;


    public BigDecimal sacar(BigDecimal valorSaque){
        return this.saldo.subtract(valorSaque);
    }

    public void depositar(BigDecimal valorDeposito){
        this.saldo = this.saldo.add(valorDeposito);
    }


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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return agencia == that.agencia && Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia);
    }
}
