package br.com.murilo.service;

import br.com.murilo.model.SolicitacaoRetorno;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://apis-gateway-h.bndes.gov.br/fg2/v1/honra")
public interface BndesProxy {


    @GET
    @Path("solicitacoes/76780")
    SolicitacaoRetorno solicitacaoRetorno(@HeaderParam("Authorization")String token);

    @GET
    @Path("solicitacoes/76780")
    SolicitacaoRetorno solicitacaoRetorno();

}
