package br.ka.resource;

import br.ka.dto.UltrassonografiaDTO;
import br.ka.dto.UltrassonografiaResponseDTO;
import br.ka.model.EntityClass;
import br.ka.model.Ultrassonografia;
import br.ka.service.UltrassonografiaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ultrassonografia")
public class UltrassonografiaResource {
    @Inject
    private UltrassonografiaService service;

    @GET
    public List<UltrassonografiaResponseDTO> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public UltrassonografiaResponseDTO getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Path("/{id}")
    public Response create(UltrassonografiaDTO entity, @PathParam("id") Long id) {
        return service.create(entity, id);
    }

    @PUT
    @Path("/{id}")
    public UltrassonografiaResponseDTO update(@PathParam("id") Long id, UltrassonografiaDTO entity) {
        return service.update(entity, id);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id);
    }
}
