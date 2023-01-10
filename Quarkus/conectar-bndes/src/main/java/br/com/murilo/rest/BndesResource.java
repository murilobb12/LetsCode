package br.com.murilo.rest;

import br.com.murilo.service.BndesProxy;
import br.com.murilo.service.GerarToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;

@RequestScoped
@Path("/png")
public class BndesResource {


    @RestClient
    @Inject
    BndesProxy proxy;

    GerarToken token;

    @GET
    public Response listarSolicitacao() throws IOException, InterruptedException {

        proxy.solicitacaoRetorno(token.gerarToken());

        return Response.status(Response.Status.OK.getStatusCode()).build();
    }


}
