package br.ka.resource;

import br.ka.model.Exame;
import br.ka.service.ExameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/exame")
public class ExameResource {
    @Inject
    private ExameService service;


    @GET
    public List<Exame> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Exame getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Exame create(Exame entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Exame update(@PathParam("id") Long id, Exame entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
