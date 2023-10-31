package br.ka.resource;

import br.ka.model.Mamae;
import br.ka.service.MamaeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/mamae")
public class MamaeResource {
    @Inject
    private MamaeService service;


    @GET
    public List<Mamae> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Mamae getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Mamae create(Mamae entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Mamae update(@PathParam("id") Long id, Mamae entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
