package JDBC.ModeloAntigo;

import java.sql.*;

public class InsertDBClasseProduto {


    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto();
        Produto meia = new Produto("Meia Adidas", "Meia adidas tamanho 37-42");

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recuperaconexao()){
            String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                preparedStatement.setString(1, meia.getNome());
                preparedStatement.setString(2, meia.getDescricao());

                preparedStatement.execute();

                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    while (resultSet.next()){
                        meia.setId(resultSet.getInt(1));
                    }
                }


            }
        }


        System.out.println(meia);








    }




}
