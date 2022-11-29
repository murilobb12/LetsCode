import java.math.BigDecimal;

public class Conta implements Lancamento{

    private String codigoConta;

    private Cliente cliente;

    private BigDecimal saldo = BigDecimal.ZERO;

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "codigoConta='" + codigoConta + '\'' +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }

    @Override
    public void iniciarConta() {
        this.saldo = (new BigDecimal("200.00"));
    }

    @Override
    public void sacar(BigDecimal valor){
        this.saldo = this.saldo.subtract(valor);

    }

    @Override
    public void depositar(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
    }
}