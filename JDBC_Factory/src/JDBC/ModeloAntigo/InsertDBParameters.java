package JDBC.ModeloAntigo;

import java.sql.*;

public class InsertDBParameters {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);

        adicionarProduto("Notebook", "Notebook Dell Inpsiron 14'", preparedStatement);
        adicionarProduto("Placa de Vídeo", "Placa de Vídeo NVIDA GFORCE GTX 970", preparedStatement);
    }

    private static void adicionarProduto(String nome, String descricao,  PreparedStatement preparedStatement) throws SQLException {

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        while (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);
            System.out.println("Id gerado: " + id);
        }

        generatedKeys.close();
    }


}
