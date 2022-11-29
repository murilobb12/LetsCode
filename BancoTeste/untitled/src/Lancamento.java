import java.math.BigDecimal;

public interface Lancamento {

    void iniciarConta();

    void sacar(BigDecimal valor);

    void depositar(BigDecimal valor);

}
