import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {


        Cliente c = new Cliente();

        c.setCpf("38230414874");
        c.setNome("Murilo");

        Conta cC = new Conta();

        System.out.println("Conta criada");
        cC.setCodigoConta("1212");
        cC.setCliente(c);
        System.out.println(cC);

        System.out.println("Conta iniciada");
        cC.iniciarConta();
        System.out.println(cC);


        System.out.println("Sacado o valor.");
        cC.sacar(new BigDecimal("50"));
        System.out.println("Depositando o valor");
        cC.depositar(new BigDecimal("5"));
        System.out.println(cC);


    }
}