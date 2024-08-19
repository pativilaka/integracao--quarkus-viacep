package com.vilaka.service.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CepNotFoundExceptionMapper implements ExceptionMapper<CepNotFoundException> {
    @Override
    public Response toResponse(CepNotFoundException e) {
        ResponseError error = new ResponseError(e.getMessage());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error).build();

    }
}
