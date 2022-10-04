package JDBC.ModeloAntigo;

import java.sql.*;

public class SelectDB {


    public static void main(String[] args) throws SQLException {

        int parametro = 10;



        //Abrindo a conexão com o banco de dados
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "Nary0000");

        //Abrindo conexão com o banco de dados através de ma classe
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaconexao();

        //Criando o statement para poder passarmos a query
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUTO WHERE ID > ?");

        //Executando o statement
        preparedStatement.setString(1, String.valueOf(parametro));
        preparedStatement.execute();

        //Fazendo com que o statment retorne o que achou para um Set
        ResultSet rst = preparedStatement.getResultSet();

        //Criando um laço, para percorrer todos os registros
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.print(id +  " | ");
            String nome = rst.getString(2);
            System.out.print(nome + " | ");
            String descricao = rst.getString(3);
            System.out.print(descricao);
            System.out.println();
        }

        System.out.println("Fechando conexão");
        connection.close();

    }


}
