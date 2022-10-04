package JDBC.ModeloAntigo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //Passando as informações para um DataSource
    public DataSource dataSource;

    public ConnectionFactory() {

        //Criando um pool de conexões
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //Passando a url do jdbc, conexão com o banco de dados
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
        //setando o usuário do banco de dados
        comboPooledDataSource.setUser("root");
        //setando a senha do banco de dados
        comboPooledDataSource.setPassword("Nary0000");

        //Setando o número máximo de conexões
        comboPooledDataSource.setMaxPoolSize(15);

        //Passando que a estrutura de dados é igual ao comboPooledDataSource;
        this.dataSource = comboPooledDataSource;
    }

    //Método para abrir a conexão com o banco de dados;
    public Connection recuperaconexao() throws SQLException {
        return this.dataSource.getConnection();
    }
}
