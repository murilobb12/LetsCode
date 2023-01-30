package br.com.murilo.resource;

import br.com.murilo.model.bndes.EntradaLoteSolicitacoesHonraDTO;
import br.com.murilo.model.bndes.SolicitacaoHonraConsultaDTO;
import br.com.murilo.restClient.BndesProxy;
import br.com.murilo.service.BndesService;
import br.com.murilo.token.GerarToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.ParseException;


@Path("bndes")
public class BndesResource {

    private static final Logger LOG = Logger.getLogger(BndesResource.class);

    @Inject
    @RestClient
    BndesProxy bndesProxy;

    @Inject
    GerarToken token;

    @Inject
    BndesService bndesService;

//    @Inject
//    StatusService statusService;


    @Inject
    EntradaLoteSolicitacoesHonraDTO entradaLoteSolicitacoesHonraDTO;

    @GET
    public Response status() {
        return Response.status(Response.Status.OK).entity("live").build();
    }


    /**
     * Consultar resultado de um protocolo de solicitações de honra.
     * Essa consulta é através o id da solicitação gerado
     */
    @GET
    @Path("solicitacoes/operacaoAgente/{idOperacaoAgente}")
    public Response listarOperacaoAgente(@PathParam("idOperacaoAgente") Long idOperacaoAgente) throws IOException, InterruptedException {

        LOG.info("GET ID AGENTE FINANCEIRO: " + idOperacaoAgente);
        return Response.status(Response.Status.OK).entity(bndesProxy.listarSolicitacaoAgente(token.gerarToken(), idOperacaoAgente)).build();
    }

    @GET
    @Path("solicitacoes/operacaoAgente/retorno/{idOperacaoAgente}")
    public Response listarOperacaoAgenteRetorno(@PathParam("idOperacaoAgente")Long idOperacaoAgente) throws IOException, InterruptedException {

        SolicitacaoHonraConsultaDTO solicitacaoHonraConsultaDTO = bndesService.listarOperacaoAgente(idOperacaoAgente);

        return Response.status(Response.Status.OK.getStatusCode()).build();
    }



    /**
     * Consultar solicitação de honra de uma operação de crédito livre.
     * Essa consulta é através da operação pelo Agente Financeiro
     */
    @GET
    @Path("solicitacoes/{idSolicitacao}")
    public Response listarSolicitacao(@PathParam("idSolicitacao") Long idSolicitacao) throws IOException, InterruptedException {
        return Response.status(Response.Status.OK).entity(bndesProxy.listarSolicitacao(token.gerarToken(), idSolicitacao)).build();
    }

    /**
     * Protocolar solicitações de honra.
     * Inserir solicitação de honra através do método POST, passando o lote de solicitações de honra
     */
    @POST
    @Path("solicitacoes")
    public Response inserirSolicitacoes(EntradaLoteSolicitacoesHonraDTO loteSolicitacoesHonraDTO) throws IOException, InterruptedException, ParseException {

        return Response.status(Response.Status.OK.getStatusCode()).entity(bndesProxy.inserirSolicitacao(token.gerarToken(), loteSolicitacoesHonraDTO).idSolicitacao).build();
    }

    @GET
    @Path("teste")
    public Response teste(EntradaLoteSolicitacoesHonraDTO loteSolicitacoesHonraDTO) {
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

}
