package br.com.murilo.rest;


import br.com.murilo.dto.UserRequest;
import br.com.murilo.model.User;
import br.com.murilo.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserRepository userRepository;

    @Inject
    Validator validator;


    @Transactional
    @POST
    public Response createUser(@Valid UserRequest userRequest) {

        User user = new User();

        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        userRepository.persist(user);

        return Response.status(Response.Status.CREATED.getStatusCode()).entity(user).build();
    }

    @GET
    public Response listAllUsers() {

//        PanacheQuery<PanacheEntityBase> users = User.findAll();

        List<User> users = userRepository.listAll();

        return Response.status(Response.Status.OK).entity(users).build();
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {



        User user;

        Optional<User> userOptional = userRepository.findByIdOptional(id);

        if (userOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        user = userOptional.get();

        userRepository.delete(user);

        return Response.ok().status(200).build();

    }


    @Transactional
    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id, UserRequest userRequest) {

        User user = userRepository.findById(id);

        if (user != null) {
            user.setAge(userRequest.getAge());
            user.setName(userRequest.getName());

            return Response.ok(user).status(200).build();
        }
        return Response.status(Response.Status.NOT_FOUND.getStatusCode()).build();
    }

}