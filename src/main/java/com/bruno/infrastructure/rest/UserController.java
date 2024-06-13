package com.bruno.infrastructure.rest;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.infrastructure.service.UserService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response get() {
        var users = userService.get();
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        var user = userService.getById(id);
        return Response.ok(user).build();
    }

    @POST
    public Response create(UserCreateDTO dto) {
        var user = userService.create(dto);
        return Response.ok(user).build();
    }
}
