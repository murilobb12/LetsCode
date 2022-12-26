import org.junit.Assert;
import org.junit.Test;

public class TratarChequeTest {

//TESTES =   [
//            # (0.01,  "um centavo"),
//            # (0.05,  "cinco centavos"),
//            # (0.50,  "cinquenta centavos"),
//            # (1.00,  "um real"),
//            # (1.01,  "um real e um centavo"),
//            # (1.05,  "um real e cinco centavos"),
//            # (1.99,  "um real e noventa e nove centavos"),
//            # (5.00,  "cinco reais"),
//            # (10.00, "dez reais"),
//            # (15.00, "quinze reais"),
//            # (19.00, "dezenove reais"),
//            # (20.00, "vinte reais"),
//            # (21.00, "vinte e um reais"),
//            # (85.00, "oitenta e cinco reais"),
//            # (99.00, "noventa e nove reais"),
//            # (99.05, "noventa e nove reais e cinco centavos"),
//            # (99.99, "noventa e nove reais e noventa e nove centavos"),
//            ]



    TratarCheque cheque = new TratarCheque();

    @Test
    public void passandoUmCentavoTest(){
        String retorno = cheque.extenso(0.01);

        Assert.assertEquals("um centavo", retorno);
    }

    @Test
    public void passandoCincoCentavosTest(){
        String retorno = cheque.extenso(0.05);

        Assert.assertEquals("cinco centavos", retorno);
    }

    @Test
    public void passandoCinquentaCentavosTest(){
        String retorno = cheque.extenso(0.50);

        Assert.assertEquals("cinquenta centavos", retorno);
    }

    @Test
    public void passandoUmRealTest(){
        String retorno = cheque.extenso(1.00);

        Assert.assertEquals("um real", retorno);
    }

    @Test
    public void passandoUmRealEUmCentavoTest(){
        String retorno = cheque.extenso(1.01);

        Assert.assertEquals("um real e um centavo", retorno);
    }

    @Test
    public void passandoUmRealECincoCentavosTest(){
        String retorno = cheque.extenso(1.05);

        Assert.assertEquals("um real e cinco centavos", retorno);
    }

    @Test
    public void passandoUmRealENoventaENoveCentavosTest(){
        String retorno = cheque.extenso(1.99);

        Assert.assertEquals("um real e noventa e nove centavos", retorno);
    }

    @Test
    public void passandoCincoReaisTest(){
        String retorno = cheque.extenso(5.00);

        Assert.assertEquals("cinco reais", retorno);
    }

    @Test
    public void passandoDezReaisTest(){
        String retorno = cheque.extenso(10.00);

        Assert.assertEquals("dez reais", retorno);
    }

    @Test
    public void passandoQuinzeReaisTest(){
        String retorno = cheque.extenso(15.00);

        Assert.assertEquals("quinze reais", retorno);
    }

    @Test
    public void passandoDezenoveReaisTest(){
        String retorno = cheque.extenso(19.00);

        Assert.assertEquals("dezenove reais", retorno);
    }

    @Test
    public void passandoVinteReaisTest(){
        String retorno = cheque.extenso(20.00);

        Assert.assertEquals("vinte reais", retorno);
    }

    @Test
    public void passandoVinteEUmReaisTest(){
        String retorno = cheque.extenso(21.00);

        Assert.assertEquals("vinte e um reais", retorno);
    }

    @Test
    public void passandoOitentaECincoReaisTest(){
        String retorno = cheque.extenso(85.00);

        Assert.assertEquals("oitenta e cinco reais", retorno);
    }

    @Test
    public void passandoNoventaENoveReaisTest(){
        String retorno = cheque.extenso(99.00);

        Assert.assertEquals("noventa e nove reais", retorno);
    }

    @Test
    public void passandoNoventaENoveReaisECincoCentavosTest(){
        String retorno = cheque.extenso(99.05);

        Assert.assertEquals("noventa e nove reais e cinco centavos", retorno);
    }

    @Test
    public void passandoNoventaENoveReaisENoventaENoveCentavosTest(){
        String retorno = cheque.extenso(99.99);

        Assert.assertEquals("noventa e nove reais e noventa e nove centavos", retorno);
    }


}
