package br.ka.resource;

import br.ka.model.Gestacao;
import br.ka.service.GestacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/gestacao")
public class GestacaoResource {
    @Inject
    private GestacaoService service;


    @GET
    public List<Gestacao> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Gestacao getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Gestacao create(Gestacao entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Gestacao update(@PathParam("id") Long id, Gestacao entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
