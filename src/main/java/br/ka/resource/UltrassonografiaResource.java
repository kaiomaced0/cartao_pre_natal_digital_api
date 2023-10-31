package br.ka.resource;

import br.ka.model.Ultrassonografia;
import br.ka.service.UltrassonografiaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ultrassonografia")
public class UltrassonografiaResource {
    @Inject
    private UltrassonografiaService service;


    @GET
    public List<Ultrassonografia> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Ultrassonografia getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Ultrassonografia create(Ultrassonografia entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Ultrassonografia update(@PathParam("id") Long id, Ultrassonografia entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
