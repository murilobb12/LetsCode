package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB {

    public static void main(String[] args) throws SQLException {

        //Cria a conexão e atrela ao Connection Factory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        //Criando um statement para podermos trabalhar as queries
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > 3");

        //Passando a query para o statement
        preparedStatement.execute();

        //Adicionar a variavel o total de linhas deletadas
        Integer linhasModificadas = preparedStatement.getUpdateCount();

        System.out.println("Total de linhas excluídas: " + linhasModificadas);

        connection.close();


    }


}
