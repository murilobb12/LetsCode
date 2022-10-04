package JDBC.ModeloAntigo;

import java.sql.*;

public class InsertDBTryCatch {


    public static void main(String[] args) throws SQLException {


        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaconexao()) {
            connection.setAutoCommit(false);


            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {

                adcionarProduto("Tenis Nike", "Tenis Nike Masculino Tamanho: 42", preparedStatement);
                adcionarProduto("Chave Ford", "Chave Ford Ka 2019", preparedStatement);

                connection.commit();
                System.out.println("COMMIT REALIZADO!");

            } catch (Exception e) {
                e.printStackTrace();

                connection.rollback();
                System.out.println("ROLLBACK EXECUTADO!");
            }
        }
    }




    //Criando função para passar os valores para o PreparedStatement
    private static void adcionarProduto(String nome, String descricao, PreparedStatement preparedStatement) throws SQLException {

        //Passando o valor para a 1 instrução do statement
        preparedStatement.setString(1, nome);
        //Passando o vlaor para a 2 instrução do statement
        preparedStatement.setString(2, descricao);


        //Forçando uma exeção
        if (nome.equals("Chave Ford")) {
            throw new RuntimeException("Produto não adicionado!");
        }

        //executando o Statement
        preparedStatement.execute();


        //Pegando as chaves geradas no resultSet
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {


            //Navegando dentro do resultSet, até o valor gerado e informando o ID
            while (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                System.out.println("ID gerado: " + id);
            }
        }
    }

}
