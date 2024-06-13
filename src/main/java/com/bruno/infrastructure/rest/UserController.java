package com.bruno.infrastructure.rest;

import java.net.URI;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.dto.users.UserEditDTO;
import com.bruno.infrastructure.service.UserService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
        URI uri = URI.create("/users/" + user.getId());
        return Response.created(uri).entity(user).build();
    }

    @PATCH
    @Path("/{id}")
    public Response edit(UserEditDTO dto, @PathParam("id") Long id) {
        var user = userService.edit(dto, id);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Long id) {
        userService.remove(id);
        return Response.noContent().build();
    }
}
