package br.com.murilo.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@SqlResultSetMapping(name = "ClienteMapping",
                    entities = @EntityResult(
                            entityClass = Cliente.class,
                            fields = {
                                    @FieldResult(name = "id", column = "id"),
                                    @FieldResult(name = "idade", column = "idade"),
                                    @FieldResult(name = "nome",  column = "nome")
                            }))
@NamedNativeQueries({
        @NamedNativeQuery(name = "CONSULTAR_USUARIO", query = "SELECT * FROM Cliente c", resultClass = Cliente.class),
        @NamedNativeQuery(name = "CONSULTAR_USUARIO_ID", query = "SELECT * FROM Cliente c WHERE c.id = ?1", resultSetMapping = "ClienteMapping"),
        @NamedNativeQuery(name = "DELETAR_USUARIO_ID", query = "DELETE FROM Cliente c WHERE c.id = ?1")

})
@Table(name = "Cliente")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

}
