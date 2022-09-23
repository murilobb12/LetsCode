package java_.EstudosMurilo.Colecoes.OrdenandoListaas;

import java_.EstudosMurilo.Colecoes.Contas.ContaCorrente;

import java.math.BigDecimal;

public class OrdenandoListas {

    public static void main(String[] args) {

        ContaCorrente cc1 = new ContaCorrente(2521,234131);
        cc1.depositar(new BigDecimal("500.00"));
        ContaCorrente cc2 = new ContaCorrente(1522,234132);
        cc2.depositar(new BigDecimal("700.00"));
        ContaCorrente cc3 = new ContaCorrente(1523,434133);
        cc3.depositar(new BigDecimal("200.00"));
        ContaCorrente cc4 = new ContaCorrente(1524,234134);
        cc4.depositar(new BigDecimal("1000.00"));

        System.out.println(cc1.getSaldo());
        System.out.println(cc2.getSaldo());
        System.out.println(cc3.getSaldo());
        System.out.println(cc4.getSaldo());



    }

}
