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
    FuncionarioRepository funcionarioRepository;

    @Inject
    FuncionarioService funcionarioService;

    @GET
    public Response listarFuncionarios(){

        return Response.status(Response.Status.OK).entity(funcionarioService.listarFuncionarios()).build();

    }


    @POST
    public Response salvarFuncionarios(@Valid FuncionarioDto dto){

        return Response.status(Response.Status.CREATED.getStatusCode()).entity(funcionarioService.salvarFuncionario(dto)).build();

    }

}
