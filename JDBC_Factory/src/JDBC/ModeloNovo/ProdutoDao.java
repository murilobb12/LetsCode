package JDBC.ModeloNovo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;


    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                System.out.println("Produto salvo com sucesso. ID:" + resultSet.getString(1));
                produto.setId(resultSet.getInt(1));
            }
        }
    }

    public void deletar(Produto produto) throws SQLException {


        String sql = "DELETE FROM PRODUTO WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, String.valueOf(produto.getId()));
            preparedStatement.execute();
            Integer linhasModificadas = preparedStatement.getUpdateCount();

            System.out.println("Deleção concluída! Total de linhas excluídas: " + linhasModificadas);

            }
        }




    public List<Produto> select() throws SQLException {

        List<Produto> produtoList = new ArrayList<>();


        String sql = "SELECT * FROM PRODUTO";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getNString(3));

                    produtoList.add(produto);
                }
                return produtoList;
            }


        }


    }

    public Produto selectById(Produto produto) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, String.valueOf(produto.getId()));
            preparedStatement.execute();

            Produto produtoSelecionado = new Produto(produto.getId(), produto.getNome(), produto.getDescricao());

            return produtoSelecionado;

        }


    }

    public void updateDescricaoById(String descricao, Produto produto) throws SQLException {

        String sql = "UPDATE PRODUTO SET descricao = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, descricao);
            preparedStatement.setString(2, String.valueOf(produto.getId()));
            preparedStatement.execute();


        }
        System.out.println("Produto atualizado com sucesso!");




    }

}
