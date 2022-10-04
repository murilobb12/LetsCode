package JDBC.ModeloNovo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ExecutaQuery {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperaConexao()) {

            ProdutoDao produtoDao = new ProdutoDao(connection);

            CategoriaDao categoriaDao = new CategoriaDao(connection);

            List<Categoria> list = categoriaDao.listar();

            list.stream().map(Categoria::getNome).forEach(System.out::println);






//        Produto camisa = new Produto("Camisa", "Camisa Polo Masculina G");
//
//        produtoDao.salvar(camisa);
//
//        System.out.println(produtoDao.selectById(camisa));

//        produtoDao.updateDescricaoById("Testando atualização", camisa);


//        System.out.println (produtoDao.select());

//        System.out.println(produtoDao.selectById(camisa));

//        produtoDao.deletar(camisa);
        }


    }


}
