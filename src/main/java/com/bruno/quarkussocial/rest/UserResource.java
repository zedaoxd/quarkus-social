package com.bruno.quarkussocial.rest;

import com.bruno.quarkussocial.domain.model.User;
import com.bruno.quarkussocial.domain.repository.UserRepository;
import com.bruno.quarkussocial.rest.dto.CreateUserRequest;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GET
    public Response listAllUsers() {
        return Response.ok(repository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
        User user = repository.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    @Transactional
    public Response createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setAge(request.age());
        repository.persist(user);
        return Response.ok(user).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest request) {
        User user = repository.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        user.setName(request.name());
        user.setAge(request.age());
        repository.persist(user);
        return Response.ok(user).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartialUser(@PathParam("id") Long id, CreateUserRequest request) {
        User user = repository.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (request.name() != null) {
            user.setName(request.name());
        }
        if (request.age() != null) {
            user.setAge(request.age());
        }
        repository.persist(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        User user = repository.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.delete(user);
        return Response.noContent().build();
    }

}
