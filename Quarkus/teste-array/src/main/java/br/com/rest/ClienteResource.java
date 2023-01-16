package br.com.rest;


import br.com.model.Cliente;
import br.com.model.Entrada;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/clientes")
@RequestScoped
public class ClienteResource
{

    @POST
    public Response inserirCliente(Entrada entrada){


        return Response.status(Response.Status.OK.getStatusCode()).entity(entrada).build();



    }

}
