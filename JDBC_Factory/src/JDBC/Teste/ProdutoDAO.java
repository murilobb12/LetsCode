package JDBC.Teste;

import JDBC.ModeloAntigo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void deleteById(Produtos produtos) throws SQLException {

        String sql = "DELETE FROM PRODUTO WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, String.valueOf(produtos.getId()));
            preparedStatement.execute();
        }

        System.out.println("Produto deletado com sucesso!");

    }

    public List<Produtos> selectAll() throws SQLException {

        List<Produtos> produtoList = new ArrayList<>();

        String sql = "SELECT * FROM PRODUTO";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    Produtos produto = new Produtos(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

                    produtoList.add(produto);
                }
            return produtoList;
            }
        }


    }

    public void insert( String nome, String descricao) throws SQLException {

        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);

            preparedStatement.execute();
        }



    }






}
