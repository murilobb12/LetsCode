package JDBC;

import java.sql.*;

public class InsertDBParameters {

    public static void main(String[] args) throws SQLException {

        String nome = "Teclado";
        String descricao = "Teclado Razer sem fio";


        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        while (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);
            System.out.println("Id gerado: " + id);
        }

        connection.close();
    }


}
