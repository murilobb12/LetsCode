package br.com.murilo.rest;

import br.com.murilo.dto.DepartamentoDto;
import br.com.murilo.model.Departamento;
import br.com.murilo.service.DepartamentoService;
import io.quarkus.logging.Log;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/departamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentoResource {

    //    private static final Logger LOG = Logger.getLogger(DepartamentoResource.class);

    @Inject
    DepartamentoService departamentoService;

    @GET
    public Response listarDep(){
        Log.error("Lista Retornada " + LocalDateTime.now());

        return Response.status(Response.Status.OK.getStatusCode()).entity(departamentoService.listarDep()).build();
    }

    @Path("/list")
    @Transactional
    @POST
    public Response salvarDepList(@Valid List<DepartamentoDto> departamentoDto){
        return Response.status(Response.Status.CREATED.getStatusCode()).entity(departamentoService.salvarDepList(departamentoDto)).build();
    }

    @Transactional
    @POST
    public Response salvarDep(@Valid DepartamentoDto departamentoDto){
        return Response.status(Response.Status.CREATED.getStatusCode()).entity(departamentoService.salvarDep(departamentoDto)).build();
    }

    @Path("/{id}")
    @GET
    public Response listarDepById(@PathParam("id")Long id){
        return Response.status(Response.Status.OK.getStatusCode()).entity(departamentoService.listDepById(id)).build();
    }


    @Transactional
    @Path("{id}")
    @PUT
    public Response atualizarDepById(@PathParam("id")Long id, DepartamentoDto departamentoDto){
        return Response.status(Response.Status.OK.getStatusCode()).entity(departamentoService.atualizarDep(id, departamentoDto)).build();
    }

    @Transactional
    @Path("/{id}")
    @DELETE
    public Response deleteDep(@PathParam("id")Long id){
        departamentoService.deletarDep(id);
        return Response.status(Response.Status.NO_CONTENT.getStatusCode()).build();
    }


}


