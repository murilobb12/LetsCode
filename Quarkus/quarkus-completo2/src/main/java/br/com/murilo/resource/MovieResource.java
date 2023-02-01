package br.com.murilo.resource;

import br.com.murilo.model.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/movies")
public class MovieResource {

    List<Movie> movieList = new ArrayList<>();

    @GET
    public Response listMovies() {

        return Response.status(Response.Status.OK.getStatusCode()).entity(movieList).build();

    }

    @POST
    public Response insertMovie(Movie newMovie) {

        movieList.add(newMovie);

        return Response.status(Response.Status.OK.getStatusCode()).build();

    }

    @GET
    @Path("/count")
    public Response countMovies() {

        int size = movieList.size();

        return Response.status(Response.Status.OK).entity(size).build();
    }

    @PUT
    public Response updateMovie(Movie updatedMovie) {


        movieList = movieList.stream().peek(movie -> {
            if (movie.getId().equals(updatedMovie.getId())) {
                movie.setTitle(updatedMovie.getTitle());
            }

        }).collect(Collectors.toList());


        return Response.status(Response.Status.OK.getStatusCode()).entity(movieList).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {

        Optional<Movie> movieToDelete = movieList.stream().filter(movie -> movie.getId().equals(id)).findFirst();

        boolean removed = false;

        if (movieToDelete.isPresent()){
             removed = movieList.remove(movieToDelete.get());
        }


        return removed ? Response.status(Response.Status.OK.getStatusCode()).build() :
                Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();

    }


}
