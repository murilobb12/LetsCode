package JDBC;

import java.sql.*;

public class InsertDB {


    public static void main(String[] args) throws SQLException{


        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        //Passamos a conexão para um statement
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES('Patins', 'Patins Billabong'),('Prancha de Surf', 'Prancha de Surf Quicksilver')", Statement.RETURN_GENERATED_KEYS);
        //Criamos a query de INSERT, e também passamos o Statement.RETURN_GENERATED_KEYS, para pegarmos a(s) chave(s) que foram geradas
        preparedStatement.execute();
        //Passa as chaves geradas para um ResultSet
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        //Itera o result set com o next, para imprimir tudo que foi adicionado
        while (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);
            System.out.println("O id gerado foi o: " + id);
        }


        connection.close();







    }




}
