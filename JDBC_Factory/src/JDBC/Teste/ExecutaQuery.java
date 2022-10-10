package JDBC.Teste;

import JDBC.ModeloNovo.ConnectionFactory;
import JDBC.ModeloNovo.ProdutoDao;

import java.sql.SQLException;

public class ExecutaQuery {

    public static void main(String[] args) throws SQLException {


        ConecctionFactory connectionFactory = new ConecctionFactory();

        ProdutoDAO produtoDao = new ProdutoDAO(connectionFactory.efetuaConexao());

        System.out.println(produtoDao.selectAll());





    }

}
