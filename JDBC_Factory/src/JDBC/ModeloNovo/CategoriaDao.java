package JDBC.ModeloNovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDao {

    Connection connection;

    public CategoriaDao(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categoriaList = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    categoriaList.add(new Categoria(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        }
        return categoriaList;
    }

    public List<?> listaCategoriaInnerProduto() throws SQLException{

        List<?> list = new ArrayList<>();

        String sql =    "SELECT * FROM CATEGORIA C " +
                        "INNER JOIN PRODUTO P" +
                        "ON C.ID = P.CATEGORIA_ID";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    list.add(Optional<Categoria, Produto>)
                }
            }
        }

    }




}
