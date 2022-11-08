package br.com.murilo.rest;

import br.com.murilo.dto.FuncionarioDto;
import br.com.murilo.model.Funcionario;
import br.com.murilo.repository.FuncionarioRepository;
import br.com.murilo.service.FuncionarioService;
import org.hibernate.validator.internal.metadata.aggregated.MetaDataBuilder;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("funcionarios")
public class FuncionarioResource {

    @Inject
    FuncionarioService funcionarioService;

    @GET
    public Response listarFuncionarios(){
        return Response.status(Response.Status.OK).entity(funcionarioService.listarFuncionarios()).build();
    }

    @Path("/list")
    @POST
    public Response salvarListFuncionarios(@Valid List<FuncionarioDto> dto){
        return Response.status(Response.Status.CREATED.getStatusCode()).entity(funcionarioService.salvarListFuncionario(dto)).build();
    }

    @POST
    public Response salvarFuncionarios(@Valid FuncionarioDto dto){
        return Response.status(Response.Status.CREATED.getStatusCode()).entity(funcionarioService.salvarFuncionario(dto)).build();
    }

    @Path("/{id}")
    @GET
    public Response listarFuncionariosById(@PathParam("id") Long id){
        return Response.status(Response.Status.OK.getStatusCode()).entity(funcionarioService.listarFuncionariosById(id)).build();
    }

    @Path("/{id}")
    @PUT
    public Response atualizarFuncionario(@PathParam("id")Long id, FuncionarioDto funcionarioDto){
        return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(funcionarioService.atualizarFuncionario(id, funcionarioDto)).build();
    }

    @Path("{id}")
    @DELETE
    public Response deletarFuncionarioById(@PathParam("id")Long id){
        return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(funcionarioService.deletarFuncionarioByID(id)).build();
    }


}
