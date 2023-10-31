package br.ka.resource;

import br.ka.model.Medico;
import br.ka.service.MedicoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/medico")
public class MedicoResource {
    @Inject
    private MedicoService service;


    @GET
    public List<Medico> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Medico getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Medico create(Medico entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Medico update(@PathParam("id") Long id, Medico entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
