package br.com.murilo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categorias")
public class CategoriaResource {

    @Inject
    Categoria categoria;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> categoriaList(){
        return categoria.listarCategorias();
    }

    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Categoria insereCategoria(Categoria categoria){
        categoria.persist();
        return categoria;

    }




}
