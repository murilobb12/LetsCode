package br.com.murilo.repository;

import br.com.murilo.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> clienteListBasic(){
        return listAll();
    }

    public List<Cliente> clienteListNamed(){

        Query usuarios = getEntityManager().createNamedQuery("CONSULTAR_USUARIO");

        return usuarios.getResultList();

    }

    public Cliente clienteListById(Long id){


            Optional<Cliente> byIdOptional = findByIdOptional(id);
            byIdOptional.orElseThrow(() -> new NotFoundException("ID não encontrado"));


        TypedQuery<Cliente> usuario_id = getEntityManager().createNamedQuery("CONSULTAR_USUARIO_ID", Cliente.class).setParameter(1,id);

        return usuario_id.getSingleResult();

    }

    public void clienteDeleteById(){

        Query deletar_usuario_id = getEntityManager().createNamedQuery("DELETAR_USUARIO_ID").setParameter(1, 2);

        deletar_usuario_id.executeUpdate();


    }



}
