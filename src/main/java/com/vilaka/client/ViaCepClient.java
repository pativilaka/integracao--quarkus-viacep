package com.vilaka.client;


import com.vilaka.dto.EnderecoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/ws/{cep}/json/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "viacep-api")
@ApplicationScoped
public interface ViaCepClient {

    @GET
    EnderecoDto buscarEnderecoPorCep(@PathParam("cep") String cep);

}
