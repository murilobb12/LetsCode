package br.com.murilo.service;

import br.com.murilo.model.Bitcoin;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;


@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listarOperacoesBitcoin();




}
