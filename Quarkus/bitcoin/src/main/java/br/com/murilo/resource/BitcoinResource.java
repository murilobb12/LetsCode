package br.com.murilo.resource;

import br.com.murilo.model.Bitcoin;
import br.com.murilo.service.BitcoinService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
public class BitcoinResource {

    @Inject
    @RestClient
    BitcoinService bitcoinService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar(){
        return bitcoinService.listarOperacoesBitcoin();
    }


}
