package br.com.murilo.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.murilo.model.Bitcoin;
@Path("/bitcoins")
@RegisterRestClient
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Bitcoin> listar();


}
