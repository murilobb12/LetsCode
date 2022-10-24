package br.com.murilo.resource;


import br.com.murilo.model.Usuario;
import br.com.murilo.repository.UsuarioRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @POST
    public Usuario inserirUsuario(Usuario usuario){

        usuario.persist();

        return usuario;

    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public List<Usuario> listarUsuario(){

        return usuarioRepository.listAll();

    };

    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @DELETE
    public void deletarUsuarioId(Usuario usuario){

        usuarioRepository.deleteById(usuario.getId());



    }







}
