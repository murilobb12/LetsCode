package br.com.murilo.resource;

import br.com.murilo.model.bndes.EntradaLoteSolicitacoesHonraDTO;
import br.com.murilo.restClient.BndesProxy;
import br.com.murilo.token.GerarToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


import org.jboss.logging.Logger;

@Path("bndes")
public class BndesResource {

    private static final Logger LOG = Logger.getLogger(BndesResource.class);

    @Inject
    @RestClient
    BndesProxy bndesProxy;

    @Inject
    GerarToken token;

    @Inject
    EntradaLoteSolicitacoesHonraDTO entradaLoteSolicitacoesHonraDTO;

    @GET
    public Response status() {
        return Response.status(Response.Status.OK).entity("live").build();
    }


    public static String teste() throws  InterruptedException {


        for (int i = 5160; i >= 1; i--) {

            Thread.sleep(1000);
            LOG.info(i);

        }


        return "Acabou, Adeus. Bye Bye!";
    }


    /**
     *
     * Consultar resultado de um protocolo de solicitações de honra.
     * Essa consulta é através o id da solicitação gerado
     */
    @GET
    @Path("solicitacoes/operacaoAgente/{idOperacaoAgente}")
    public Response listarOperacaoAgente(@PathParam("idOperacaoAgente") Long idOperacaoAgente) throws IOException, InterruptedException {
        return Response.status(Response.Status.OK).entity(bndesProxy.listarSolicitacaoAgente(token.gerarToken(), idOperacaoAgente)).build();
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
        LOG.info(loteSolicitacoesHonraDTO);
        LOG.error("FATALERROR!");
        LOG.error(teste());
//        System.out.println("inicio");
//        System.out.println(loteSolicitacoesHonraDTO);
//        System.out.println("fim");

        return Response.status(Response.Status.OK.getStatusCode()).entity(bndesProxy.inserirSolicitacao(token.gerarToken(), loteSolicitacoesHonraDTO)).build();
    }

    @GET
    @Path("teste")
    public Response teste(EntradaLoteSolicitacoesHonraDTO loteSolicitacoesHonraDTO) {



        return Response.status(Response.Status.OK.getStatusCode()).build();

    }

}
