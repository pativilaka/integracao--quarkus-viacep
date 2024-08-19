package com.vilaka.rest;

import com.vilaka.client.ViaCepClient;
import com.vilaka.dto.CepDto;
import com.vilaka.dto.EnderecoDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/enderecos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoController {

    @RestClient
    ViaCepClient viaCepClient;

    @POST
    public Response buscarCep(CepDto cepDto){
        EnderecoDto enderecoDto = viaCepClient.buscarEnderecoPorCep(cepDto.getCep());
        if (enderecoDto != null){
            return Response.ok().entity(enderecoDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
