package br.com.murilo.service;

import br.com.murilo.model.bndes.SolicitacaoHonraConsultaDTO;
import br.com.murilo.model.bndes.SolicitacaoRetorno;
import br.com.murilo.restClient.BndesProxy;
import br.com.murilo.token.GerarToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class BndesService {

    @Inject
    @RestClient
    BndesProxy bndesProxy;

    @Inject
    GerarToken token;

    public SolicitacaoHonraConsultaDTO listarOperacaoAgente(Long idOperacaoAgente) throws IOException, InterruptedException {

        return bndesProxy.listarSolicitacaoAgente(token.gerarToken(), idOperacaoAgente);

    }


}