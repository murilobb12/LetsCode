package br.com.rest;


import br.com.model.Cliente;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/clientes")
@RequestScoped
public class ClienteResource
{

    @POST
    public Response inserirCliente(Cliente entrada){

        System.out.println(entrada.getIdade());


        return Response.status(Response.Status.OK.getStatusCode()).entity("Teste").build();


    }


}
