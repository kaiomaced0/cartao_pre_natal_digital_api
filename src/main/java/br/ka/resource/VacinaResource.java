package br.ka.resource;

import br.ka.model.Vacina;
import br.ka.service.VacinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/vacina")
public class VacinaResource {
    @Inject
    private VacinaService service;


    @GET
    public List<Vacina> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Vacina getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Vacina create(Vacina entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Vacina update(@PathParam("id") Long id, Vacina entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
