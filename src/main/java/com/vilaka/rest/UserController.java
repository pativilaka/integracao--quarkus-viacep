package com.vilaka.rest;

import com.vilaka.dto.UserDto;
import com.vilaka.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional
    public Response cadastraUser(UserDto dto){
        UserDto userDto = userService.cadastraUser(dto);
        return Response.status(Response.Status.CREATED).entity(userDto).build();

    }
}
