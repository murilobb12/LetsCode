package JDBC.ModeloNovo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    DataSource dataSource;

    public ConnectionFactory() {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("Nary0000");
        comboPooledDataSource.setMaxPoolSize(20);

        this.dataSource = comboPooledDataSource;


    }


    public Connection recuperaConexao() throws SQLException {
        return this.dataSource.getConnection();
    }

}
