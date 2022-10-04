package JDBC.ModeloAntigo;

import java.sql.*;

public class InsertDBParametersCommit {


    public static void main(String[] args) throws SQLException {


        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        //Setando o autoCommit para false, assim será necessário dar o commit via código
        connection.setAutoCommit(false);


        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        adicionarProduto(preparedStatement, "Cabo RJ-45", "Cabo RJ-45 - 5 metros");


        //Realizando o commit para adicionar as instruções passadas.
        connection.commit();


    }

    private static void adicionarProduto(PreparedStatement preparedStatement, String nome, String descricao) throws SQLException {

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        while (generatedKeys.next()) {
            Integer id = generatedKeys.getInt(1);
            System.out.println("ID gerado: " + id);
        }

        preparedStatement.close();

    }

}
