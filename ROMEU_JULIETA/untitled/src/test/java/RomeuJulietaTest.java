import org.example.Main;
import org.example.RomeuJulieta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomeuJulietaTest {

    @Test
    public void passando3RetornaQueijo() {
        RomeuJulieta romeuJulieta = new RomeuJulieta();
        String resposta = romeuJulieta.romeu_julieta(3);

        Assertions.assertEquals("QUEIJO", resposta);

    }

    @Test
    public void passando5RetornaGoiabada() {
        RomeuJulieta romeuJulieta = new RomeuJulieta();
        String resposta = romeuJulieta.romeu_julieta(5);

        Assertions.assertEquals("GOIABADA", resposta);

    }


    @Test
    public void passandoValorDiferenteDeInteiroErro() {

        Assertions.assertThrows(NumberFormatException.class, () -> {
            RomeuJulieta romeuJulieta = new RomeuJulieta();
            romeuJulieta.romeu_julieta(Integer.parseInt("Teste"));
        });


    }

    @Test
    public void passandoValorNegativoErro() {
        Assertions.assertThrows(Exception.class, () -> {
            RomeuJulieta romeuJulieta = new RomeuJulieta();
            romeuJulieta.romeu_julieta(-12);
        });

    }

}
