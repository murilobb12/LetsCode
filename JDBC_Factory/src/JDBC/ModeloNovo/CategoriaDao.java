package JDBC.ModeloNovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
