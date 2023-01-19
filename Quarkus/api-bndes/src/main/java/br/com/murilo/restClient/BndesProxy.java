package br.com.murilo.restClient;

import br.com.murilo.model.bndes.*;
import br.com.murilo.token.GerarToken;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("solicitacoes")
@RegisterRestClient(configKey = "api-bndes")
public interface BndesProxy {


    @GET
    @Path("operacao/credito-livre/{idOperacaoAgente}")
    public SolicitacaoHonraConsultaDTO listarSolicitacaoAgente(@HeaderParam("Authorization") String token, @PathParam("idOperacaoAgente") Long idOperacaoAgente);

    @GET
    @Path("/{idSolicitacao}")
    public SolicitacaoRetorno listarSolicitacao(@HeaderParam("Authorization") String token, @PathParam("idSolicitacao")Long idSolicitacao);


}
