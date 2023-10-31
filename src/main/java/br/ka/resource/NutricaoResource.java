package br.ka.resource;

import br.ka.model.Nutricao;
import br.ka.service.NutricaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/nutricao")
public class NutricaoResource {
    @Inject
    private NutricaoService service;


    @GET
    public List<Nutricao> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Nutricao getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Nutricao create(Nutricao entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Nutricao update(@PathParam("id") Long id, Nutricao entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
